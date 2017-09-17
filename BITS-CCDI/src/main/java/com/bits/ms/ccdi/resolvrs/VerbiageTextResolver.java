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
package com.bits.ms.ccdi.resolvrs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.bits.ms.ccdi.core.exception.NoVerbiageTextFoundException;
import com.bits.ms.ccdi.entities.cntxt.ComponentElement;
import com.bits.ms.ccdi.entities.cntxt.Verbiage;
import com.bits.ms.ccdi.entity.cntxt.Contexts;

/**
 * This class retrieves the Verbiage component element for the given key. Along
 * with the Key, Other context information such as brand, state etc will also be
 * used while retrieving the content. If there are more than one record found
 * for the given request, the records will be scored and filtered based on the
 * context information requested
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @author Cognizant - Modified for E3
 * @version 1.0
 * @see ComponentKeyResolver
 */
@Component
public class VerbiageTextResolver extends ComponentKeyResolver 
{
	/**
	 * For logging
	 */
	private static final Logger LOGGER = LogManager.getLogger(VerbiageTextResolver.class);
	
	/**
	 * Calls resolveKey in ContextKeyResolver and returns the Verbiage component
	 * element
	 * 
	 * @param contexts
	 *            - Context object that contains various properties about this
	 *            particular request
	 * @param key
	 *            - the input parameter to retrieve the specific verbiage
	 *            component
	 * @return Verbiage component element
	 * @throws NoVerbiageTextFoundException 
	 */
	public Verbiage resolveText(Contexts contexts, String key) throws NoVerbiageTextFoundException {
		LOGGER.debug("(key,BusinessContext)->("+key+","+contexts.getBusinessContext()+")");
		Verbiage verbiage = (Verbiage) resolveKey(contexts, key, Boolean.TRUE);
		if(verbiage == null)
		{
			throw new NoVerbiageTextFoundException(
					"NO Verbiage text  found for " + key
							+ " key in CCDIAPI  And BusinessContext is: "
							+ contexts.getBusinessContext() + "UserContext is: "
							+ contexts.getUserContext());
		}
		LOGGER.debug("Verbiage=" + verbiage);
		return verbiage;
	}

	/**
	 * Creates verbiage request object with the key passed
	 * 
	 * @param key
	 *            - the input parameter to retrieve the specific verbiage
	 *            component
	 * @return Verbiage component element
	 */
	@Override
	protected ComponentElement createComponentType(String... attributes) {
		Verbiage verbiage = new Verbiage();
		verbiage.setKey(attributes[0]);
		return verbiage;
	}

}
