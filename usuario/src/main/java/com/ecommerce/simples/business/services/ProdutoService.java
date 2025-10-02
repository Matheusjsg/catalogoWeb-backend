package com.ecommerce.simples.business.services;

import com.ecommerce.simples.business.dto.Request.ProdutoRequestDTO;
import com.ecommerce.simples.business.dto.Response.ProdutoResponseDTO;
import com.ecommerce.simples.business.mapstruct.ProdutoMapper;
import com.ecommerce.simples.infrastructure.entities.CategoriaEntity;
import com.ecommerce.simples.infrastructure.entities.ImagemEntity;
import com.ecommerce.simples.infrastructure.entities.ProdutoEntity;
import com.ecommerce.simples.infrastructure.repositories.CategoriaRepository;
import com.ecommerce.simples.infrastructure.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.Normalizer;
import java.util.List;
import java.util.Locale;


@Service
public class ProdutoService {
    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
        this.produtoMapper = produtoMapper;
    }

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProdutoMapper produtoMapper;

    @Transactional
    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO dto) {

        // Transformar DTO em Entity
        ProdutoEntity produto = produtoMapper.paraProdutoEntity(dto);

        // 2️⃣ Buscar categoria pelo ID
        CategoriaEntity categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        produto.setCategoria(categoria);

        // 3️⃣ Gerar slug automaticamente a partir do nome
        produto.setSlug(gerarSlug(produto.getNome()));

        // 4️⃣ Associar produto às imagens (já mapeado pelo mapper)
        produto.getImagens().forEach(img -> img.setProduto(produto));

        // 5️⃣ Salvar no banco
        ProdutoEntity salvo = produtoRepository.save(produto);

        // 6️⃣ Retornar DTO de resposta
        return produtoMapper.paraProdutoResponse(salvo);
    }

    // -------- Listar todos os produtos --------
    public List<ProdutoResponseDTO> listarProdutos() {
        List<ProdutoEntity> produtos = produtoRepository.findAll();
        return produtoMapper.paraListarProdutoResponse(produtos);
    }

    public List<ProdutoResponseDTO> listarProdutosCategotia(String nome) {
        List<ProdutoEntity> produtos = produtoRepository.findByCategoria_NomeIgnoreCase(nome);
        return produtoMapper.paraListarProdutoResponse(produtos);

    }




    // -------- Buscar produto por ID --------
    public ProdutoResponseDTO buscarProdutoPorId(Long id) {
        ProdutoEntity produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return produtoMapper.paraProdutoResponse(produto);
    }




    @Transactional
    public ProdutoResponseDTO editarProduto(Long id, ProdutoRequestDTO dto) {
        // 1️⃣ Buscar produto existente
        ProdutoEntity produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        // 2️⃣ Atualizar campos básicos
        produto.setNome(dto.getNome());
        produto.setDescricaolink(dto.getDescricaolink());
        produto.setDescricaoCompleta(dto.getDescricaoCompleta());
        produto.setPreco(dto.getPreco());

        // 3️⃣ Atualizar slug se o nome mudou
        if (dto.getNome() != null && !dto.getNome().equals(produto.getNome())) {
            produto.setSlug(gerarSlug(dto.getNome()));
        }

        // 4️⃣ Atualizar categoria, se enviada
        if (dto.getCategoriaId() != null) {
            CategoriaEntity categoria = categoriaRepository.findById(dto.getCategoriaId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
            produto.setCategoria(categoria);
        }

        // 5️⃣ Atualizar imagens
        if (dto.getImagens() != null && !dto.getImagens().isEmpty()) {
            produto.getImagens().clear(); // remove imagens antigas
            dto.getImagens().forEach(url -> {
                var imagem = new ImagemEntity();
                imagem.setNomeArquivo(url);
                imagem.setProduto(produto);
                produto.getImagens().add(imagem);
            });
        }

        // 6️⃣ Salvar produto atualizado
        ProdutoEntity atualizado = produtoRepository.save(produto);

        // 7️⃣ Retornar DTO de resposta
        return produtoMapper.paraProdutoResponse(atualizado);
    }

    public void deletarProdutoPorId(Long id){
                produtoRepository.deleteById(id);
    }

    // -------- Gerar slug a partir do nome --------
    private String gerarSlug(String nome) {
        if (nome == null) return null;
        // Remove acentos e caracteres especiais
        String slug = Normalizer.normalize(nome, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .toLowerCase(Locale.ROOT)
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("^-|-$", ""); // remove "-" no começo/fim
        return slug;
    }



}
