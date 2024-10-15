package com.desafio.cliente.valid;

import com.desafio.cliente.dto.ClienteDTO;

public interface ClienteChain {
    public void setNextChain( ClienteChain nextChain );
    public boolean valid(ClienteDTO dto);
}
