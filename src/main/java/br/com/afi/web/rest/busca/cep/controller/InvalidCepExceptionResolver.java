package br.com.afi.web.rest.busca.cep.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.afi.web.rest.busca.cep.domain.InvalidCepException;

@ControllerAdvice
public class InvalidCepExceptionResolver {
	public static final int STATUS_CODE = 410;

	@ExceptionHandler(InvalidCepException.class)
    public void resolveAndWriteException(Exception exception, HttpServletResponse response) throws IOException {
        response.setStatus(STATUS_CODE);   
        IOUtils.write(exception.getMessage(), response.getOutputStream());
    }
}
