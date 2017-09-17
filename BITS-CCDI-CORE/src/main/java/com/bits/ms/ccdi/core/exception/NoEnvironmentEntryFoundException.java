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


/**
 * An exception that is thrown when there is no Environment Component found for
 * the given CCDI Request. </br>
 * <p>
 * Each NoEnvironmentEntryFoundException provides several kinds of
 * information:</br>
 * <ul>
 * <li>E3ErrorMessage, containing the description of the error</li>
 * <li>cause, the underlying reason for the this
 * NoEnvironmentEntryFoundException</li>
 * </ul>
 * <br>
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @author Cognizant - Modified for E3
 * @version 1.0
 * @see E3Exception
 * 
 */
@SuppressWarnings("serial")
public class NoEnvironmentEntryFoundException extends CCDCoreException {

	/**
	 * Constructs a NoEnvironmentEntryFoundException object with the given code,
	 * message and cause
	 * 
	 * @param code
	 *            - Exception message Code
	 * @param message
	 *            - a description of the exception
	 * @param cause
	 *            - the underlying reason for this
	 *            NoEnvironmentEntryFoundException (which is saved for later
	 *            retrieval by the getCause() method); may be null indicating
	 *            the cause is non-existent or unknown.
	 * @see E3Exception#E3Exception(String, String, Throwable) E3Exception
	 */
	public NoEnvironmentEntryFoundException( String message,
			Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a NoEnvironmentEntryFoundException object
	 */
	public NoEnvironmentEntryFoundException(String message) 
	{
		super(message);
	}

}
