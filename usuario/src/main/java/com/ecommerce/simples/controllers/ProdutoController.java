package com.ecommerce.simples.controllers;


import com.ecommerce.simples.business.dto.Request.ProdutoRequestDTO;
import com.ecommerce.simples.business.dto.Response.ProdutoResponseDTO;
import com.ecommerce.simples.business.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  @Autowired
  private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


  @GetMapping("/allproducts")
  public ResponseEntity<List<ProdutoResponseDTO>> listadeProdutos(){

        List<ProdutoResponseDTO> listarProdutos = produtoService.listarProdutos();
        if (listarProdutos.isEmpty()) {
        return ResponseEntity.noContent().build(); // 204 se não houver produtos
        }
        return ResponseEntity.ok(listarProdutos); // 200 + lista de produtos
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



