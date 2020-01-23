package exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import exam.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	@Query("SELECT count(*) FROM Pessoa p")
	List<Pessoa> countp (@Param("nome") String nome);
	
	@Query("select p from Pessoa p where lower(p.nome) like lower(concat('%', ?1, '%'))")
	List<Pessoa> findByNome(@Param("nome")String nome);

}
