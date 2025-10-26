package com.ecommerce.simples.controllers;

import com.ecommerce.simples.business.dto.Request.PedidoRequestDTO;
import com.ecommerce.simples.business.dto.Response.PedidoResponseDTO;
import com.ecommerce.simples.business.services.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // 🔹 Criar pedido
    @PostMapping
    public ResponseEntity<PedidoResponseDTO> criar(@RequestBody PedidoRequestDTO dto) {
        PedidoResponseDTO criado = pedidoService.criarPedido(dto);
        return ResponseEntity.ok(criado);
    }

    // 🔹 Listar todos
    @GetMapping("/todos")
    public ResponseEntity<List<PedidoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

    // 🔹 Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.buscarPorId(id));
    }

    // 🔹 Atualizar status
    @PatchMapping("/{id}/status")
    public ResponseEntity<PedidoResponseDTO> atualizarStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        PedidoResponseDTO atualizado = pedidoService.atualizarStatus(id, status);
        return ResponseEntity.ok(atualizado);
    }

    // 🔹 Deletar pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
