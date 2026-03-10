package com.ecommerce.simples.controllers.Admin;


import com.ecommerce.simples.business.dto.Request.CategoriaRequestDTO;
import com.ecommerce.simples.business.dto.Request.ProdutoRequestDTO;
import com.ecommerce.simples.business.dto.Response.CategoriaResponseDTO;
import com.ecommerce.simples.business.dto.Response.ProdutoResponseDTO;
import com.ecommerce.simples.business.services.CategoriaService;
import com.ecommerce.simples.business.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdmProductsController {

    @Autowired
    private final ProdutoService produtoService;
    private final CategoriaService categoriaService;

    public AdmProductsController(ProdutoService produtoService, CategoriaService categoriaService) {
        this.produtoService = produtoService;
        this.categoriaService = categoriaService;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarProdutoporId(@PathVariable("id") Long id){
        produtoService.deletarProdutoPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/todosProdutos")
    public ResponseEntity<List<ProdutoResponseDTO>> listadeProdutos(){

        List<ProdutoResponseDTO> listarProdutos = produtoService.listarProdutos();
        if (listarProdutos.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 se não houver produtos
        }
        return ResponseEntity.ok(listarProdutos); // 200 + lista de produtos
    }

    @PostMapping("/adicionarProduto")
    public ResponseEntity<ProdutoResponseDTO> adicionarProduto(@RequestBody ProdutoRequestDTO dto){
        ProdutoResponseDTO response = produtoService.criarProduto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @PutMapping ("/editar/{id}")
    public ResponseEntity<ProdutoResponseDTO> editarProduto(@PathVariable Long id,
                                                            @RequestBody ProdutoRequestDTO dto) {
        ProdutoResponseDTO produtoAtualizado = produtoService.editarProduto(id, dto);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @PostMapping("/adicionarCategoria")
    public ResponseEntity<CategoriaResponseDTO> adicinarCategoria(@RequestBody CategoriaRequestDTO categoriaDto){
        CategoriaResponseDTO novaCategoria = categoriaService.CriarCategoria(categoriaDto);
        return ResponseEntity.ok(novaCategoria);
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
