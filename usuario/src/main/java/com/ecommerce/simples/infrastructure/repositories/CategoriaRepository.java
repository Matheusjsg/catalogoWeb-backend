package com.ecommerce.simples.infrastructure.repositories;

import com.ecommerce.simples.infrastructure.entities.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
