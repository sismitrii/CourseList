package fr.eni.javaee.shoppinglist.exception;

public class BusinessException extends Exception{

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}

	
}
