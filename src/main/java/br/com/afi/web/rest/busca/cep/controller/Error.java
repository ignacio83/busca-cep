package br.com.afi.web.rest.busca.cep.controller;

public class Error {
	private final String message;

	public Error(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
