package com.bits.ms.ccdi.exception;

public class CCDICacheException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;

	public CCDICacheException(String message) {
		super(message);
		this.message = message;
	}

	public CCDICacheException(Throwable cause) {
		super(cause);
	}

	public CCDICacheException(String message, Throwable cause) {
		super(message, cause);
	}

	public CCDICacheException(String message, Throwable cause,
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
