package br.com.afi.web.rest.busca.cep.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.afi.web.rest.busca.cep.domain.Endereco;
import br.com.afi.web.rest.busca.cep.domain.InvalidCepException;
import br.com.afi.web.rest.busca.cep.service.CepService;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
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

	@Autowired
	private CepService cepService;
	
	/**
	 * Busca um endereço através do CEP.
	 * 
	 * @param cep CEP
	 * @return Endereço
	 * @throws InvalidCepException 
	 */
	@RequestMapping(value="/endereco/{cep}", method=RequestMethod.GET,
	        produces = MediaType.APPLICATION_JSON_VALUE
	)
	@ApiOperation(value="Obtém um endereço através do CEP informado")
	@ApiResponses(value = {
			@ApiResponse(code = 200, response=Endereco.class ,message = "Consulta realizada com sucesso"),
			@ApiResponse(code = ExceptionResolver.STATUS_CODE_INVALID_CEP, message = "CEP inválido"),
			@ApiResponse(code = 599, message = "Erro inesperado")
	})
    public @ResponseBody Endereco buscaCep(
    		@ApiParam(value="CEP", required=true) 
    		@PathVariable("cep") String cep) throws InvalidCepException {
		
        return cepService.findByCep(cep);
    }

}
