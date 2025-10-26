package com.ecommerce.simples.business.mapstruct;


import com.ecommerce.simples.business.dto.Request.PedidoRequestDTO;
import com.ecommerce.simples.business.dto.Response.PedidoResponseDTO;
import com.ecommerce.simples.infrastructure.entities.PedidoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;


@Mapper(componentModel = "spring", uses = {ItemPedidoMapper.class})
public interface PedidoMapper {


    PedidoResponseDTO paraPedidoResponseDTO(PedidoEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "cliente", ignore = true)
    PedidoEntity paraPedidoEntity(PedidoRequestDTO dto);


    List<PedidoResponseDTO> paraListaPedidoResponse(List<PedidoEntity> PedidoEntity);



}

