package com.desafio.cliente.dto;

import com.desafio.cliente.domain.EnderecoEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {
    private Long id;
    private String cep;
    private String logradouro;

    public EnderecoDTO(EnderecoBuilder builder){
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

        public EnderecoDTO build(){
            return new EnderecoDTO(this);
        }
    }


}
