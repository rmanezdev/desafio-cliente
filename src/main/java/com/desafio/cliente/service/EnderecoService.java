package com.desafio.cliente.service;

import com.desafio.cliente.dto.EnderecoDTO;
import com.desafio.cliente.rest.ViaCEPDTO;
import com.desafio.cliente.rest.ViaCEPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    ViaCEPService viaCEPService;

    public EnderecoDTO findByCEP(String cep){
        ViaCEPDTO viaCEPDTO = viaCEPService.getCep(cep);
        EnderecoDTO dto = new EnderecoDTO.EnderecoBuilder().setLogradouro(viaCEPDTO.getLogradouro()).setCep(Long.parseLong(cep)).build();
        return dto;
    }

}
