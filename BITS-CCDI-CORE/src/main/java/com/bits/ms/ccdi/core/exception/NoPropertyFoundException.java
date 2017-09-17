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
package com.bits.ms.ccdi.core.exception;

import java.util.List;

/**
 * An exception that is thrown when there is no Property Component found for the
 * given CCDI Request. </br>
 * <p>
 * Each NoPropertyFoundException provides several kinds of information:</br>
 * <ul>
 * <li>E3ErrorMessage, containing the description of the error</li>
 * <li>cause, the underlying reason for the this NoPropertyFoundException</li>
 * </ul>
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @author Cognizant - Modified for E3
 * @version 1.0
 * @see E3Exception
 */
@SuppressWarnings("serial")
public class NoPropertyFoundException extends CCDCoreException {

	/**
	 * Constructs a NoPropertyFoundException object with the given errorSummary
	 * and cause
	 * 
	 * @param errorSummary
	 *            - description of the error
	 * @param errorDetail
	 *            - If there are multiple error messages associated with an
	 *            exception, this error details holds that list.
	 * @param cause
	 *            - the underlying reason for this NoPropertyFoundException
	 *            (which is saved for later retrieval by the getCause() method);
	 *            may be null indicating the cause is non-existent or unknown.
	 * @see E3Exception#E3Exception(E3ErrorMessage, List, Throwable) E3Exception
	 */
	public NoPropertyFoundException(String errorSummary,
			 Throwable cause) {
		super(errorSummary, cause);
	}


	/**
	 * Constructs a NoPropertyFoundException object
	 */
	public NoPropertyFoundException(String message) 
	{
		super(message);
	}

}
