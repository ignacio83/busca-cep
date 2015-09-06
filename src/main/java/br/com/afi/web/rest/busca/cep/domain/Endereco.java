package br.com.afi.web.rest.busca.cep.domain;

/**
 * Representa um endereço de um local. Não é vinculado a um cliente.
 * 
 * @author André de Fontana Ignacio
 * @version 1.0
 */
public class Endereco {
	private final String cep;
	private final String logradouro;
	private final String cidade;
	private final String uf;
	
	/**
	 * Construtor.
	 * 
	 * @param cep Cep do endereço
	 * @param logradouro Logradouro 
	 * @param cidade Cidade
	 * @param uf Unidade Federal
	 */
	public Endereco(String cep, String logradouro, String cidade, String uf) {
		this.cep = cep;
		this.logradouro = logradouro;
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
}
