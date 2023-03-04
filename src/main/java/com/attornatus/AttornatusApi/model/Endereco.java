package com.attornatus.AttornatusApi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String logradouro;
        private String cep;
        private String numero;

        @ManyToOne
        @JoinColumn(name = "pessoa_id")
        private Pessoa pessoa;

    }


