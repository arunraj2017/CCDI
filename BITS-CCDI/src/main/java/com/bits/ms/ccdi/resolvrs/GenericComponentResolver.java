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


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.bits.ms.ccdi.api.io.CcdiRequest;
import com.bits.ms.ccdi.api.io.CcdiResponse;
import com.bits.ms.ccdi.entities.cntxt.ComponentElement;
import com.bits.ms.ccdi.entities.cntxt.GenericComponent;
import com.bits.ms.ccdi.entity.cntxt.Contexts;


/**
 * This class retrieves the Generic component element for a given page, category and block. Other context information such as brand, state
 * etc will also be used while retrieving the content. If there are more than one record found for the given request, the records will be
 * scored and filtered based on the context information requested
 * 
 * @author Cognizant
 * @version 1.0
 * @see ComponentKeyResolver
 */
@Component
public class GenericComponentResolver extends ComponentKeyResolver
{

	/**
	 * For logging
	 */
	private static final Logger LOGGER = LogManager.getLogger(GenericComponentResolver.class);

	/**
	 * Calls resolveKey in ContextKeyResolver and returns the Generic component element.
	 * 
	 * @param contexts
	 *            - Context object that contains various properties about this particular request
	 * @param Page
	 *            , Category, block - The input parameters to the CCDI service.
	 * @return Generic component element
	 */
	public GenericComponent resolveGenericComponent(Contexts contexts, String page, String category, String block)
	{

		GenericComponent genericComponent = null;
		List<ComponentElement> genericComponentsList = null;
		if (StringUtils.isNotBlank(page) && StringUtils.isNotBlank(category) && StringUtils.isNotBlank(block))
		{
			ComponentElement componentElement = createComponentType(page, category, block);
			CcdiRequest ccdiRequest = constructCcdiRequest(contexts, componentElement, Boolean.TRUE);
			CcdiResponse cdiResponse = getComponent(ccdiRequest);
			genericComponentsList = cdiResponse.getComponentElements();
			LOGGER.debug("(Page, Category, Block, BusinessContext)->(" + page + "," + category + "," + block + ","
					+ contexts.getBusinessContext() + ")");
		}

		if (genericComponentsList != null && !genericComponentsList.isEmpty())
		{
			genericComponent = (GenericComponent) genericComponentsList.get(0);
		}
		LOGGER.debug("GenericComponent=" + genericComponent);
		return genericComponent;
	}

	/**
	 * Creates Generic component object with the page, category, block passed
	 * 
	 * @return GenericComponent element
	 */
	@Override
	protected ComponentElement createComponentType(String... attributes)
	{
		GenericComponent genericComponent = new GenericComponent();
		genericComponent.setPage(attributes[0]);
		genericComponent.setCategory(attributes[1]);
		genericComponent.setBlock(attributes[2]);
		return genericComponent;
	}

}
