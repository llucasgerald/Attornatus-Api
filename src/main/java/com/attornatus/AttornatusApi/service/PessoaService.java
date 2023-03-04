package com.attornatus.AttornatusApi.service;

import com.attornatus.AttornatusApi.model.Pessoa;
import com.attornatus.AttornatusApi.repository.PessoasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class PessoaService {

    @Autowired
    private PessoasRepository pessoaRepository;

    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa atualizarPessoa(Long id, Pessoa pessoaAtualizada) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        pessoa.setNome(pessoaAtualizada.getNome());
        pessoa.setData(pessoaAtualizada.getData());
        return pessoaRepository.save(pessoa);
    }

    public Pessoa consultarPessoa(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

}

