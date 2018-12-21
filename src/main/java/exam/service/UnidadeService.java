package exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import exam.Pessoa;
import exam.Unidade;
import exam.repository.UnidadeRepository;
import exam.service.exception.ObjectNotFoundException;

@Service
public class UnidadeService {

	@Autowired
	private UnidadeRepository uniRepositoty;


	public Unidade insert(Unidade unidade) {
		return uniRepositoty.save(unidade);
	}
	
	public List<Unidade> listAll() {
		return uniRepositoty.findAll();
	}
	
	public Unidade findById(Long codigo) {
		Optional<Unidade> obj = uniRepositoty.findById(codigo);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Código: " + codigo + ", Tipo: " + Unidade.class.getName()));
	}
	
	
	public Page<Unidade> findPage(Integer page,Integer linesForpage, String orderBy, String direction){
		PageRequest pageRequest = new PageRequest(page, linesForpage, Direction.valueOf(direction), orderBy);
		return uniRepositoty.findAll(pageRequest);
	}
	
	public Unidade contPessoas(Long codigo) {
		return uniRepositoty.countPessoas(codigo);
		
	}
	
	public Unidade sumSalario(Long codigo) {
		return uniRepositoty.sumSalario(codigo);
		
	}

}

