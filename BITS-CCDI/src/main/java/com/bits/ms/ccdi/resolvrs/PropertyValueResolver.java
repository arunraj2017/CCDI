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

import com.bits.ms.ccdi.core.exception.NoPropertyFoundException;
import com.bits.ms.ccdi.entities.cntxt.ComponentElement;
import com.bits.ms.ccdi.entities.cntxt.Property;
import com.bits.ms.ccdi.entity.cntxt.Contexts;

/**
 * This class retrieves the Property component element for the given property
 * name. Along with the name, Other context information such as brand, state etc
 * will also be used while retrieving the content. If there are more than one
 * record found for the given request, the records will be scored and filtered
 * based on the context information requested
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @author Cognizant - Modified for E3
 * @version 1.0
 * @see ComponentKeyResolver
 */
@Component
public class PropertyValueResolver extends ComponentKeyResolver {

	/**
	 * For logging
	 */
	private static final Logger LOGGER = LogManager
			.getLogger(PropertyValueResolver.class);

	/**
	 * Calls resolveKey in ContextKeyResolver and returns the Property component
	 * element. If no property found, NoPropertyFoundException will be thrown.
	 * Checks in DB if and only if no property found in Cache.
	 * 
	 * @param contexts
	 *            - Context object that contains various properties about this
	 *            particular request
	 * @param name
	 *            Property name
	 * @return Property component element
	 * @throws NoPropertyFoundException
	 *             NoPropertyFoundException will be thrown, if no property found
	 */
	public Property resolveProperty(Contexts contexts, String name)
			throws NoPropertyFoundException {

		return resolve(contexts, name, Boolean.TRUE);
	}

	/**
	 * Calls resolveKey in ContextKeyResolver and returns the Property component
	 * element. If no property found, NoPropertyFoundException will be thrown.
	 * Checks in DB only.
	 * 
	 * @param contexts
	 *            - Context object that contains various properties about this
	 *            particular request
	 * @param name
	 *            Property name
	 * @return Property component element
	 * @throws NoPropertyFoundException
	 *             NoPropertyFoundException will be thrown, if no property found
	 */
	public Property resolvePropertyFromDB(Contexts contexts, String name)
			throws NoPropertyFoundException {

		return resolve(contexts, name, Boolean.FALSE);
	}

	/**
	 * Calls resolveKey in ContextKeyResolver and returns the Property component
	 * element. If no property found, NoPropertyFoundException will be thrown.
	 * 
	 * @param contexts
	 *            - Context object that contains various properties about this
	 *            particular request
	 * @param name
	 *            Property name
	 * @param checkCache
	 *            - Check cache indicator
	 * 
	 * @return Property component element
	 * @throws NoPropertyFoundException
	 *             NoPropertyFoundException will be thrown, if no property found
	 */
	private Property resolve(Contexts contexts, String name, Boolean checkCache)
			throws NoPropertyFoundException {

		LOGGER.debug("(Name,BusinessContext)->(" + name + ","
				+ contexts.getBusinessContext() + ")");
		Property property = (Property) resolveKey(contexts, name, checkCache);
		if (property == null) {
			throw new NoPropertyFoundException("NO Property  found for " + name
					+ " Name in CCDIAPI  And BusinessContext is: "
					+ contexts.getBusinessContext() + "UserContext is: "
					+ contexts.getUserContext());

		}
		LOGGER.debug("Property=" + property);
		return property;
	}

	/**
	 * Creates Property Request object with the property name passed
	 * 
	 * @param name
	 *            Property name
	 * @return Property component element
	 */
	@Override
	protected ComponentElement createComponentType(String... attributes) {
		Property property = new Property();
		property.setName(attributes[0]);
		return property;
	}

}
