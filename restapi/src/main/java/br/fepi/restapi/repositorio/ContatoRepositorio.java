package br.fepi.restapi.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fepi.restapi.model.Contato;

public interface ContatoRepositorio extends JpaRepository<Contato, Long>{
    
}
