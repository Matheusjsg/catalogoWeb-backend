package com.ecommerce.simples.controllers;


import com.ecommerce.simples.business.dto.Request.AuthResquestDTO;
import com.ecommerce.simples.business.dto.Request.UsuarioRequestDTO;
import com.ecommerce.simples.business.dto.Response.AuthResponseDTO;
import com.ecommerce.simples.business.dto.Response.UsuarioResponseDTO;
import com.ecommerce.simples.business.mapstruct.UsuarioMapper;
import com.ecommerce.simples.business.services.UsuarioService;
import com.ecommerce.simples.infrastructure.entities.UsuarioEntity;
import com.ecommerce.simples.infrastructure.repositories.UsuarioRepository;
import com.ecommerce.simples.security.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UsuarioService usuarioService;
    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;
    private UsuarioMapper mapper;

    public AuthController(UsuarioService usuarioService, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, UsuarioMapper mapper) {
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.mapper = mapper;
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@Valid @RequestBody UsuarioRequestDTO dto) {
    UsuarioResponseDTO usuario = usuarioService.criarUsuario(dto);
    {
        return ResponseEntity.ok(usuario);
    }
}

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid  @RequestBody AuthResquestDTO request){
        UsuarioEntity usuario = usuarioService.buscarEntidadePorEmail(request.getEmail());
        boolean senhaValida = passwordEncoder.matches(request.getPassword(), usuario.getPassword());

        if (usuario == null || !passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }

        String token = jwtUtil.generateToken(usuario.getEmail());
        UsuarioResponseDTO usuarioDTO = mapper.paraResponseDTO(usuario);

        return ResponseEntity.ok(new AuthResponseDTO(token, usuarioDTO));
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable String email) {
        usuarioService.deleteUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }


}
