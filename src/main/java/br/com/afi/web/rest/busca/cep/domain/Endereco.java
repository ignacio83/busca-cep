package br.com.afi.web.rest.busca.cep.domain;

import java.text.MessageFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representa um endereço. Não é vinculado a um cliente.
 * 
 * @author André de Fontana Ignacio
 * @version 1.0
 */
@Entity
@Table(name="endereco")
public class Endereco {
	
	@Id
	@Column(length=9)
	private String cep;
	
	@Column(length=50,nullable=false)
	private String logradouro;
	
	@Column(length=30,nullable=false)
	private String bairro;
	
	@Column(length=20,nullable=false)
	private String cidade;
	
	@Column(length=2,nullable=false)
	private String uf;
	
	/**
	 * Construtor padrão.
	 */
	public Endereco() {
		super();
	}
	
	/**
	 * Construtor.
	 * 
	 * @param cep Cep do endereço
	 * @param logradouro Logradouro 
	 * @param bairro Bairro
	 * @param cidade Cidade
	 * @param uf Unidade Federal
	 */
	public Endereco(String cep, String logradouro, String bairro, String cidade, String uf) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}

	public String getBairro() {
		return bairro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
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
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return MessageFormat.format("Endereco [cep={0}, logradouro={1}, bairro={2}, cidade={3}, uf={4}]",cep, logradouro, bairro, cidade, uf);
	}
}
