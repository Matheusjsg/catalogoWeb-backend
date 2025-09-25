package com.ecommerce.simples.controllers;

import com.ecommerce.simples.business.dto.Request.UsuarioRequestDTO;
import com.ecommerce.simples.business.dto.Response.UsuarioResponseDTO;
import com.ecommerce.simples.business.mapstruct.UsuarioMapper;
import com.ecommerce.simples.business.services.UsuarioService;
import com.ecommerce.simples.infrastructure.entities.UsuarioEntity;
import com.ecommerce.simples.infrastructure.repositories.UsuarioRepository;
import com.ecommerce.simples.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UsuarioService usuarioService;
    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;
    private JwtUtil jwtUtil;
    private UsuarioMapper mapper;


@PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody UsuarioRequestDTO dto) {
    UsuarioResponseDTO usuario = usuarioService.criarUsuario(dto);
    {
        return ResponseEntity.ok(usuario);
    }
}

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioRequestDTO request){
        UsuarioEntity usuario = usuarioService.buscarEntidadePorEmail(request.getEmail());
        boolean senhaValida = passwordEncoder.matches(request.getPassword(), usuario.getPassword());

        if (!senhaValida) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Senha inválida");
        }
                String token = jwtUtil.generateToken(usuario.getEmail());
        return ResponseEntity.ok(Map.of(
                "usuario", mapper.paraResponseDTO(usuario),
                "token", token
        ));
    }


}
