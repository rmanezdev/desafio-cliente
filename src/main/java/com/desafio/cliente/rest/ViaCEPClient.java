package com.desafio.cliente.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
Observações
todas os endereços devem ficar em uma variável externa
@FeignClient(name = "${feign.name}", url = "${feign.url}")
 */

@FeignClient(name = "findByCEP", url = "https://viacep.com.br/ws")
public interface ViaCEPClient {

    @GetMapping("/{cep}/json")
    public ResponseEntity<ViaCEPDTO> getAddressByCEP(@PathVariable("cep") String cep);

}