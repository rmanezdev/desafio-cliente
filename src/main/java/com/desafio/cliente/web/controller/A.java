package com.desafio.cliente.web.controller;

import com.desafio.cliente.rest.ViaCEPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/viacep")
public class A {

    @Autowired
    ViaCEPService viaCEPService;

    @GetMapping(value = "/{cep}")
    public Object aaa(@PathVariable("cep") String cep){
        Object o = viaCEPService.getCep(cep);
        return o;

    }

}
