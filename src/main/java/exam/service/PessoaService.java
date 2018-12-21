package exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exam.Pessoa;
import exam.repository.PessoaRepository;
import exam.service.exception.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa find(Long codigo) {
		Optional<Pessoa> obj = pessoaRepository.findById(codigo);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Código: " + codigo + ", Tipo: " + Pessoa.class.getName()));
	}
	
	public Pessoa insert(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa update(Pessoa obj) {
		Pessoa newObj = find(obj.getCodigo());
		updateData(newObj, obj);
		return pessoaRepository.save(newObj);
	}
	
	private void updateData(Pessoa newObj, Pessoa obj) {
		newObj.setNome(obj.getNome());

		
	}

	public List<Pessoa> listAll() {
		return pessoaRepository.findAll();
	}
	
	public List<Pessoa> findByNome(String nome) {
		return pessoaRepository.findByNome(nome);
		
	}

}
