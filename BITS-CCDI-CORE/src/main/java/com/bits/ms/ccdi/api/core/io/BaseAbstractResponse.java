/*
 * Application: E3
 * 
 * -------------------------------
 * Copyright (c) WellPoint, Inc
 * -------------------------------
 * This software is the confidential and proprietary information of WellPoint, Inc. ("Confidential Information").
 * You shall not disclose such confidential information, and shall use it only in accordance with the terms of the 
 * license agreement you entered into with WellPoint.
 */
package com.bits.ms.ccdi.api.core.io;

import java.io.Serializable;

/**
 * A general-purpose object for representing a response flowing through the SIF layer 
 * All SIF response classes should extend this class
 * 
 * @author AB69987
 * @version 1.0
 * 
 */
public class BaseAbstractResponse implements Serializable {

	private static final long serialVersionUID = 8446318922728950451L;

	private String responseId;

	private String correlationId;

	private Message responseMessage;

	private Message errorMessage;

	private String responseCode;

	private String responseCodeMessage;

	/**
	 * @return the responseId
	 */
	public String getResponseId() {
		return responseId;
	}

	/**
	 * @param responseId the responseId to set
	 */
	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	/**
	 * @return the correlationId
	 */
	public String getCorrelationId() {
		return correlationId;
	}

	/**
	 * @param correlationId the correlationId to set
	 */
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	/**
	 * @return the responseMessage
	 */
	public Message getResponseMessage() {
		return responseMessage;
	}

	/**
	 * @param responseMessage the responseMessage to set
	 */
	public void setResponseMessage(Message responseMessage) {
		this.responseMessage = responseMessage;
	}

	/**
	 * @return the errorMessage
	 */
	public Message getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(Message errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the responseCodeMessage
	 */
	public String getResponseCodeMessage() {
		return responseCodeMessage;
	}

	/**
	 * @param responseCodeMessage the responseCodeMessage to set
	 */
	public void setResponseCodeMessage(String responseCodeMessage) {
		this.responseCodeMessage = responseCodeMessage;
	}


}
