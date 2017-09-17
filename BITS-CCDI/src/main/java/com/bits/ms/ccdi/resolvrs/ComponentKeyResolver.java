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
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bits.ms.ccdi.api.constants.CcdiApiConstants;
import com.bits.ms.ccdi.api.integ.srvcs.CcdiService;
import com.bits.ms.ccdi.api.io.CcdiRequest;
import com.bits.ms.ccdi.api.io.CcdiResponse;
import com.bits.ms.ccdi.entities.cntxt.ComponentElement;
import com.bits.ms.ccdi.entities.cntxt.ContextMetaData;
import com.bits.ms.ccdi.entity.cntxt.ActivityContext;
import com.bits.ms.ccdi.entity.cntxt.BusinessContext;
import com.bits.ms.ccdi.entity.cntxt.Contexts;
import com.bits.ms.ccdi.entity.cntxt.RequestContext;
import com.bits.ms.ccdi.entity.cntxt.UserContext;


/**
 * <p>
 * The Resolver abstract class contains methods that are implemented by Component Subtypes.
 * </p>
 * 
 * @author Cognizant
 * @version 1.0
 * @see E3Exception
 */
@Component 
public abstract class ComponentKeyResolver
{

	@Qualifier("dozer.mapper.ccdiapi")
	@Autowired
	/**
	 * The Dozer mapper instance
	 */
	private Mapper mapper;

	/**
	 * Service class that handles all the CCDI requests
	 */
	@Autowired
	@Qualifier("ccdiServiceGate")
	private CcdiService ccdiService;

	/**
	 * Resolves the key and get the content from ccdi service based on the component type requested
	 * 
	 * @param contexts
	 *            - Context object that contains various properties about this particular request
	 * @param key
	 *            - The input parameter to the CCDI service. Example - For Property Component type the name of the property is the input.
	 *            This will be passed as key.
	 * 
	 * 
	 * @return Component Element containing the response content for the given request
	 */
	protected ComponentElement resolveKey(Contexts contexts, String key, Boolean checkCache)
	{
		ComponentElement componentElement = createComponentType(key);
		CcdiResponse cdiResponse = getComponent(constructCcdiRequest(contexts, componentElement, checkCache));
		ComponentElement outputCmpElement = null;
		List<ComponentElement> componentElements = cdiResponse
				.getComponentElements();
		if (componentElements != null && !componentElements.isEmpty()) {
			outputCmpElement = componentElements.get(0);
		}
		return outputCmpElement;
	}

	/**
	 * Call CCDIService.getComponent to get CCDI Response for the given request
	 * 
	 * @param ccdiRequest
	 * @return CcdiResponse
	 */
	protected CcdiResponse getComponent(CcdiRequest ccdiRequest)
	{
		return ccdiService.getComponent(ccdiRequest);
	}

	/**
	 * Construct CCDIRequest to be sent to the CCDIService
	 * 
	 * @param contexts
	 *            - Context object that contains various properties about this particular request
	 * @param key
	 *            - The input parameter to the CCDI service.
	 * @return CCDIRequest
	 */
	protected CcdiRequest constructCcdiRequest(Contexts contexts, ComponentElement componentElement, Boolean checkCache)
	{
		CcdiRequest ccdiRequest = new CcdiRequest();
		ccdiRequest.setCheckCache(checkCache);
		Contexts localContext = contexts;
		if (localContext == null)
		{
			localContext = new Contexts();
			localContext.setBusinessContext(new BusinessContext());
			localContext.setHttpContext(new com.bits.ms.ccdi.entity.cntxt.HttpContext());
			localContext.setActivityContext(new ActivityContext());
			localContext.setRequestContext(new RequestContext());
			localContext.setUserContext(new UserContext());
		}
		else
		{
			BusinessContext businessContext = new BusinessContext();
			businessContext.setName(CcdiApiConstants.APPLICATION_NAME);
			contexts.setBusinessContext(businessContext);
			if (null != localContext.getBusinessContext())
			{
				String applicationName = contexts.getBusinessContext().getName();
				if (applicationName == null)
				{
					contexts.getBusinessContext().setName(CcdiApiConstants.APPLICATION_NAME);
				}
			}
		}
		ContextMetaData contextMetaData = (ContextMetaData) mapper.map(contexts, ContextMetaData.class);

		List<ContextMetaData> contextMetaDataList = new ArrayList<ContextMetaData>();
		contextMetaDataList.add(contextMetaData);
		componentElement.setMetaData(contextMetaDataList);
		ccdiRequest.setComponentElement(componentElement);
		return ccdiRequest;
	}

	/**
	 * An abstract method to create the component element object. The concrete class provides the implementation for specific component
	 * type.
	 * 
	 * @param attributes
	 *            - The input parameter to the CCDI service. Example - For Property Component type the name of the property is the input.
	 *            This will be passed as key.
	 * @return The Request Component to the CCDI service containing the key
	 */
	protected abstract ComponentElement createComponentType(String... attributes);

}
