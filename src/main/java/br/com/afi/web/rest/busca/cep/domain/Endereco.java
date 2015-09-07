package br.com.afi.web.rest.busca.cep.domain;

import java.io.Serializable;
import java.text.MessageFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Representa um endereço. Não é vinculado a um cliente.
 * 
 * @author André de Fontana Ignacio
 * @version 1.0
 */
@Entity
@Table(name="endereco")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length=8)
	@ApiModelProperty(value="CEP")
	private String cep;
	
	@Column(length=50,nullable=false)
	@ApiModelProperty(value="Logradouro")
	private String logradouro;
	
	@Column(length=30,nullable=false)
	@ApiModelProperty(value="Bairro")
	private String bairro;
	
	@Column(length=20,nullable=false)
	@ApiModelProperty(value="Cidade")
	private String cidade;
	
	@Column(length=2,nullable=false)
	@ApiModelProperty(value="Unidade Federal")
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
	 * 
	 * @throws InvalidCepException Lançado caso o CEP seja inválido 
	 */
	public Endereco(String cep, String logradouro, String bairro, String cidade, String uf) throws InvalidCepException {
		validateCep(cep);
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
	
	/**
	 * Valida se é um CEP.
	 * 
	 * @param cep CEP
	 * @throws InvalidCepException Caso o CEP seja inválido
	 */
	public static void validateCep(String cep) throws InvalidCepException{
		if(cep==null || !cep.matches("[0-9]{8}")){
			throw new InvalidCepException(cep);
		}
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
