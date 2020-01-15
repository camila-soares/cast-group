package exam;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa implements Serializable{
	public Pessoa(Long codigo, String nome, String sexo, String email, int i, String naturalidade,
			String nascionalidade2, String cpf2) {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigo;

	@NotEmpty(message="Este campo é obrigatório")
	private String nome;
	
	private String sexo;
	@NotNull
	@Email(message="email inválido")
	private String email;
	
	@NotNull
	private Date dtnasc;

	private String naturalidade;
	
	private String nacionalidade;
	
	@CPF(message = "cpf inválido")
	private String cpf;
	

	}
