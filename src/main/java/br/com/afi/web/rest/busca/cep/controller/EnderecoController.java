package br.com.afi.web.rest.busca.cep.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.afi.web.rest.busca.cep.domain.Endereco;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * Controlador REST que provê os serviços de busca de endereço através do CEP.
 * 
 * @author André de Fontana Ignacio
 * @version 1.0
 */
@RestController
public class EnderecoController {

	/**
	 * Busca um endereço através do CEP.
	 * 
	 * @param cep CEP
	 * @return Endereço
	 */
	@RequestMapping(value="/endereco/{cep}", method=RequestMethod.GET)
	@ApiOperation(value="Obtém um endereço através do CEP informado")
	@ApiResponses(value = {
			@ApiResponse(code = 200, response=Endereco.class ,message = "Login realizado com sucesso"),
			@ApiResponse(code = 402, message = "CEP inválido"),
			@ApiResponse(code = 599, message = "Erro inesperado")
	})
    public @ResponseBody Endereco buscaCep(@RequestParam(value="cep", required=true) String cep) {
    	final Endereco endereco = new Endereco("01001-001", "Praça da Sé", "São Paulo", "SP");
    	
    	
        return endereco;
    }

}
