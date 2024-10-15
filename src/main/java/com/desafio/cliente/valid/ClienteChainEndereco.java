package com.desafio.cliente.valid;

import com.desafio.cliente.dto.ClienteDTO;

public class ClienteChainEndereco implements ClienteChain {

    private ClienteChain chain;

    @Override
    public void setNextChain(ClienteChain nextChain) {
        this.chain=nextChain;
    }
    @Override
    public boolean valid(ClienteDTO dto){
        if(dto.getEndereco()!=null ){
            return true;
        }
        return false;
    }


}
