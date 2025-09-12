package com.aprendendoDTO.usuario.infrastructure.repositories;

import com.aprendendoDTO.usuario.infrastructure.entities.ImagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagemRepository extends JpaRepository<ImagemEntity, Long> {
}
