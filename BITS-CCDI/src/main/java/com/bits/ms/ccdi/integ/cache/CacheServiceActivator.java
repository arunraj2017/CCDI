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
package com.bits.ms.ccdi.integ.cache;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;

import com.bits.ms.ccdi.api.cache.CacheService;
import com.bits.ms.ccdi.api.constants.CcdiApiConstants;
import com.bits.ms.ccdi.api.io.CcdiRequest;
import com.bits.ms.ccdi.api.io.CcdiResponse;
import com.bits.ms.ccdi.entities.cntxt.ComponentElement;
import com.bits.ms.ccdi.entities.cntxt.ContextMetaData;
import com.bits.ms.ccdi.entities.cntxt.EnvironmentEntry;
import com.bits.ms.ccdi.entities.cntxt.Gateway;
import com.bits.ms.ccdi.entities.cntxt.GenericComponent;
import com.bits.ms.ccdi.entities.cntxt.GlossaryComponent;
import com.bits.ms.ccdi.entities.cntxt.Property;
import com.bits.ms.ccdi.entities.cntxt.Validator;
import com.bits.ms.ccdi.entities.cntxt.Verbiage;


/**
 * Cache Service Activator class to get/put the content from/to cache
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @author Cognizant - Modified for E3
 * @version 1.0
 */
@MessageEndpoint
public class CacheServiceActivator
{

	/**
	 * For logging
	 */
	private static final Logger LOGGER = LogManager.getLogger(CacheServiceActivator.class);

	/**
	 * Key builder class for generating the cache key by using ccdi request parameters
	 */
	@Autowired
	private KeyBuilder keyBuilder;
	/**
	 * Service to get and put the value from cache based on the component type
	 */
	@Autowired
	private CacheService cacheService;

	/**
	 * Returns the ccdi response from cache for the ccdi request or returns the ccdi request if cache doesn't have the requested ccdi
	 * response
	 * 
	 * @param ccdiRequest
	 *            ccdi request used to retrieve ccdi response
	 * @return an object which might be ccdi response or ccdi request
	 */
	public Object get(CcdiRequest ccdiRequest)
	{
		LOGGER.debug("ccdi Request..." + ccdiRequest);
		Object ccdiObject = null;
		try
		{
			if (ccdiRequest.getCheckCache())
			{
				ccdiObject = cacheService.get(ccdiRequest.getComponentElement().getComponentType(), keyBuilder.build(ccdiRequest));
				LOGGER.debug("ccdi Response from cache..." + ccdiObject);
				if(ccdiObject instanceof CcdiResponse){
					LOGGER.info("<---CACHE HIT----->");
				}else{
					LOGGER.info("<---CACHE MISS--->");
				}
			}
		} catch (Exception ex)
		{
			LOGGER.error("Error in cacheServiceActivator-get() :: " + ex);
		}
		return ccdiObject instanceof CcdiResponse ? (CcdiResponse) ccdiObject : ccdiRequest;
	}

	/**
	 * Stores the ccdi response object to the cache
	 * 
	 * @param ccdiResponse
	 *            the object to be stored in cache
	 * @return ccdi response stored in cache
	 */
	public CcdiResponse put(CcdiResponse ccdiResponse)
	{
		try
		{
			List<ComponentElement> componentElements = ccdiResponse.getComponentElements();
			if (componentElements != null && !componentElements.isEmpty())
			{
				cacheService.put(ccdiResponse.getCcdiRequest().getComponentElement().getComponentType(),
						keyBuilder.build(ccdiResponse.getCcdiRequest()), ccdiResponse);

				if (LOGGER.isDebugEnabled())
				{
					ComponentElement componentElement = ccdiResponse.getCcdiRequest().getComponentElement();
					LOGGER.debug("Cdi Request in Cache: " + getMetaDataLog(componentElement) + "Cdi Response Text in cache: "
							+ ccdiResponse.getComponentElements().get(0).getText());

				}
			}
		} catch (Exception ex)
		{
			LOGGER.error("Error in cacheServiceActivator-put() :: " + ex);
		}
		return ccdiResponse;
	}

