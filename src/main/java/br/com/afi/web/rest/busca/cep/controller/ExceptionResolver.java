package br.com.afi.web.rest.busca.cep.controller;

import br.com.afi.web.rest.busca.cep.domain.InvalidCepException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Exception Handler que indica o que irá ocorrer para cada uma das exceções.
 *
 * @author André de Fontana Ignacio
 * @version 1.0
 */
@RestControllerAdvice
public class ExceptionResolver {

	@ExceptionHandler(InvalidCepException.class)
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
	public Error invalidCepExceptionHandler(Exception exception) {
		return new Error(exception.getMessage());
	}
}
