package com.ecommerce.simples.infrastructure.repositories;

import com.ecommerce.simples.infrastructure.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    @Transactional
    void deleteById(Long Id);
}
