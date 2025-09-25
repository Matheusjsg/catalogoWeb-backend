package com.ecommerce.simples.business.services;


import com.ecommerce.simples.business.dto.Request.UsuarioRequestDTO;
import com.ecommerce.simples.business.dto.Response.UsuarioResponseDTO;
import com.ecommerce.simples.business.mapstruct.UsuarioMapper;
import com.ecommerce.simples.infrastructure.entities.UsuarioEntity;
import com.ecommerce.simples.infrastructure.repositories.UsuarioRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UsuarioService {

    private UsuarioRepository userRepository;
    private UsuarioMapper mapper;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.userRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();

    }

    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto) {

        userRepository.findByEmail(dto.getEmail())

                .ifPresent(u -> {
                    throw new RuntimeException("Email já cadastrado!");
                });
        // mapear dados básicos
        UsuarioEntity usuario = mapper.paraUsuarioEntity(dto);

        // gerar hash da senha (BCrypt) e setar na entidade
        String hashed = passwordEncoder.encode(dto.getPassword());
        usuario.setPassword(hashed);

        // salvar
        UsuarioEntity salvo = userRepository.save(usuario);

        // retornar response DTO (sem senha)
        return mapper.paraResponseDTO(salvo);


    }


    public UsuarioResponseDTO salvaUsuario(UsuarioRequestDTO request) {
        return mapper.paraResponseDTO(
                userRepository.save(
                        mapper.paraUsuarioEntity(request)));
    }

    public void DeleteUsuarioPorNome(String nome) {
        userRepository.deleteByNome(nome);

    }

    public UsuarioResponseDTO buscarPorNome(String nome) {
        return mapper.paraResponseDTO(
                userRepository.findByNome(nome));

    }
    public UsuarioEntity buscarEntidadePorEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public UsuarioResponseDTO buscarPorEmail(String email) {

        UsuarioEntity usuario = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return mapper.paraResponseDTO(usuario);
    }



    public List<UsuarioResponseDTO> MostrarUsuarios() {
        return mapper.paraListaUsuarioResponseDTO(
                userRepository.findAll());
    }
}

