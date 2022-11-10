package br.com.afi.web.rest.busca.cep.controller;


import br.com.afi.web.rest.busca.cep.domain.Endereco;
import br.com.afi.web.rest.busca.cep.domain.InvalidCepException;
import br.com.afi.web.rest.busca.cep.service.CepService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	 */
	@GetMapping(value = "/endereco/{cep}",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	@Operation(summary = "Obtém um endereço através do CEP informado")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Consulta realizada com sucesso", content = @Content(schema = @Schema(implementation = Endereco.class))),
			@ApiResponse(responseCode = "422", description = "CEP inválido", content = @Content(schema = @Schema(implementation = Error.class)))
	})
	public @ResponseBody Endereco buscaCep(
			@Parameter(name = "cep", required = true)
			@PathVariable("cep") String cep) throws InvalidCepException {

		return cepService.findByCep(cep);
	}

}
