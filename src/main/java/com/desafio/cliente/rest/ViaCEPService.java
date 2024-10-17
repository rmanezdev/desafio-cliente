package com.desafio.cliente.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ViaCEPService {
    @Autowired
    private ViaCEPClient viaCEPClient;

    public ViaCEPDTO getCep(String cep){
        //fuckin the FeignClient without none safe
        ResponseEntity<ViaCEPDTO> viaCEPDTO  = viaCEPClient.getAddressByCEP(cep);
        return viaCEPDTO.getBody();
    }

}