	/**
	 * Returns the meta data of the component element as String. <BR/>
	 * The meta data will be constructed based on the component type
	 * 
	 * @param cmpentElement
	 *            component element of the ccdi response
	 * @return meta data of the component element
	 */
	private String getMetaDataLog(ComponentElement cmpentElement)
	{

		StringBuffer strBuff = new StringBuffer();
		String metaDataLog = null;
		try
		{
			if (cmpentElement != null)
			{
				if (CcdiApiConstants.COMPONENT_TYPE_GENERIC.equalsIgnoreCase(cmpentElement.getComponentType()))
				{
					GenericComponent standardContent = (GenericComponent) cmpentElement;
					addToBuffer(strBuff, "STD_CATEGORY", standardContent.getCategory());
					addToBuffer(strBuff, "STD_PAGE", standardContent.getPage());
					addToBuffer(strBuff, "STD_BLOCK", standardContent.getBlock());
				}
				else if (CcdiApiConstants.COMPONENT_TYPE_PROPERTY.equalsIgnoreCase(cmpentElement.getComponentType()))
				{
					Property property = (Property) cmpentElement;
					addToBuffer(strBuff, "PROPERTY_NAME", property.getName());
				}
				else if (CcdiApiConstants.COMPONENT_TYPE_ENV.equalsIgnoreCase(cmpentElement.getComponentType()))
				{
					EnvironmentEntry environmentEntry = (EnvironmentEntry) cmpentElement;
					addToBuffer(strBuff, "ENVIROMENT_KEY", environmentEntry.getKey());

				}
				else if (CcdiApiConstants.COMPONENT_TYPE_VERBIAGE.equalsIgnoreCase(cmpentElement.getComponentType()))
				{
					Verbiage verbiage = (Verbiage) cmpentElement;
					addToBuffer(strBuff, "VERBIAGE_KEY", verbiage.getKey());
				}
				else if (CcdiApiConstants.COMPONENT_TYPE_VALIDATOR.equalsIgnoreCase(cmpentElement.getComponentType()))
				{
					Validator validator = (Validator) cmpentElement;
					addToBuffer(strBuff, "VALIDATOR_ACTION", validator.getAction());

				}
				else if (CcdiApiConstants.COMPONENT_TYPE_GATEWAY.equalsIgnoreCase(cmpentElement.getComponentType()))
				{
					Gateway gateway = (Gateway) cmpentElement;
					addToBuffer(strBuff, "GATEWAY_ACTION", gateway.getAction());

				}
				else if (CcdiApiConstants.COMPONENT_TYPE_GLOSSARY.equalsIgnoreCase(cmpentElement.getComponentType()))
				{
					GlossaryComponent glossaryContent = (GlossaryComponent) cmpentElement;
					addToBuffer(strBuff, "GLOSSARY_TERM", glossaryContent.getGlossaryTerm());
				}
			}
			if (cmpentElement != null && cmpentElement.getMetaData() != null)
			{
				ContextMetaData metaData = cmpentElement.getMetaData().get(0);
				addToBuffer(strBuff, "<!-------Context Metadata", metaData.toString() + "------->");
			}
			String temp = strBuff.toString();
			metaDataLog = temp.substring(0, temp.length() - 1);
		} catch (Exception ex)
		{
			LOGGER.error("Error in cacheServiceActivator-getMetaDataLog() :: " + ex);
		}
		return metaDataLog;
	}

	/**
	 * Appends the key and value in the string buffer
	 * 
	 * @param buffer
	 *            String buffer where the key and value are appended
	 * @param key
	 *            Key to be appended in string buffer
	 * @param value
	 *            Value to be appended in string buffer
	 */
	private void addToBuffer(StringBuffer buffer, String key, String value)
	{
		buffer.append(key + "=" + value + ",");
	}

}
