package com.desafio.cliente.service;

import com.desafio.cliente.cnt.ErrorCodes;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//poderia ficar melhor com aspect
@Service
public class ClienteService {

    private ClienteRepository repository;
    private ModelMapper modelMapper;
    private ClienteValidator clienteValidator;
    private EnderecoService enderecoService;

    @Autowired
    public ClienteService( ClienteRepository repository, ModelMapper modelMapper, ClienteValidator clienteValidator, EnderecoService enderecoService){
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.clienteValidator = clienteValidator;
        this.enderecoService = enderecoService;
    }

    public ClienteDTO create( ClienteDTO dto ){
        if ( clienteValidator.valid(dto) ){
            if (dto.getEndereco().getLogradouro()==null || dto.getEndereco().getLogradouro().isEmpty()){
                EnderecoDTO edto = enderecoService.findByCEP(String.valueOf(dto.getEndereco().getCep()));
                dto.getEndereco().setLogradouro(edto.getLogradouro());
            }
            ClienteEntity e = modelMapper.map(dto, ClienteEntity.class);
            e = repository.save(e);
            dto = modelMapper.map(e, ClienteDTO.class);
            return dto;
        }else{
            throw new AppException(ErrorCodes.ERROR_CODES_CREATE_CLIENTE.getErrMsg());
        }
    }


    public ClienteDTO read( Long id ){
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
            throw new AppException(ErrorCodes.ERROR_CODES_UPDATE_CLIENTE.getErrMsg());
        }

    }

    public Optional<List<ClienteDTO>> findAll( ){
        List<ClienteEntity> listEntity = repository.findAll();
        List<ClienteDTO> listDTO = listEntity.stream().map(e -> modelMapper.map(e, ClienteDTO.class)).collect(Collectors.toList());
        return Optional.of(listDTO);
    }

    public void delete(Long id ){
        Optional<ClienteEntity> o = repository.findById(id);
        if(o.isPresent()){
            repository.delete(o.get());
        }else{
            throw new AppException(ErrorCodes.ERROR_CODES_UPDATE_CLIENTE.getErrMsg());
        }
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
