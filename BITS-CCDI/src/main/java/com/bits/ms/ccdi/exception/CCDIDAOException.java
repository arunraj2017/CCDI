package com.bits.ms.ccdi.exception;

public class CCDIDAOException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;



	public CCDIDAOException(String message) {
		super(message);
		this.message = message;
	}

	public CCDIDAOException(Throwable cause) {
		super(cause);
	}

	public CCDIDAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public CCDIDAOException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
