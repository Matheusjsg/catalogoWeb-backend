package com.ecommerce.simples.business.mapstruct;


import com.ecommerce.simples.business.dto.Request.PedidoRequestDTO;
import com.ecommerce.simples.business.dto.Response.PedidoResponseDTO;
import com.ecommerce.simples.infrastructure.entities.PedidoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface PedidoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    PedidoEntity paraPedidoEntity(PedidoRequestDTO pedidoRequestDTO);


    PedidoResponseDTO paraPedidoResponse(PedidoEntity pedidoEntity);






}
