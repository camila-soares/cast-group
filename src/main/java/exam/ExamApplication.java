package exam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import exam.repository.PessoaRepository;
import exam.repository.UnidadeRepository;

@SpringBootApplication
public class ExamApplication implements CommandLineRunner {

	@Autowired
	private UnidadeRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
		}

	@Override
	public void run(String... args) throws Exception {
		
		Unidade uni1 = new Unidade(null, "unidade - 1");
		Unidade uni2 = new Unidade(null, "unidade - 2");
		Unidade uni3 = new Unidade(null, "unidade - 3");
		Unidade uni4 = new Unidade(null, "unidade - 4");
		Unidade uni5 = new Unidade(null, "unidade - 5");
		
		
		Pessoa p1 = new Pessoa(null, "Usuário 1", "1.000");
		p1.setUnidade(uni1);
		Pessoa p2 = new Pessoa(null, "Usuário 2", "2.000");
		p2.setUnidade(uni2);
		Pessoa p3 = new Pessoa(null, "Usuário 3", "2.000");
		p3.setUnidade(uni3);
		Pessoa p4 = new Pessoa(null, "Usuário 4", "3.000");
		p4.setUnidade(uni4);
		Pessoa p5= new Pessoa(null, "Usuário 5", "4.000");
		p5.setUnidade(uni5);
		
		Set<Pessoa>pessoas = new HashSet<Pessoa>();
		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3);
		pessoas.add(p4);
		pessoas.add(p5);
		
		
		uni1.setPessoa(pessoas);
		//uni2.getPessoa().addAll(Arrays.asList(p4,p5));
		
		
		pessoaRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		repository.saveAll(Arrays.asList(uni1, uni2, uni3, uni4, uni5));
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


}
