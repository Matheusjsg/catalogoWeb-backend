package com.ecommerce.simples.business.services;


import com.ecommerce.simples.business.dto.Request.UsuarioRequestDTO;
import com.ecommerce.simples.business.dto.Response.UsuarioResponseDTO;
import com.ecommerce.simples.business.mapstruct.UsuarioMapper;
import com.ecommerce.simples.infrastructure.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    public final UsuarioMapper mapper;

    public UsuarioResponseDTO salvaUsuario(UsuarioRequestDTO request){
         return  mapper.paraResponseDTO(
                        repository.save(
                            mapper.paraUsuarioEntity(request)));
    }

    public void DeleteUsuarioPorNome(String nome){
        repository.deleteByNome(nome);

    }public UsuarioResponseDTO buscarPorNome(String nome){
        return mapper.paraResponseDTO(
                repository.findByNome(nome));

    }

    public List<UsuarioResponseDTO> MostrarUsuarios(){
        return mapper.paraListaUsuarioResponseDTO(
                repository.findAll());
    }
    }

