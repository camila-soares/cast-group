package exam.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import exam.Pessoa;
import exam.repository.PessoaRepository;
import exam.service.PessoaService;
import exam.service.exception.ObjectNotFoundException;

@CrossOrigin(origins= "http://localhoost:4200")
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@Autowired
	private PessoaRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> insert(@Valid @RequestBody Pessoa obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getCodigo())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() throws ObjectNotFoundException {
		List<Pessoa> list = service.listAll();
		return ResponseEntity.ok().body(list);

	}
	

	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> delete(@PathVariable Long codigo) throws Exception {
		service.delete(codigo);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Void> update(@Valid @RequestBody Pessoa obj, @PathVariable Long codigo) throws ObjectNotFoundException{
		
		obj.setCodigo(codigo);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{nome}")
	public List<Pessoa> countP(@PathVariable("nome")String nome){
		return service.countP(nome);
	}
	
}
