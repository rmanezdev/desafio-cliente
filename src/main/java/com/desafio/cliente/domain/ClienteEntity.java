package com.desafio.cliente.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity(name="cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    //@NotNull
    //@Length(min = 10, max = 25)
    private String nome;

    @Column
    //@Column(unique=true)
    private String documento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private EnderecoEntity endereco;

}
