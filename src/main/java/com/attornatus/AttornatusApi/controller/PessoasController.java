package com.attornatus.AttornatusApi.controller;

import com.attornatus.AttornatusApi.model.Endereco;
import com.attornatus.AttornatusApi.model.Pessoa;
import com.attornatus.AttornatusApi.service.EnderecoService;
import com.attornatus.AttornatusApi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/pessoas")
public class PessoasController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoa(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.consultarPessoa(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.criarPessoa(pessoa);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoaAtualizada) {
        Pessoa pessoa = pessoaService.atualizarPessoa(id, pessoaAtualizada);
        return ResponseEntity.ok().body(pessoa);
    }

    @PostMapping("/{id}/enderecos")
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco criarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        Pessoa pessoa = pessoaService.consultarPessoa(id);
        endereco.setPessoa(pessoa);
        return enderecoService.criarEndereco(endereco);
    }

    @GetMapping("/{id}/enderecos")
    public List<Endereco> listarEnderecos(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.consultarPessoa(id);
        return pessoa.getEnderecos();
    }

    @PostMapping("/{id}/endereco-principal")
    public Endereco definirEnderecoPrincipal(@PathVariable Long id, @RequestParam Long enderecoId) {
        Pessoa pessoa = pessoaService.consultarPessoa(id);
        Endereco endereco = enderecoService.consultarEndereco(enderecoId);
        pessoa.setEnderecoPrincipal(endereco);
        pessoaService.atualizarPessoa(pessoa.getId(), pessoa);
        return endereco;
    }

    @PutMapping("/{idPessoa}/enderecos/{idEndereco}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Long idPessoa, @PathVariable Long idEndereco, @RequestBody Endereco enderecoAtualizado) {
        Pessoa pessoa = pessoaService.consultarPessoa(idPessoa);
        Endereco endereco = enderecoService.consultarEndereco(idEndereco);

        if (endereco.getPessoa().getId() != pessoa.getId()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Endereço não pertence a essa pessoa");
        }

        endereco.setLogradouro(enderecoAtualizado.getLogradouro());
        endereco.setCep(enderecoAtualizado.getCep());
        endereco.setNumero(enderecoAtualizado.getNumero());

        return ResponseEntity.ok().body(enderecoService.atualizarEndereco(idEndereco, endereco));
    }

}