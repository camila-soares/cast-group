package exam.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import exam.Pessoa;
import exam.Unidade;
import exam.repository.PessoaRepository;
import exam.repository.UnidadeRepository;
import exam.service.UnidadeService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/unidade")
public class UnidadeController {

	@Autowired
	private UnidadeService uniService;
	
	@Autowired
	private UnidadeRepository repository;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> insert(@Valid @RequestBody Unidade obj){
		obj = uniService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getCodigo())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Unidade>> findAll() throws ObjectNotFoundException {
		List<Unidade> list = uniService.listAll();
		return ResponseEntity.ok().body(list);

	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Unidade> find(@PathVariable Long codigo)  {
		Unidade obj = uniService.findById(codigo);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<Unidade>> findPage(
			@RequestParam(value="page", defaultValue="0")  Integer page,
			@RequestParam(value="linesForpage", defaultValue="24") Integer linesForpage,
			@RequestParam(value="orderBy", defaultValue="nome")  String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC")  String direction) {
		Page<Unidade> list = uniService.findPage(page, linesForpage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{codigo}/salario")
	public Unidade sumSalario(@PathVariable("codigo") Long codigo) {
		return uniService.sumSalario(codigo);
	}
	
	@GetMapping("/{codigo}/pessoa")
	public Unidade countPessoa(@PathVariable("codigo") Long codigo) {
		return uniService.contPessoas(codigo);
	}
}
