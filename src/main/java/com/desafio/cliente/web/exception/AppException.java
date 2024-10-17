package com.desafio.cliente.web.exception;

public class AppException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String errMsg;

    public AppException(String errMsg) {
        this.errMsg = errMsg;
    }
}


