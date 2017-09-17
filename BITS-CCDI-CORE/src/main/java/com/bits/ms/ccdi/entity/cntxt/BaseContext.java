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
package com.bits.ms.ccdi.entity.cntxt;

import java.io.Serializable;

/**
 * An abstract class to represent the context object which has context id and
 * context state. The possible context states are Partial and Final.
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @version 1.0
 * 
 */
public abstract class BaseContext implements Serializable {

	private static final long serialVersionUID = -3553178103779183196L;

	/**
	 * Context ID
	 */
	private String contextId;

	/**
	 * Context State
	 */
	public enum ContextState {
		PARTIAL, FINAL
	};

	private ContextState contextState;

	/**
	 * @return the contextId
	 */
	public String getContextId() {
		return contextId;
	}

	/**
	 * @param contextId the contextId to set
	 */
	public void setContextId(String contextId) {
		this.contextId = contextId;
	}

	/**
	 * @return the contextState
	 */
	public ContextState getContextState() {
		return contextState;
	}

	/**
	 * @param contextState the contextState to set
	 */
	public void setContextState(ContextState contextState) {
		this.contextState = contextState;
	}

	@Override
	public String toString() {
		return "BaseContext [contextId=" + contextId + ", contextState="
				+ contextState + "]";
	}


}
