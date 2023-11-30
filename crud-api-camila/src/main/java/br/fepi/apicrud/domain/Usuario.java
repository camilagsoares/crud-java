package br.fepi.apicrud.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonInclude(Include.NON_NULL)
	private Long id;
	
	@JsonInclude(Include.NON_NULL)
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	private String email;

	@JsonInclude(Include.NON_NULL)
	@OneToMany(mappedBy = "usuario")
	private List<Tecnologia> tecnologia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() { 
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public List<Tecnologia> getTecnologia() { 
		return tecnologia;
	}
  
	public void setTecnologia(List<Tecnologia> tecnologia) {
		this.tecnologia = tecnologia;
	}	
	
}
