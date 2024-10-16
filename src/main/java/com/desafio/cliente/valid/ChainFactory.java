package com.desafio.cliente.valid;

import org.springframework.stereotype.Component;

@Component
public class ChainFactory {

    public static final int CHAIN_NOME = 0;
    public static final int CHAIN_DOCUMENTO = 1;
    public static final int CHAIN_ENDERECO = 2;

    public ClienteChain createChain(final int type){
        return switch (type){
            case CHAIN_NOME:
                yield new ClienteChainNome();
            case CHAIN_DOCUMENTO:
                yield new ClienteChainDocumento();
            case CHAIN_ENDERECO:
                yield new ClienteChainEndereco();
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        };
    }

}
