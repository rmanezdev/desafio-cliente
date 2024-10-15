package com.desafio.cliente.valid;

import com.desafio.cliente.dto.ClienteDTO;

public class ClienteChainDocumento implements ClienteChain {

    private ClienteChain chain;

    @Override
    public void setNextChain(ClienteChain nextChain) {
        this.chain=nextChain;
    }
    @Override
    public boolean valid(ClienteDTO dto){
        if(dto.getDocumento()!=null ){
            return true;
        }
        return false;
    }

}
