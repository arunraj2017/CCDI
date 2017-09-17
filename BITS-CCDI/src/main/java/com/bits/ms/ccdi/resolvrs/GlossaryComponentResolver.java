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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.bits.ms.ccdi.api.io.CcdiRequest;
import com.bits.ms.ccdi.api.io.CcdiResponse;
import com.bits.ms.ccdi.entities.cntxt.ComponentElement;
import com.bits.ms.ccdi.entities.cntxt.GlossaryComponent;
import com.bits.ms.ccdi.entities.cntxt.WildcardTypeEnum;
import com.bits.ms.ccdi.entity.cntxt.Contexts;

/**
 * This class retrieves the Glossary component element for a given term. Along
 * with the term, Other context information such as brand, state etc will also
 * be used while retrieving the content. If there are more than one record found
 * for the given request, the records will be scored and filtered based on the
 * context information requested
 * 
 * @author Cognizant
 * @version 1.0
 * @see ComponentKeyResolver
 */
@Component
public class GlossaryComponentResolver extends ComponentKeyResolver {

	/**
	 * For logging
	 */
	private static final Logger LOGGER = LogManager
			.getLogger(GlossaryComponentResolver.class);

	/**
	 * Calls resolveKey in ContextKeyResolver and returns the Glossary component
	 * element.
	 * 
	 * @param contexts
	 *            - Context object that contains various properties about this
	 *            particular request
	 * @param term
	 *            - The input parameter to the CCDI service. For Glossary
	 *            Component type the term value present in the
	 *            ComponentAttribute table is the input.
	 * @return Glossary component element
	 */
	public GlossaryComponent resolveGlossaryComponent(Contexts contexts,
			String term) {
		LOGGER.debug("(Term,BusinessContext)->(" + term + ","
				+ contexts.getBusinessContext() + ")");
		GlossaryComponent glossaryComponent = (GlossaryComponent) resolveKey(contexts, term, Boolean.TRUE);
		LOGGER.debug("GlossaryComponent=" + glossaryComponent);
		return glossaryComponent;
	}
	 
	/**
	 * Get the list glossary Component from the CCDI for the given term
	 * 
	 * @param contexts
	 *            - Context object that contains various properties about this
	 *            particular request
	 * @param term
	 *            - The input parameter to the CCDI service. *
	 * 
	 * @return Component Element containing the response content for the given
	 *         request
	 */
	protected List<ComponentElement> resolveWildCardGlossaryComponent(Contexts contexts,
			String term) {
		LOGGER.debug("(Term,BusinessContext)->(" + term + ","
				+ contexts.getBusinessContext() + ")");
		ComponentElement componentElement = createComponentType(term);
		CcdiRequest ccdiRequest = constructCcdiRequest(contexts, componentElement, Boolean.TRUE);
		ccdiRequest.setWildcardType(WildcardTypeEnum.TERM_START_WITH);
		CcdiResponse cdiResponse = getComponent(ccdiRequest);
		List<ComponentElement> glossaryComponents = cdiResponse
				.getComponentElements();
		LOGGER.debug("GlossaryComponents=" + glossaryComponents);
		return glossaryComponents;

	}
	
	/**
	 * Creates GlossaryComponent object with the key name passed
	 * 
	 * @param key
	 *            - The input parameter to the CCDI service. For Environment
	 *            Component type the key value present in the ComponentAttribute
	 *            table is the input.
	 * @return Environment Entry component element
	 */
	@Override
	protected ComponentElement createComponentType(String... attributes) {
		GlossaryComponent glossaryComponent = new GlossaryComponent();
		glossaryComponent.setGlossaryTerm(attributes[0]);
		return glossaryComponent;
	}

}
