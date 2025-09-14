package com.ecommerce.simples.infrastructure.repositories;

import com.ecommerce.simples.infrastructure.entities.ImagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagemRepository extends JpaRepository<ImagemEntity, Long> {
}
