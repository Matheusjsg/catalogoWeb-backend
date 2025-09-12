package com.aprendendoDTO.usuario.controllers;

import com.aprendendoDTO.usuario.business.dto.UsuarioRequestDTO;
import com.aprendendoDTO.usuario.business.dto.UsuarioResponseDTO;
import com.aprendendoDTO.usuario.business.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
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
