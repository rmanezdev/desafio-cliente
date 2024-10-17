package com.desafio.cliente.cnt;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodes {

    ERROR_CODES_CREATE_CLIENTE("Erro ao criar cliente"),
    ERROR_CODES_UPDATE_CLIENTE("Erro ao atualizar cliente");

    private String errMsg;

}
