package com.desafio.cliente.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @GetMapping(value = "/{id}")
    public ResponseEntity<String> read(@PathVariable("id") long id){
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
