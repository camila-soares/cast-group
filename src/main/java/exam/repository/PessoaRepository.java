package exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import exam.Pessoa;
import exam.Unidade;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	
	//@Query("SELECT count(p) FROM p where p")
	/**
	 * Salva ou atualiza o objeto de pessoa no banco de dados. 
	 * Se o objeto tiver o c�digo informado, ent�o atualiza o 
	 * registro existente. Sen�o, salva o mesmo no banco de dados
	 * @param pessoa
	 */			
	//void registrarPessoa(Pessoa pessoa);
	
	/**
	 * Busca todos os registros de pessoa no banco de dados
	 * @return lista de pessoas
	 */
	//List<Pessoa> listar();
	
	/**
	 * Busca todos os registros de pessoa 
	 * que possuam o filtro informado no in�cio, 
	 * meio ou fim do nome
	 * @return lista de pessoas
	 */
	@Query("select p from Pessoa p where lower(p.nome) like lower(concat('%', ?1, '%'))")
	List<Pessoa> findByNome(@Param("nome")String nome);

}
