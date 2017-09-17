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
 * A general-purpose object for representing a request flowing through the SIF layer 
 * All SIF request classes should extend this class
 * 
 * @author AB69987
 * @version 1.0
 *
 */
public class BaseAbstractRequest implements Serializable{

	private static final long serialVersionUID = 8777680017603821135L;
	
	private String requestId;
	
	private String correleationId;
	
	private Message requestMessage;

	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	/**
	 * @return the correleationId
	 */
	public String getCorreleationId() {
		return correleationId;
	}

	/**
	 * @param correleationId the correleationId to set
	 */
	public void setCorreleationId(String correleationId) {
		this.correleationId = correleationId;
	}

	/**
	 * @return the requestMessage
	 */
	public Message getRequestMessage() {
		return requestMessage;
	}

	/**
	 * @param requestMessage the requestMessage to set
	 */
	public void setRequestMessage(Message requestMessage) {
		this.requestMessage = requestMessage;
	}


}
