package com.attornatus.AttornatusApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto implements Serializable {


        private Long id;
        private String logradouro;
        private String cep;
        private String numero;
        private String cidade;

}
