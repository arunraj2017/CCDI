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
package com.bits.ms.ccdi.api.integ.srvcs;

import com.bits.ms.ccdi.api.io.CcdiRequest;
import com.bits.ms.ccdi.api.io.CcdiResponse;

/**
 * Gateway interface to get the ccdi response for the ccdi request. The ccdi
 * response object will be retrieved from cache if it is available else will be
 * fetched from database based the ccdi request.
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @author Cognizant - Modified for E3
 * @version 1.0
 */

public interface CcdiService {

	/**
	 * Gateway method to get the ccdi response
	 * 
	 * @param request
	 *            The ccdi request which has the component element with meta
	 *            data
	 * @return ccdi response for the ccdi request
	 */
	CcdiResponse getComponent(CcdiRequest request);
	/**
	 * Gateway method to all CCDI admin services
	 * @param ccdiRequest
	 * @return CCDI Response
	 */
	CcdiResponse manageCcdiComponents(CcdiRequest ccdiRequest);
	
}
