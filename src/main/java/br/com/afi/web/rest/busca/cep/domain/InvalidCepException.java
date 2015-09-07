package br.com.afi.web.rest.busca.cep.domain;


/**
 * Exceção para casos em que o CEP não é válido
 * 
 * @author André de Fontana Ignacio
 * @version 1.0
 */
public class InvalidCepException extends Exception{
	private static final String MESSAGE = "CEP inválido";
	private static final long serialVersionUID = 1L;
	private final String invalidCep;
	
	/**
	 * Construtor.
	 * 
	 * @param invalidCep CEP que é inválido
	 */
	public InvalidCepException(String invalidCep){
		super(MESSAGE);
		this.invalidCep = invalidCep;
	}

	/**
	 * Obtém o CEP inválido.
	 * 
	 * @return CEP inválido
	 */
	public String getInvalidCep() {
		return invalidCep;
	}
}
