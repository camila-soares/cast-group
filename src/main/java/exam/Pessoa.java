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
	@GeneratedValue(strategy=GenerationType.AUTO)	
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


	@Override
	public String toString() {
		return "Pessoa [codigo=" + codigo + ", nome=" + nome + ", sexo=" + sexo + ", email=" + email + ", dtnasc="
				+ dtnasc + ", naturalidade=" + naturalidade + ", nacionalidade=" + nacionalidade + ", cpf=" + cpf + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dtnasc == null) ? 0 : dtnasc.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nacionalidade == null) ? 0 : nacionalidade.hashCode());
		result = prime * result + ((naturalidade == null) ? 0 : naturalidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dtnasc == null) {
			if (other.dtnasc != null)
				return false;
		} else if (!dtnasc.equals(other.dtnasc))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nacionalidade == null) {
			if (other.nacionalidade != null)
				return false;
		} else if (!nacionalidade.equals(other.nacionalidade))
			return false;
		if (naturalidade == null) {
			if (other.naturalidade != null)
				return false;
		} else if (!naturalidade.equals(other.naturalidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		return true;
	}



	}
