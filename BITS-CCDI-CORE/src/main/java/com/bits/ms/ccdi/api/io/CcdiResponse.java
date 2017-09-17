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
package com.bits.ms.ccdi.api.io;


import java.io.Serializable;
import java.util.List;

import com.bits.ms.ccdi.api.core.io.BaseAbstractResponse;
import com.bits.ms.ccdi.entities.cntxt.ComponentElement;

/**
 * This class represents Ccdi Response object which has list of component elements for the ccdi request. Inherits other properties from BaseResponse.
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @version 1.0
 *
 */
public class CcdiResponse extends BaseAbstractResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * The CCDI Request
	 */
	private CcdiRequest ccdiRequest;
	
	/**
	 * The CCDI response components for the given request
	 */
	private List<ComponentElement> componentElements;

	/**
	 * @return the ccdiRequest
	 */
	public CcdiRequest getCcdiRequest() {
		return ccdiRequest;
	}

	/**
	 * @param ccdiRequest the ccdiRequest to set
	 */
	public void setCcdiRequest(CcdiRequest ccdiRequest) {
		this.ccdiRequest = ccdiRequest;
	}

	/**
	 * @return the componentElements
	 */
	public List<ComponentElement> getComponentElements() {
		return componentElements;
	}

	/**
	 * @param componentElements the componentElements to set
	 */
	public void setComponentElements(List<ComponentElement> componentElements) {
		this.componentElements = componentElements;
	}

	/**
	 * Displays CCID response.
	 */
	@Override
	public String toString() {
		return "CcdiResponse [ccdiRequest=" + ccdiRequest
				+ ", componentElements=" + componentElements + "]";
	}


			
}
