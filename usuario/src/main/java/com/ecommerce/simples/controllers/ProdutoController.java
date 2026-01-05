package com.ecommerce.simples.controllers;

import com.ecommerce.simples.business.dto.Response.CategoriaResponseDTO;
import com.ecommerce.simples.business.dto.Response.ProdutoResponseDTO;
import com.ecommerce.simples.business.services.CategoriaService;
import com.ecommerce.simples.business.services.ProdutoService;
import com.ecommerce.simples.infrastructure.entities.CategoriaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  @Autowired
  private final ProdutoService produtoService;
  private final CategoriaService categoriaService;

    public ProdutoController(ProdutoService produtoService, CategoriaService categoriaService) {
        this.produtoService = produtoService;
        this.categoriaService = categoriaService;
    }


  @GetMapping("/allproducts")
  public ResponseEntity<List<ProdutoResponseDTO>> listadeProdutos(){

        List<ProdutoResponseDTO> listarProdutos = produtoService.listarProdutos();
        if (listarProdutos.isEmpty()) {
        return ResponseEntity.noContent().build(); // 204 se não houver produtos
        }
        return ResponseEntity.ok(listarProdutos); // 200 + lista de produtos
}



    @GetMapping("/categorias")
    public ResponseEntity<List<CategoriaResponseDTO>> todasCategorias() {
        List<CategoriaResponseDTO> minhasCategorias = categoriaService.listarCategoria();

        return ResponseEntity.ok(minhasCategorias);

    }

    @GetMapping("categoria/{nome}")
    public ResponseEntity<List<ProdutoResponseDTO>> listarPorCategoria(@PathVariable String nome){
        List<ProdutoResponseDTO> listarCategoria = produtoService.listarProdutosCategotia(nome);

        if (listarCategoria.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 se não houver produtos
        }
        return ResponseEntity.ok(listarCategoria); // 200 + lista de produtos
    }
}



