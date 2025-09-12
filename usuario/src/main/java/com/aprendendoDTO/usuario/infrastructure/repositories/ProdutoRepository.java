package com.aprendendoDTO.usuario.infrastructure.repositories;

import com.aprendendoDTO.usuario.infrastructure.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

}
