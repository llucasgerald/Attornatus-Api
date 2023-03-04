package com.attornatus.AttornatusApi.controller;

import com.attornatus.AttornatusApi.model.Endereco;
import com.attornatus.AttornatusApi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping
    public Endereco criarEndereco(@RequestBody Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @GetMapping("/{id}")
    public Endereco consultarEndereco(@PathVariable Long id) {
        return enderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
    }

    @PutMapping("/{id}")
    public Endereco editarEndereco(@PathVariable Long id, @RequestBody Endereco enderecoAtualizado) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        endereco.setLogradouro(enderecoAtualizado.getLogradouro());
        endereco.setCep(enderecoAtualizado.getCep());
        endereco.setNumero(enderecoAtualizado.getNumero());
        return enderecoRepository.save(endereco);
    }
}
