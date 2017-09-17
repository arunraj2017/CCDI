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
package com.bits.ms.ccdi.exception;

import java.util.List;

/**
 * <p>
 * This class represents standard E3 Data layer exception.<br/>
 * <strong>Note:</strong> To be used only in Data access layer.
 * </p>
 * 
 * @see E3Exception
 * @version 1.0
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 */
@SuppressWarnings("serial")
public class DataAccessException extends CCDIException {

	/**
	 * @see E3Exception#E3Exception(E3ErrorMessage, List, Throwable) E3Exception
	 */
	public DataAccessException(String errorSummary,
			 Throwable cause) {
		super(errorSummary, cause);
	}

	/**
	 * @see E3Exception#E3Exception(String, String, Throwable) E3Exception
	 */
	public DataAccessException(String code) {
		super(code);
	}

}
