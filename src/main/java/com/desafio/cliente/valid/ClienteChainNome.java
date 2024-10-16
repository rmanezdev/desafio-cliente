package com.desafio.cliente.valid;

import com.desafio.cliente.dto.ClienteDTO;

public class ClienteChainNome implements ClienteChain {

    private ClienteChain nextChain;

    @Override
    public void setNextChain(ClienteChain nextChain){
        this.nextChain=nextChain;
    }

    @Override
    public boolean valid(ClienteDTO dto){
        if(dto.getNome()!=null && dto.getNome().length()>=5 && dto.getNome().length()<=25 ) {
            if (this.nextChain != null) {
                return this.nextChain.valid(dto);
            }
        }
        return false;
    }


}
