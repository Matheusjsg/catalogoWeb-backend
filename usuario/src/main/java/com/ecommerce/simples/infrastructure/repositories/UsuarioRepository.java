package com.ecommerce.simples.infrastructure.repositories;

import com.ecommerce.simples.infrastructure.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {


    UsuarioEntity findByNome(String nome);



    Optional<UsuarioEntity> findByEmail(String email);

    @Transactional
    void deleteByNome(String nome);

    @Transactional
    void deleteById(Long id);

    @Transactional
    void deleteByEmail(String email);

}