package br.fepi.apicrud.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.fepi.apicrud.domain.Tecnologia;
import br.fepi.apicrud.domain.Usuario;
import br.fepi.apicrud.repository.TecnologiasRepository;
import br.fepi.apicrud.repository.UsuariosRepository;  

@RestController
@RequestMapping(value = "/usuarios") 
public class UsuariosResources { 
	
	@Autowired
	private UsuariosRepository usuariosRepositoryRepository;

	@Autowired
	private TecnologiasRepository tecnologiasRepositoryRepository; 

 
	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> listar() {
		return usuariosRepositoryRepository.findAll();  
	} 

	@PostMapping()
		public Usuario salvar(@RequestBody Usuario usuario){
		return usuariosRepositoryRepository.save(usuario);
	}

	@CrossOrigin
	@GetMapping(value = "/{id}")
	public Usuario findById(@PathVariable (value = "id")Long id){
		return usuariosRepositoryRepository.findById(id).orElse(null); 
	}

	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable(value = "id")Long id){
		usuariosRepositoryRepository.deleteById(id); 
	}
 
	@PutMapping(value = "{id}")
	public void atualizar(@RequestBody Usuario usuario, @PathVariable("id") Long id){
		usuario.setId(id);
		usuariosRepositoryRepository.save(usuario); 
	}

	@RequestMapping(value = "/{id}/tecnologia", method = RequestMethod.POST)
	public void adicionarDepartamento(@PathVariable("id") Long usuarioId, @RequestBody Tecnologia tecnologia){
		Usuario usuario = new Usuario();
		usuario.setId(usuarioId);

		tecnologia.setUsuario(usuario); 
		tecnologiasRepositoryRepository.save(tecnologia);     
	}
}
