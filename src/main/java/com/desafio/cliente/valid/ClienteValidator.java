package com.desafio.cliente.valid;

import com.desafio.cliente.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteValidator {

    private ClienteChain c1;

    private ChainFactory factory;

    @Autowired
    public ClienteValidator(ChainFactory factory){
        this.factory = factory;
    }

    private void createChain(){
        this.c1 = this.factory.createChain(ChainFactory.CHAIN_NOME);
        ClienteChain c2 = this.factory.createChain(ChainFactory.CHAIN_DOCUMENTO);
        ClienteChain c3 = this.factory.createChain(ChainFactory.CHAIN_ENDERECO);
        this.c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public boolean valid(ClienteDTO dto){
        return this.c1.valid(dto);
    }
}
