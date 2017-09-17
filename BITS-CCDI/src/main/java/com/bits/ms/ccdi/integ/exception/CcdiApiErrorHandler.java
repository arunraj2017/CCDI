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

import org.springframework.integration.annotation.MessageEndpoint;

/**
 * A service activator attached to error channel to handle the exceptions. This
 * class throws the ServiceException
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * author Cognizant - Modified for E3
 * @version 1.0
 */
@MessageEndpoint
public class CcdiApiErrorHandler {

	/**
	 * Throws the ServiceException received from CcdiApiErrorUnwrapper
	 * 
	 * @param exception
	 *            The ServiceException received from CcdiApiErrorUnwrapper
	 * @throws ServiceException
	 */
	public void onError(ServiceException exception) throws ServiceException {
		throw exception;
	}
}
