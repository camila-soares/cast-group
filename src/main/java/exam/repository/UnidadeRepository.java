package exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import exam.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {
	
	/**
	 * Contagem de pessoas lotadas na unidade
	 * @param quantidade
	 */			
	@Query("SELECT count(p) FROM Pessoa p WHERE p.unidade.codigo =:codigo")
	Unidade countPessoas(@Param("codigo") Long codigo);
	
	
	/**
	 * Somat�rio de sal�rio das pessoas lotadas na unidade
	 * @param total
	 */			
	@Query("SELECT sum(p.salario) From Pessoa p  WHERE p.unidade.codigo = :codigo")
	Unidade sumSalario(@Param ( "codigo" ) Long codigo);
	
	/**
	 * Relat�rio de unidades, mostrando a quantidade de pessoas e total de sal�rios por unidade
	 * Pode-se criar dois atributos transientes (@Transient) para armazenar esses valores
	 * @param lista de unidade com totais calculados
	 */			
	//List<Unidade> relatorio();

}
