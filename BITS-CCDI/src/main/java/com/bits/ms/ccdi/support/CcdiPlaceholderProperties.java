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
package com.bits.ms.ccdi.support;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bits.ms.ccdi.data.repo.dao.ComponentSelectorDao;
import com.bits.ms.ccdi.entities.cntxt.ComponentTypes;
import com.bits.ms.ccdi.exception.DataAccessException;


/**
 * 
 * The Properties class represents a persistent set of properties. Each key and its corresponding value in the property list is a string.
 * Retrieves the list of place holder config properties from CCDI
 * 
 * @author Cognizant
 * 
 */
public class CcdiPlaceholderProperties extends Properties
{

	/**
	 * For logging
	 */
	private static final Logger LOGGER = LogManager.getLogger(CcdiPlaceholderProperties.class);
	private static final long serialVersionUID = 1L;

	/**
	 * Default Environment name
	 */
	private static final String DEFAULT_ENVIRONMENT = "default";

	/**
	 * Key to retrieve the environment name
	 */
	private static final String ENVIRONMENT_KEY = "e3.environment";

	public CcdiPlaceholderProperties(ComponentSelectorDao componentSelectorDao) throws DataAccessException
	{
		super();
		List<Map<String, Object>> configProperties = componentSelectorDao.getPlaceHolderProperties();
		String envKey = System.getProperty(ENVIRONMENT_KEY);
		if (envKey == null)
		{
			envKey = DEFAULT_ENVIRONMENT;
		}
		for (Map<String, Object> configProperty : configProperties)
		{
			try
			{
				String compositeValue = configProperty.get("CNTNT_TXT").toString();
				String componentType = configProperty.get("CMPNT_TYPE_CD").toString();
				if (componentType!=null && ComponentTypes.EnvironmentEntry_Component.value().equals(componentType) && compositeValue != null && compositeValue.charAt(0) == '[' && compositeValue.charAt(compositeValue.length() - 1) == ']')
				{
					// parse the env values
					compositeValue = getPropertyValue(envKey, compositeValue);
				}

				setProperty(configProperty.get("ATRB_VAL").toString(), compositeValue);
			}
			catch(Exception e)
			{
				LOGGER.error("Error while setting the configProperty {}", configProperty.get("ATRB_VAL").toString(), e);
			}
		}
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
	private String getPropertyValue(String envKey, String compositeValue) throws DataAccessException
	{
		String regex = "\\[(.*?)\\]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(compositeValue);

		ArrayList matchList = new ArrayList();

		while (matcher.find())
		{
			int gcNumber = matcher.groupCount();
			matchList.add(matcher.group(gcNumber));
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
