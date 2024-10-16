package com.desafio.cliente.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ViaCEPService {
    @Autowired
    private ViaCEPClient viaCEPClient;

    public Object getCep(String cep){
        //fuckin the FeignClient without none safe
        ResponseEntity<Object> o  = viaCEPClient.getAddressByCEP(cep);
        return o;
    }

}
