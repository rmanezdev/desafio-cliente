package com.desafio.cliente.service;

import com.desafio.cliente.domain.ClienteEntity;
import com.desafio.cliente.domain.EnderecoEntity;
import com.desafio.cliente.dto.ClienteDTO;
import com.desafio.cliente.dto.EnderecoDTO;
import com.desafio.cliente.repository.ClienteRepository;
import com.desafio.cliente.valid.ClienteValidator;
import com.desafio.cliente.web.exception.AppException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//poderia ficar melhor com aspect
@Service
public class ClienteService {

    private ClienteRepository repository;
    private ModelMapper modelMapper;
    private ClienteValidator clienteValidator;

    @Autowired
    public ClienteService( ClienteRepository repository, ModelMapper modelMapper, ClienteValidator clienteValidator){
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.clienteValidator = clienteValidator;
    }


    public ClienteDTO create( ClienteDTO dto ){
        if ( clienteValidator.valid(dto) ){
            ClienteEntity e = modelMapper.map(dto, ClienteEntity.class);
            e = repository.save(e);
            dto = modelMapper.map(e, ClienteDTO.class);
            return dto;
        }else{
            throw new AppException("Erro create");
        }
    }


    public ClienteDTO get( Long id ){
        ClienteDTO dto = modelMapper.map(repository.findById(id), ClienteDTO.class);
        return dto;
    }

    public ClienteDTO update(Long id, ClienteDTO dto ){
        if ( clienteValidator.valid(dto) ){
            dto.setId(null);
            modelMapper.getConfiguration().setSkipNullEnabled(true);
            ClienteDTO r =  repository.findById(id).map(record -> {
                ClienteDTO d = new ClienteDTO();
                modelMapper.map(dto, record);
                modelMapper.map(repository.save(record), d);
                return d;
            }).orElseGet(null);
            return r;
        }else{
            throw new AppException("Erro create");
        }

    }

    public Optional<List<ClienteDTO>> findAll( ){
        List<ClienteEntity> listEntity = repository.findAll();
        List<ClienteDTO> listDTO = listEntity.stream().map(e -> modelMapper.map(e, ClienteDTO.class)).collect(Collectors.toList());
        return Optional.of(listDTO);
    }


    public ClienteDTO changeAddress(Long id, EnderecoDTO enderecoDTO){
        if( enderecoDTO !=null ){
            Optional<ClienteEntity> o = repository.findById(id);
            if ( o.isPresent() ) {
                ClienteEntity e = o.get();
                EnderecoEntity enderecoEntity = modelMapper.map(enderecoDTO, EnderecoEntity.class);
                e.setEndereco(enderecoEntity);
                e = repository.save(e);
                ClienteDTO dto = modelMapper.map(repository.findById(id), ClienteDTO.class);
                return dto;
            } else {
                throw new AppException("Cliente não encontrado");
            }
        }else {
            throw new AppException("erro endereço nulo");
        }
    }
}
