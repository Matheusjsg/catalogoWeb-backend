package com.ecommerce.simples.infrastructure.repositories;

import com.ecommerce.simples.infrastructure.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Transactional
    void deleteByNome(String nome);

    UsuarioEntity findByNome(String nome);
    UsuarioEntity findByEmail(String email);
}
