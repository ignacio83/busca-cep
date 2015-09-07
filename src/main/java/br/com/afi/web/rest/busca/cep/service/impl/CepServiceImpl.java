package br.com.afi.web.rest.busca.cep.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.afi.web.rest.busca.cep.domain.Endereco;
import br.com.afi.web.rest.busca.cep.domain.InvalidCepException;
import br.com.afi.web.rest.busca.cep.repository.EnderecoRepository;
import br.com.afi.web.rest.busca.cep.service.CepService;

/**
 * Implementação das regras de negócio relacionadas a consulta de CEP.
 * 
 * @author André de Fontana Ignacio
 * @version 1.0
 */
@Service
public class CepServiceImpl implements CepService {
	private static final String CEP_ZEROS = "00000000";
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Transactional(readOnly=true)
	public Endereco findByCep(String cep) throws InvalidCepException {
		Endereco.validateCep(cep);
		Endereco endereco = null;
		if(!CEP_ZEROS.equals(cep)){
			endereco = enderecoRepository.findOne(cep);
			if(endereco==null){
				final String cepAjustado = substituiPorZerosDaDiretaParaEsquerda(cep);
				endereco = findByCep(cepAjustado);
			}
		}
		return endereco;
	}
	
	/**
	 * Subsitui o último caracter que não é zero da direito para a esquerda.
	 * 
	 * @param cep CEP
	 * @return CEP ajustado
	 */
	private String substituiPorZerosDaDiretaParaEsquerda(String cep){
		boolean substituido=false;
		final StringBuilder sb = new StringBuilder();
		final char[] charArray = cep.toCharArray();
		//Percorre o array ao contrário
		for(int i=charArray.length-1;i!=-1;i--){
			char c = charArray[i];
			if(c!='0' && !substituido){
				c='0';
				substituido=true;
			}
			sb.append(c);
		}
		return StringUtils.reverse(sb.toString());
	}

}
