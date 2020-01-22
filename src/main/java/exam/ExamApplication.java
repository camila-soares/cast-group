package exam;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import exam.repository.PessoaRepository;

@SpringBootApplication
public class ExamApplication implements CommandLineRunner {

	@Autowired
private PessoaRepository pessoaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
		}

	@Override
	public void run(String... args) throws Exception {
		
//		Pessoa p1  = new Pessoa(null, "Usuário 1", "feminino", "teste@teste.com", new Date(10-10-2000), "Recife", "brasileira"
//						,  "08146639402");
//		
//
//		Pessoa p2= new Pessoa(null, "Usuário 2", "masculino", "user@user.com", new Date(22-01-2000), "Belo Horizonte", "brasileira"
//				, "03335322444");
//		
//		pessoaRepository.saveAll(Arrays.asList(p1,p2));
		
		
	}

}
