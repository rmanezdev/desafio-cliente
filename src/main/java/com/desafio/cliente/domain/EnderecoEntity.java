/*
Exemplo de builder - cretaional
 */
package com.desafio.cliente.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name="endereco")
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String cep;

    @Column
    private String logradouro;

    @OneToOne(mappedBy = "endereco")
    private ClienteEntity cliente;

    public EnderecoEntity(EnderecoBuilder builder){
        this.cep = builder.cep;
        this.id = builder.id;
        this.logradouro = builder.logradouro;
    }

    public static class EnderecoBuilder{
        private Long id;
        private String cep;
        private String logradouro;

        public EnderecoBuilder setId(Long id){
            this.id = id;
            return this;
        }

        public EnderecoBuilder setCep(String cep){
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
