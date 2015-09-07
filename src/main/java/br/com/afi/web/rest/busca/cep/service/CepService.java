package br.com.afi.web.rest.busca.cep.service;

import br.com.afi.web.rest.busca.cep.domain.Endereco;
import br.com.afi.web.rest.busca.cep.domain.InvalidCepException;

/**
 * Regras de negócio relacionadas a consulta de CEP.
 * 
 * @author André de Fontana Ignacio
 * @version 1.0
 */
public interface CepService {

	/**
	 * Busca o endereço do CEP de forma inteligente. Caso o CEP informado seja válido e nenhum endereço seja encontrado.
	 * Os último digito será subsitu[ido por '0' e realizará a consulta novamente, caso não seja encontrado, substituirá o 
	 * antepenúltimo digito por '0'e efetuará a consulta novamente, esse processo se repete até que um CEP seja encontrado ou
	 * todos os digitos estejam zerados.
	 * 
	 * @param cep CEP
	 * @return Endereço do CEP ou NULL caso nenhum endereço seja encontrado.
	 * @throws InvalidCepException Caso o CEP não seja válido
	 */
	Endereco findByCep(String cep) throws InvalidCepException;
}
