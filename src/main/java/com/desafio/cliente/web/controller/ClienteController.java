package com.desafio.cliente.web.controller;

import com.desafio.cliente.dto.ClienteDTO;
import com.desafio.cliente.dto.EnderecoDTO;
import com.desafio.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;


    @PostMapping()
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO created){
        return new ResponseEntity<ClienteDTO>(service.create(created), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> read(@PathVariable("id") long id){
        return new ResponseEntity<>(service.read(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable("id") long id, @RequestBody ClienteDTO updated){
        return new ResponseEntity<ClienteDTO>(service.update(id, updated), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id){
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> patch(@PathVariable("id") long id, @RequestBody EnderecoDTO enderecoDTO){
        ClienteDTO clienteDTO = service.changeAddress(id, enderecoDTO);
        return new ResponseEntity<ClienteDTO>(clienteDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<String>> findAll(){
        return new ResponseEntity<>(List.of("ok"), HttpStatus.OK);
    }
}
