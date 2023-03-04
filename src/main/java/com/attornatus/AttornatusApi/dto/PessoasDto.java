package com.attornatus.AttornatusApi.dto;


import com.attornatus.AttornatusApi.model.Endereco;
import com.attornatus.AttornatusApi.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoasDto implements Serializable {



        private Long id;
        private String nome;
        private LocalDate dataDeNascimento;
        private List<Endereco> enderecos;
        private Endereco enderecoPrincipal;


        public PessoasDto(Pessoa pessoas) {
                this.id = pessoas.getId();
                this.nome = pessoas.getNome();
                this.dataDeNascimento = pessoas.getData();
                this.enderecos = pessoas.getEnderecos();
                this.enderecoPrincipal = pessoas.getEnderecoPrincipal();
        }

}


