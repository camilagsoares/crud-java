package br.fepi.apicrud.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.fepi.apicrud.domain.Tecnologia;


public interface TecnologiasRepository extends JpaRepository<Tecnologia, Long> {

    
} 

