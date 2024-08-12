package br.com.soc.sistema.exception;

public class BusinessException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8331547014586473427L;

	public BusinessException(String mensagem) {
		super(mensagem);
	}
}
