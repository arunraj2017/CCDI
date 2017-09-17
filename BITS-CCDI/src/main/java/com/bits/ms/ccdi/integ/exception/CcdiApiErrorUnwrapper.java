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

import org.springframework.integration.Message;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.message.ErrorMessage;
import org.springframework.integration.message.GenericMessage;

/**
 * CcdiApiErrorUnwrapper transforms the error message to ServiceException. <BR />
 * All exceptions in integration layer will be routed to error channel which
 * will be transformed to ServiceException.
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * author Cognizant - Modified for E3
 * @version 1.0
 */
@MessageEndpoint
public class CcdiApiErrorUnwrapper {

	/**
	 * Unwrap the error message and transforms to ServiceException
	 * 
	 * @param errorMessage
	 *            Error message which has throwable payload
	 * @return generic message of type ServiceException
	 */
	@Transformer
	public Message<?> transform(ErrorMessage errorMessage) {
		Throwable exception = errorMessage.getPayload().getCause();
		String errorSummary = exception.getMessage();
		ServiceException ServiceException = new ServiceException(
				errorSummary,  exception);
		return new GenericMessage<ServiceException>(ServiceException);
	}
}
