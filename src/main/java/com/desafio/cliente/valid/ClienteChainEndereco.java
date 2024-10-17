package com.desafio.cliente.valid;

import com.desafio.cliente.dto.ClienteDTO;

public class ClienteChainEndereco implements ClienteChain {

    private ClienteChain nextChain;

    @Override
    public void setNextChain(ClienteChain nextChain) {
        this.nextChain=nextChain;
    }

    @Override
    public boolean valid(ClienteDTO dto){
        if(dto.getEndereco()!=null && dto.getEndereco().getCep()!=null){
            if (this.nextChain != null) {
                return this.nextChain.valid(dto);
            }else{
                return true;
            }
        }
        return false;
    }


}
