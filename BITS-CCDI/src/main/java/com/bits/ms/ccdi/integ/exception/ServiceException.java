/*
 * Application: Wellpoint Enrollment System
 * 
 * -------------------------------
 * Copyright (c) WellPoint, Inc
 * -------------------------------
 * This software is the confidential and proprietary information of WellPoint, Inc. ("Confidential Information").
 * You shall not disclose such confidential information, and shall use it only in accordance with the terms of the 
 * license agreement you entered into with WellPoint.
 */
package com.bits.ms.ccdi.integ.exception;

import java.util.List;

import com.bits.ms.ccdi.exception.CCDIException;

/**
 * <p>
 * This class represents standard E3 Service/Business layer exception.<br/>
 * <strong>Note:</strong> To be used only in Service/Business layer.
 * </p>
 * 
 * @see E3Exception
 * @version 1.0
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 */
@SuppressWarnings("serial")
public class ServiceException extends CCDIException {

	/**
	 * @see E3Exception#E3Exception(E3ErrorMessage, List, Throwable) E3Exception
	 */
	public ServiceException(String errorSummary,
			Throwable cause) {
		super(errorSummary,  cause);
	}

	/**
	 * @see E3Exception#E3Exception(String, String, Throwable) E3Exception
	 */
	public ServiceException( String message) {
		super( message);
	}

}
