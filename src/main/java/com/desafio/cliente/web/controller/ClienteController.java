package com.desafio.cliente.web.controller;

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
    public ResponseEntity<String> create(@RequestBody String created){
        return new ResponseEntity<>("create ok", HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<String> read(@PathVariable("id") long id){
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable("id") long id, @RequestBody String updated){
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id){
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<String> patch(@PathVariable("id") long id){
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
    /*
     public TodoDto completeTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id : " + id));

        todo.setCompleted(Boolean.TRUE);

        Todo updatedTodo = todoRepository.save(todo);

        return mapToTodoDto(updatedTodo);
    }
    */

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<String>> findAll(){
        return new ResponseEntity<>(List.of("ok"), HttpStatus.OK);
    }
}
