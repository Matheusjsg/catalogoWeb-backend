package com.ecommerce.simples.business.services;


import com.ecommerce.simples.business.dto.Request.UsuarioRequestDTO;
import com.ecommerce.simples.business.dto.Response.UsuarioResponseDTO;
import com.ecommerce.simples.business.mapstruct.UsuarioMapper;
import com.ecommerce.simples.infrastructure.entities.UsuarioEntity;
import com.ecommerce.simples.infrastructure.repositories.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService {

    private UsuarioRepository userRepository;
    private UsuarioMapper mapper;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository userRepository, UsuarioMapper mapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto) {

        userRepository.findByEmail(dto.getEmail()).ifPresent(u -> {
                    throw new RuntimeException("Email já cadastrado!");
                });

        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setEmail(dto.getEmail());
        usuario.setNome(dto.getNome());
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        usuario.setRole("USER");

        return mapper.paraResponseDTO(userRepository.save(usuario));

    }

    public UsuarioResponseDTO salvaUsuario(UsuarioRequestDTO request) {
        return mapper.paraResponseDTO(userRepository.save(mapper.paraUsuarioEntity(request)));
    }

    public void deleteUsuarioPorNome(String nome) {
        userRepository.deleteByNome(nome);

    }
    public void deleteUsuarioPorEmail(String email) {
        userRepository.deleteByEmail(email);

    }

    public void deleteUsuarioPorId(Long id) {
        userRepository.deleteById(id);

    }

    public UsuarioResponseDTO buscarPorNome(String nome) {
        return mapper.paraResponseDTO(
                userRepository.findByNome(nome));

    }
    public UsuarioEntity buscarEntidadePorEmail(String email) {
        return (UsuarioEntity) userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public UsuarioResponseDTO buscarPorEmail(String email) {

        UsuarioEntity usuario = (UsuarioEntity) userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return mapper.paraResponseDTO(usuario);
    }

    public List<UsuarioResponseDTO> MostrarUsuarios() {
        return mapper.paraListaUsuarioResponseDTO(
                userRepository.findAll());
    }
}

