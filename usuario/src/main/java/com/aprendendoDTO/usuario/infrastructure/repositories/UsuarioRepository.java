package com.aprendendoDTO.usuario.infrastructure.repositories;

import com.aprendendoDTO.usuario.infrastructure.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Transactional
    void deleteByNome(String nome);

    UsuarioEntity findByNome(String nome);
}
