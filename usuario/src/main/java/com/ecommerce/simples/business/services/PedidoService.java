package com.ecommerce.simples.business.services;


import com.ecommerce.simples.business.dto.Request.PedidoRequestDTO;
import com.ecommerce.simples.business.dto.Response.PedidoResponseDTO;
import com.ecommerce.simples.business.mapstruct.PedidoMapper;
import com.ecommerce.simples.infrastructure.entities.PedidoEntity;
import com.ecommerce.simples.infrastructure.entities.ProdutoEntity;
import com.ecommerce.simples.infrastructure.entities.UsuarioEntity;
import com.ecommerce.simples.infrastructure.repositories.PedidoRepository;
import com.ecommerce.simples.infrastructure.repositories.ProdutoRepository;
import com.ecommerce.simples.infrastructure.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class PedidoService {

    private final UsuarioRepository usuarioRepository;
    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;
    private final ProdutoRepository produtoRepository;

    public PedidoService(UsuarioRepository usuarioRepository, PedidoRepository pedidoRepository, PedidoMapper pedidoMapper, ProdutoRepository produtoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public PedidoResponseDTO criarPedido(PedidoRequestDTO pedidoRequestDTO) {

        //confere cliente
        UsuarioEntity cliente = usuarioRepository.findById(pedidoRequestDTO.getClienteId()).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        //convertendo DTO para Entity
        PedidoEntity pedido = pedidoMapper.paraPedidoEntity(pedidoRequestDTO);
        pedido.setCliente(cliente);

        //conecta itens ao pedido antes de salvar
        if (pedido.getItens() != null) {
            pedido.getItens().forEach(item -> {
                ProdutoEntity produto = produtoRepository.findById(item.getProduto().getId())
                        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
                item.setProduto(produto);
                item.setPedido(pedido);
            });
        }

        PedidoEntity salvo = pedidoRepository.save(pedido);

        return pedidoMapper.paraPedidoResponseDTO(salvo);
    }

    @Transactional(readOnly = true)
    public List<PedidoResponseDTO> listarTodos(){
        List<PedidoEntity> pedidos = pedidoRepository.findAll();
        return pedidoMapper.paraListaPedidoResponse(pedidos);

    }

    @Transactional(readOnly = true)
    public PedidoResponseDTO buscarPorId(Long id){
       PedidoEntity pedido = pedidoRepository.findById(id).orElseThrow(()-> new RuntimeException("Pedido não encontrado"));
       return pedidoMapper.paraPedidoResponseDTO(pedido);
        
    }

    @Transactional
    public PedidoResponseDTO atualizarStatus(Long id, String novoStatus) {
        PedidoEntity pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado."));

        pedido.setStatus(novoStatus);
        PedidoEntity atualizado = pedidoRepository.save(pedido);

        return pedidoMapper.paraPedidoResponseDTO(atualizado);
    }

    @Transactional
    public void deletar(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new EntityNotFoundException("Pedido não encontrado.");
        }
        pedidoRepository.deleteById(id);
    }


}