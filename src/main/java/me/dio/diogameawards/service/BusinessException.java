package me.dio.diogameawards.service;

public class BusinessException extends RuntimeException {

	/**
	 * Para retornar uma mensagem personalizada ao front
	 */
	private static final long serialVersionUID = 1L;
	
	public BusinessException(String message) {
		super(message);
	}

}
