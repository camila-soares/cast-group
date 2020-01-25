package exam;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Pessoa() {
		super();
	}


	public Pessoa(long codigo, String nome, String sexo,
			String email, Date dtnasc, String naturalidade, String nacionalidade,
			String cpf) {
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.dtnasc = dtnasc;
		this.naturalidade= nacionalidade;
		this.nacionalidade = nacionalidade;
		this.cpf = cpf;
				
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long codigo;

	@NotNull(message="Este campo é obrigatório")
	private String nome;

	private String sexo;
	
	@NotNull
	@Email(message="email inválido")
	private String email;

	@NotNull
	private Date dtnasc;

	private String naturalidade;
	
	private String nacionalidade;
	
	@NotNull
	@CPF(message = "cpf inválido")
	private String cpf;
	
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getDtnasc() {
		return dtnasc;
	}

	public void setDtnasc(Date dtnasc) {
		this.dtnasc = dtnasc;
	}
	
	public Long getCodigo() {
		return codigo;
	}

	public  Long setCodigo(Long codigo) {
		this.codigo = codigo;
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public String setNome(String nome) {
		 this.nome = nome;
		 return nome;
	}



	}
