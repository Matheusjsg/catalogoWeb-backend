package com.ecommerce.simples.business.services;

import com.ecommerce.simples.business.dto.Request.UsuarioRequestDTO;
import com.ecommerce.simples.business.dto.Response.UsuarioResponseDTO;
import com.ecommerce.simples.business.mapstruct.UsuarioMapper;
import com.ecommerce.simples.infrastructure.entities.UsuarioEntity;
import com.ecommerce.simples.infrastructure.repositories.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



@Slf4j
@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock private UsuarioRepository userRepository;
    @Mock private UsuarioMapper mapper;
    @Mock private PasswordEncoder passwordEncoder;


    @InjectMocks UsuarioService usuarioService;



    @Test
    void DeveCriarUsuarioComSucesso(){

        UsuarioRequestDTO usuarioNovo = new UsuarioRequestDTO("Matheus", "confiante-@hotmail.com", "12345");
        UsuarioEntity usuario = new UsuarioEntity(1L, "Matheus", "confiante-@hotmail.com", "encoded12345", "USER");
        UsuarioEntity salvo = new UsuarioEntity(1L, "Matheus", "confiante-@hotmail.com", "encoded12345", "USER");
        UsuarioResponseDTO responseDTO = new UsuarioResponseDTO(1L, "Matheus", "confiante-@hotmail.com", "USER");

        when(userRepository.findByEmail(usuarioNovo.getEmail())).thenReturn(Optional.empty());
        when(passwordEncoder.encode("12345")).thenReturn("encoded12345");
        when(userRepository.save(any(UsuarioEntity.class))).thenReturn(salvo);
        when(mapper.paraResponseDTO(salvo)).thenReturn(responseDTO);

        UsuarioResponseDTO resultado = usuarioService.criarUsuario(usuarioNovo);

        assertAll(
                () -> assertEquals("Matheus", resultado.getNome()),
                () -> assertEquals("confiante-@hotmail.com", resultado.getEmail()),
                () -> assertEquals("USER", resultado.getRole())
        );
    }


    @Test
    void DeveRetornarEmailJaExistente(){

        UsuarioEntity existente = new UsuarioEntity(1L, "Matheus", "confiantee-@hotmail.com", "encoded12345", "USER");
        UsuarioRequestDTO usuarioNovo = new UsuarioRequestDTO("Matheus", "confiante-@hotmail.com", "12345");

        when(userRepository.findByEmail(usuarioNovo.getEmail())).thenReturn(Optional.of(existente));

        var exemplo = assertThrows(RuntimeException.class, () -> usuarioService.criarUsuario(usuarioNovo));

        assertEquals("Email já cadastrado!", exemplo.getMessage());
        verify(userRepository, never()).save(any());

    }


    @Test
    void DeveCodificarSenhaAntesdeSalvar(){

        UsuarioRequestDTO usuarioNovo = new UsuarioRequestDTO("Matheus", "confiante-@hotmail.com", "12345");

        when(userRepository.findByEmail(usuarioNovo.getEmail())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(usuarioNovo.getPassword())).thenReturn("encodedSenha");
        when(userRepository.save(any())).thenReturn(new UsuarioEntity());

        usuarioService.criarUsuario(usuarioNovo);
        verify(passwordEncoder).encode("12345");

    }

}