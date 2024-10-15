package com.desafio.cliente.valid;

import com.desafio.cliente.dto.ClienteDTO;

public class ClienteChainNome implements ClientChain {

    private ClientChain chain;

    @Override
    public void setNextChain(ClientChain nextChain) {
        this.chain=nextChain;
    }
    @Override
    public boolean valid(ClienteDTO dto){
        if(dto.getNome()!=null && dto.getNome().length()>=10 && dto.getNome().length()<=25 ){
            return true;
        }
        return false;
    }


}
