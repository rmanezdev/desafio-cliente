package com.desafio.cliente.web.exception;

public class AppException extends RuntimeException {
    public AppException(String errorMessage){
        super(errorMessage);
    }
}
