package exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
		newObj.setDtnasc(obj.getDtnasc());
		newObj.setEmail(obj.getEmail());
		newObj.setNacionalidade(obj.getNacionalidade());
		newObj.setNaturalidade(obj.getNaturalidade());
		newObj.setSexo(obj.getSexo());
		newObj.setCpf(obj.getCpf());

	}

	public List<Pessoa> listAll() {
		return pessoaRepository.findAll();
	}
	
	public List<Pessoa> findByNome(String nome) {
		return pessoaRepository.findByNome(nome);
		
	}
	
	public List<Pessoa> countP(String nome){
		return pessoaRepository.countp(nome);
	}
	
	public void delete(Long codigo) throws Exception {
		find(codigo);
		try{
			pessoaRepository.deleteById (codigo);
		}
		catch (DataIntegrityViolationException e) {
			throw new Exception("Não é possivel excluir");
		}
		
	}
}
