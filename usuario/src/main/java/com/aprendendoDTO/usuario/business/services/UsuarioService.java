package com.aprendendoDTO.usuario.business.services;


import com.aprendendoDTO.usuario.business.dto.UsuarioRequestDTO;
import com.aprendendoDTO.usuario.business.dto.UsuarioResponseDTO;
import com.aprendendoDTO.usuario.business.dto.mapstruct.UsuarioMapper;
import com.aprendendoDTO.usuario.infrastructure.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

