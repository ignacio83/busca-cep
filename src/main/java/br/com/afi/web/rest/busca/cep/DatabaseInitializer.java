package br.com.afi.web.rest.busca.cep;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.afi.web.rest.busca.cep.domain.Endereco;
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
	public void setup(){
		final Endereco endereco1 = new Endereco("01001-001", "Praça da Sé", "Sé","São Paulo", "SP");
		final Endereco endereco2 = new Endereco("01002-001", "Rua Direita", "Sé","São Paulo", "SP");
		final Endereco endereco3 = new Endereco("07914-140", "Rua Vergueiro", "Jardim Bom Sucesso", "Francisco Morato", "SP");

		enderecoRepository.save(endereco1);
		enderecoRepository.save(endereco2);
		enderecoRepository.save(endereco3);
	}
}
