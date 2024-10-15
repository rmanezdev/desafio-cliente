package com.desafio.cliente.service;

import com.desafio.cliente.domain.ClienteEntity;
import com.desafio.cliente.dto.ClienteDTO;
import com.desafio.cliente.dto.EnderecoDTO;
import com.desafio.cliente.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private ClienteRepository repository;
    private ModelMapper modelMapper;

    @Autowired
    public ClienteService(
            ClienteRepository repository,
            ModelMapper modelMapper){
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public ClienteDTO create( ClienteDTO dto ){
        ClienteEntity e = modelMapper.map(dto, ClienteEntity.class);
        e = repository.save(e);
        dto = modelMapper.map(e, ClienteDTO.class);
        return dto;
    }


    public ClienteDTO get( Long id ){
        ClienteDTO dto = modelMapper.map(repository.findById(id), ClienteDTO.class);
        return dto;
    }

    public ClienteDTO upadate(Long id, ClienteDTO dto ){
        dto.setId(null);
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        ClienteDTO r =  repository.findById(id).map(record -> {
            ClienteDTO d = new ClienteDTO();
            modelMapper.map(dto, record);
            modelMapper.map(repository.save(record), d);
            return d;
        }).orElseGet(null);
        return r;
    }

    public Optional<List<ClienteDTO>> findAll( ){
        List<ClienteEntity> listEntity = repository.findAll();
        List<ClienteDTO> listDTO = listEntity.stream().map(e -> modelMapper.map(e, ClienteDTO.class)).collect(Collectors.toList());
        return Optional.of(listDTO);
    }


    public ClienteDTO changeAddress(Long id, EnderecoDTO enderecoDTO){
        return null;
    }


}
