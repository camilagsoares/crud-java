package br.fepi.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fepi.restapi.repositorio.ContatoRepositorio;
import br.fepi.restapi.model.Contato;

@RestController
@RequestMapping("/contatos")
public class ContatoController {


    @Autowired
    private ContatoRepositorio repositorio;

    @GetMapping
    public List<Contato> listar() {
        return repositorio.findAll();
    }

    @PostMapping
    public Contato adicionar(@RequestBody Contato contato) {
        return repositorio.save(contato);
    }
}
