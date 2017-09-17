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
package com.bits.ms.ccdi.api.constants;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Constants used in CCDI API
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @author Cognizant - Modified for E3
 * @version 1.0
 */
public final class CcdiApiConstants
{
	private CcdiApiConstants()
	{

	}

	/**
	 * Component Attribute - Category , One of the attribute for Glossary component
	 */
	public static final String COMPONENT_ATTRIBUTE_CATEGORY = "category";
	/**
	 * Component Attribute - Page , One of the attribute for Glossary component
	 */
	public static final String COMPONENT_ATTRIBUTE_PAGE = "page";
	/**
	 * Component Attribute - block , One of the attribute for Glossary component
	 */
	public static final String COMPONENT_ATTRIBUTE_BLOCK = "block";

	/**
	 * Component Attribute - term , One of the attribute for Glossary component with wildcard
	 */
	public static final String COMPONENT_ATTRIBUTE_TERM = "term";
	/**
	 * Component Attribute - Name , One of the attribute for Property component
	 */
	public static final String COMPONENT_ATTRIBUTE_NAME = "name";
	/**
	 * Component Attribute value
	 */
	public static final String COMPONENT_ATTRIBUTE_VALUE = "value";

	/**
	 * Component Attribute - topics , One of the attribute for faq component
	 */
	public static final String COMPONENT_ATTRIBUTE_TOPICS = "topics";

	/**
	 * Component Attribute - action , One of the attribute for gateway component
	 */
	public static final String COMPONENT_ATTRIBUTE_ACTION = "action";
	/**
	 * Component Attribute - key , One of the attribute for verbiage and environment component
	 */
	public static final String COMPONENT_ATTRIBUTE_KEY = "key";
	/**
	 * "," - Comma
	 */
	public static final String COMMA = ",";
	/**
	 * Component Type Property
	 */
	public static final String COMPONENT_TYPE_PROPERTY = "PROPERTY";
	/**
	 * Component Type Environment
	 */
	public static final String COMPONENT_TYPE_ENV = "ENVIRONMENT";
	/**
	 * Component Type Verbiage
	 */
	public static final String COMPONENT_TYPE_VERBIAGE = "VERBIAGE";
	/**
	 * Component Type Gateway
	 */
	public static final String COMPONENT_TYPE_GATEWAY = "GATEWAY";
	/**
	 * Component Type Validator Ruleset
	 */
	public static final String COMPONENT_TYPE_VALIDATOR = "VALIDATOR";
	/**
	 * Component Type Generic
	 */
	public static final String COMPONENT_TYPE_GENERIC = "GENERIC";
	/**
	 * Component Type Glossary
	 */
	public static final String COMPONENT_TYPE_GLOSSARY = "GLOSSARY";

	/**
	 * Wellpoint Enrollment System - mnemonic - BITSMS
	 */
	public static final String APPLICATION_NAME = "BITSMS";

	/**
	 * Property Place Holders
	 */
	public static final String PLACEHOLDER_CONFIG = "PLACEHOLDER_CONFIG";

	public static final String CCDI_USER = "bits";

	/**
	 * Method that splits the passed in string with the delimiter and returns the list
	 * 
	 * @param str
	 *            the string contains delimiter separated data.
	 * @param delimiter
	 *            a character which will be used to seperate string.
	 * @return the list of Strings
	 */
	public static List<String> getArrayListFromString(String str, String delimiter)
	{
		if (str != null)
		{
			return new ArrayList<String>(Arrays.asList(str.split("delimiter")));
		}

		return null;
	}

}
