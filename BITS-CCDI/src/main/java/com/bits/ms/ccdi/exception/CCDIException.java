package com.bits.ms.ccdi.exception;

public class CCDIException extends Exception {

	private String message;
	private static final long serialVersionUID = 1L;


	public CCDIException(String message) {
		super(message);
		this.message = message;
	}

	public CCDIException(Throwable cause) {
		super(cause);
	}

	public CCDIException(String message, Throwable cause) {
		super(message, cause);
	}

	public CCDIException(String message, Throwable cause,
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
