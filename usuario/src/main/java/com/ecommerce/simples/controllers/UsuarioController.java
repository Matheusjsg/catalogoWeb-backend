package com.ecommerce.simples.controllers;

import com.ecommerce.simples.business.dto.Request.UsuarioRequestDTO;
import com.ecommerce.simples.business.dto.Response.UsuarioResponseDTO;
import com.ecommerce.simples.business.services.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@AllArgsConstructor

public class UsuarioController {

    private final UsuarioService service;


    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> salvaUsuario(@RequestBody UsuarioRequestDTO dto){
            return ResponseEntity.ok(service.salvaUsuario(dto));

}
  @GetMapping("/{nome}")
  public ResponseEntity<UsuarioResponseDTO> buscarPorNome(@PathVariable("nome") String nome){

        return ResponseEntity.ok(service.buscarPorNome(nome));

  }
  @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> mostrarTodos(){

        return ResponseEntity.ok(service.MostrarUsuarios());

  }
    @DeleteMapping
    public ResponseEntity<Void> excluirUsuario(@PathVariable("nome") String nome) {
        service.DeleteUsuarioPorNome(nome);
        return ResponseEntity.ok().build();
    }

}
