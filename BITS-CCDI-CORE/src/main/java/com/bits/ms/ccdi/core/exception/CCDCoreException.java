package com.bits.ms.ccdi.core.exception;

public class CCDCoreException extends Exception {

	private String message;
	private static final long serialVersionUID = 1L;


	public CCDCoreException(String message) {
		super(message);
		this.message = message;
	}

	public CCDCoreException(Throwable cause) {
		super(cause);
	}

	public CCDCoreException(String message, Throwable cause) {
		super(message, cause);
	}

	public CCDCoreException(String message, Throwable cause,
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
