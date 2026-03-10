package com.ecommerce.simples.business.mapstruct;

import com.ecommerce.simples.business.dto.Request.UsuarioRequestDTO;
import com.ecommerce.simples.business.dto.Response.UsuarioResponseDTO;
import com.ecommerce.simples.infrastructure.entities.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {



   @Mapping(target = "id", ignore = true)
   UsuarioEntity paraUsuarioEntity(UsuarioRequestDTO dto);


   UsuarioResponseDTO paraResponseDTO(UsuarioEntity entity);


   List<UsuarioResponseDTO> paraListaUsuarioResponseDTO(List<UsuarioEntity> lista);

}
