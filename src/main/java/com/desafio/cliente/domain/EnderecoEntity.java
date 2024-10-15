/*
Exemplo de builder - cretaional
 */
package com.desafio.cliente.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="endereco")
@Data
@NoArgsConstructor
public class EnderecoEntity {

    @Id
    private Long id;

    @Column
    private Long cep;

    @Column
    private String logradouro;

    @OneToOne(fetch = FetchType.LAZY)
    private ClienteEntity cliente;

    public EnderecoEntity(EnderecoBuilder builder){
        this.cep = builder.cep;
        this.id = builder.id;
        this.logradouro = builder.logradouro;
    }

    public static class EnderecoBuilder{
        private Long id;
        private Long cep;
        private String logradouro;

        public EnderecoBuilder setId(Long id){
            this.id = id;
            return this;
        }

        public EnderecoBuilder setCep(Long cep){
            this.cep = cep;
            return this;
        }

        public EnderecoBuilder setLogradouro(String logradouro){
            this.logradouro = logradouro;
            return this;
        }

        public EnderecoEntity builder(){
            return new EnderecoEntity(this);
        }

    }
}
