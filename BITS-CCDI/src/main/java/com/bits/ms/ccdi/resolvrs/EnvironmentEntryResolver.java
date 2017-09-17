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


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.bits.ms.ccdi.core.exception.NoEnvironmentEntryFoundException;
import com.bits.ms.ccdi.entities.cntxt.ComponentElement;
import com.bits.ms.ccdi.entities.cntxt.EnvironmentEntry;
import com.bits.ms.ccdi.entity.cntxt.Contexts;


/**
 * This class retrieves the EnvironmentEntry component element for a given key. Along with the Key, Other context information such as brand,
 * state etc will also be used while retrieving the content. If there are more than one record found for the given request, the records will
 * be scored and filtered based on the context information requested
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @author Cognizant - Modified for E3
 * @version 1.0
 * @see ComponentKeyResolver
 */
@Component
public class EnvironmentEntryResolver extends ComponentKeyResolver
{

	/**
	 * For logging
	 */
	private static final Logger LOGGER = LogManager.getLogger(EnvironmentEntryResolver.class);

	/**
	 * Default Environment name
	 */
	private static final String DEFAULT_ENVIRONMENT = "default";
	/**
	 * Key to retrieve the environment name
	 */
	private static final String ENVIRONMENT_KEY = "bits.environment";

	/**
	 * Calls resolveKey in ContextKeyResolver and returns the EnvironmentEntry component element. If no EnvironmentEntry found,
	 * NoEnvironmentEntryFoundException will be thrown.
	 * 
	 * @param contexts
	 *            - Context object that contains various properties about this particular request
	 * @param key
	 *            - The input parameter to the CCDI service. For Environment Component type the key value present in the ComponentAttribute
	 *            table is the input.
	 * @return EnvironmentEntry component element
	 * @throws NoEnvironmentEntryFoundException
	 *             NoEnvironmentEntryFoundException will be thrown, if no Environment Entry found
	 */
	public EnvironmentEntry resolveEnvironmentEntry(Contexts contexts, String key) throws NoEnvironmentEntryFoundException
	{
		EnvironmentEntry environmentEntry = null;
		LOGGER.debug("(Key,BusinessContext)->(" + key + "," + contexts.getBusinessContext() + ")");
		ComponentElement componentElement = resolveKey(contexts, key, Boolean.TRUE);
		if (componentElement == null)
		{
			throw new NoEnvironmentEntryFoundException( "NO Environment Entry  found for " + key
					+ " key in CCDIAPI  And BusinessContext is: " + contexts.getBusinessContext() + "UserContext is: "
					+ contexts.getUserContext());
		}

		String compositeValue = componentElement.getText();
		String envProp = null;
		if (compositeValue != null)
		{
			envProp = parsePropertyValue(compositeValue);
		}
		componentElement.setText(envProp);
		environmentEntry = (EnvironmentEntry) componentElement;
		LOGGER.debug("EnvironmentEntry=" + environmentEntry);
		return environmentEntry;
	}

	/**
	 * Creates EnvironmentEntry object with the key name passed
	 * 
	 * @param key
	 *            - The input parameter to the CCDI service. For Environment Component type the key value present in the ComponentAttribute
	 *            table is the input.
	 * @return Environment Entry component element
	 */
	@Override
	protected ComponentElement createComponentType(String... attributes)
	{
		EnvironmentEntry environmentEntry = new EnvironmentEntry();
		environmentEntry.setKey(attributes[0]);
		return environmentEntry;
	}

	/**
	 * Parses the composite Environment component text. A Single Environment Component holds information about different environment for the
	 * given key. This has to be parsed to get the information specific to the current JVM environment
	 * 
	 * @param compositeValue
	 *            The value to be parsed
	 * @return Parsed value based on the environment
	 */
	private String parsePropertyValue(String compositeValue)
	{
		String envKey = System.getProperty(ENVIRONMENT_KEY);
		String value = compositeValue;
		if (envKey == null)
		{
			envKey = DEFAULT_ENVIRONMENT;
		}

		if (value.charAt(0) == '[' && value.charAt(value.length() - 1) == ']')
		{
			// parse the env values
			value = getPropertyValue(envKey, compositeValue);
		}
		return value;
	}

	/**
	 * Parses the composite value using regular expression and splits the match with : Based on the environment returns the value for the
	 * key.
	 * 
	 * @param envKey
	 *            current environment key
	 * @param compositeValue
	 *            Composite value to be parsed
	 * @return Component value based on the environment
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private String getPropertyValue(String envKey, String compositeValue)
	{
		String regex = "\\[(.*?)\\]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(compositeValue);

		ArrayList matchList = new ArrayList();

		while (m.find())
		{
			int gc = m.groupCount();
			matchList.add(m.group(gc));
		}

		String defaultValue = null;
		for (int i = 0; i < matchList.size(); i++)
		{
			String[] pair = ((String) matchList.get(i)).split(":", 2);
			String key = pair[0];
			String value = pair[1];

			if (("," + key + ",").indexOf("," + DEFAULT_ENVIRONMENT + ",") >= 0)
			{
				defaultValue = value;
			}

			if (("," + key + ",").indexOf("," + envKey + ",") >= 0)
			{
				// key contains envKey, so this must match
				LOGGER.debug("getPropertyValue (" + envKey + ") " + compositeValue + " --> " + value + ".");
				return value;
			}
		}

		// this means that the envKey is not in the list; so return the
		// "default" one
		LOGGER.debug("getPropertyValue (" + envKey + ") " + compositeValue + " --> " + defaultValue + ".");
		return defaultValue;
	}

}
