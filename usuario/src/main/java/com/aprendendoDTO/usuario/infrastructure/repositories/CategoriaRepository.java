package com.aprendendoDTO.usuario.infrastructure.repositories;

import com.aprendendoDTO.usuario.infrastructure.entities.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
