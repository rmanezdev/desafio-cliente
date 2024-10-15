package com.desafio.cliente.valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteValidator {

    private ClientChain c1;

    private ChainFactory factory;

    @Autowired
    public ClienteValidator(ChainFactory factory){
        this.factory = factory;
    }


    public ClienteValidator(){
        this.c1 = this.factory.createChain(ChainFactory.CHAIN_NOME);
        ClientChain c2 = this.factory.createChain(ChainFactory.CHAIN_DOCUMENTO);
        ClientChain c3 = this.factory.createChain(ChainFactory.CHAIN_ENDERECO);
        c1.setNextChain(c2);
        c2.setNextChain(c3);

    }
}
