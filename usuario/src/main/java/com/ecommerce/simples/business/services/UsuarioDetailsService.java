package com.ecommerce.simples.business.services;

import com.ecommerce.simples.infrastructure.entities.UsuarioEntity;
import com.ecommerce.simples.infrastructure.repositories.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        UsuarioEntity usuario = (UsuarioEntity) usuarioRepository.findByEmail(userEmail)
                .orElseThrow(()-> new UsernameNotFoundException("E-mail não encontrado"));
        return User.builder()
                .username(usuario.getEmail())
                .password(usuario.getPassword())
                .roles(usuario.getRole())
                .build();
    }
}
