package br.fepi.apicrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fepi.apicrud.domain.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Long>{ 

}  