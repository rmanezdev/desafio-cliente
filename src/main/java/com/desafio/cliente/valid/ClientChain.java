package com.desafio.cliente.valid;

import com.desafio.cliente.dto.ClienteDTO;

public interface ClientChain {
    public void setNextChain( ClientChain nextChain );
    public boolean valid(ClienteDTO dto);
}
