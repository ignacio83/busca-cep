package br.com.afi.web.rest.busca.cep.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.afi.web.rest.busca.cep.domain.InvalidCepException;

/**
 * Exception Handler que indica o que irá ocorrer para cada uma das exceções.
 * 
 * @author André de Fontana Ignacio
 * @version 1.0
 */
@ControllerAdvice
public class ExceptionResolver {
	public static final int STATUS_CODE_INVALID_CEP = 420;

	@ExceptionHandler(InvalidCepException.class)
    public void invalidCepExceptionHandler(Exception exception, HttpServletResponse response) throws IOException {
        response.setStatus(STATUS_CODE_INVALID_CEP);   
        IOUtils.write(exception.getMessage(), response.getOutputStream());
    }
}
