package com.attornatus.AttornatusApi.service;

import com.attornatus.AttornatusApi.model.Endereco;
import com.attornatus.AttornatusApi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco criarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco atualizarEndereco(Long id, Endereco enderecoAtualizado) {
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        endereco.setLogradouro(enderecoAtualizado.getLogradouro());
        endereco.setCep(enderecoAtualizado.getCep());
        endereco.setNumero(enderecoAtualizado.getNumero());
        return enderecoRepository.save(endereco);
    }

    public Endereco consultarEndereco(Long id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    public List<Endereco> listarEnderecos() {
        return enderecoRepository.findAll();
    }


}
