package br.com.afi.web.rest.busca.cep;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.afi.web.rest.busca.cep.domain.Endereco;
import br.com.afi.web.rest.busca.cep.domain.InvalidCepException;
import br.com.afi.web.rest.busca.cep.repository.EnderecoRepository;

/**
 * Responsável por popular o banco de dados com os dados iniciais.
 * 
 * @author André de Fontana Ignacio
 * @version 1.0
 */
@Component
public class DatabaseInitializer {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@PostConstruct
	@Transactional
	public void setup() throws InvalidCepException{
		final Endereco endereco1 = new Endereco("01001001", "Praça da Sé", "Sé","São Paulo", "SP");
		final Endereco endereco2 = new Endereco("01001000", "Praça da Sé", "Sé","São Paulo", "SP");
		final Endereco endereco3 = new Endereco("01002001", "Rua Direita", "Sé","São Paulo", "SP");
		final Endereco endereco4 = new Endereco("07914140", "Rua Vergueiro", "Jardim Bom Sucesso", "Francisco Morato", "SP");

		enderecoRepository.save(endereco1);
		enderecoRepository.save(endereco2);
		enderecoRepository.save(endereco3);
		enderecoRepository.save(endereco4);
	}
}
