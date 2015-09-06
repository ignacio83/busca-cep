package br.com.afi.web.rest.busca.cep.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.afi.web.rest.busca.cep.domain.Endereco;

/**
 * Repositório de endereços.
 * 
 * @author André de Fontana Ignacio
 * @version 1.0
 */
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}
