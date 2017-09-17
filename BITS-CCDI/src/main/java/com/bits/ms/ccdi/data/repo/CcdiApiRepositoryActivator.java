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
package com.bits.ms.ccdi.data.repo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;

import com.bits.ms.ccdi.api.constants.CcdiApiConstants;
import com.bits.ms.ccdi.api.io.CcdiRequest;
import com.bits.ms.ccdi.api.io.CcdiResponse;
import com.bits.ms.ccdi.entities.cms.Component;
import com.bits.ms.ccdi.entities.cntxt.ComponentElement;
import com.bits.ms.ccdi.entities.cntxt.WildcardTypeEnum;
import com.bits.ms.ccdi.integ.trnsfrmr.ComponentElementComponentTransformer;

/**
 * Repository activator class to retrieve the content from repository based on
 * the content type
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @author Cognizant - Modified for E3
 * @version 1.0
 */
@MessageEndpoint
public class CcdiApiRepositoryActivator {

	 @Autowired
	 /**
	 * CcdiApiRepository instance uses CcdiSelectorDao to get the list of
	 * Generic or Glossary content from content repository
	 */
	 private CcdiApiRepository ccdiApiRepository;
	 
	 /**
	 * ComponentApiRepository instance uses ComponentSelectorDao to get the
	 * list of content from repository based on the component type
	 */
	@Autowired
	private ComponentApiRepository componentApiRepository;

	/**
	 * * CcdiApiWildcardRepository instance uses CcdiWildcardSelectorDao to get
	 * the list of glossary content from repository
	 */
	
	@Autowired
	private CcdiApiWildcardRepository ccdiApiWildcardRepository;

	@Autowired
	/**
	 * Transformer instance to convert ComponentElement to Component and vice-versa
	 */
	private ComponentElementComponentTransformer transformer;

	/**
	 * This method will get component.
	 * 
	 * @param ccdiRequest
	 *            ccdi request object
	 * @return content which is a ccdi response
	 * @throws SQLException
	 */
	public CcdiResponse getComponent(CcdiRequest ccdiRequest) throws com.bits.ms.ccdi.exception.DataAccessException {
		List<Component > components = null;
		Component component = convertComponentElementToComponent(ccdiRequest); // transform
		if ((CcdiApiConstants.COMPONENT_TYPE_PROPERTY.equalsIgnoreCase(component
				.getComponentType().getComponentTypeCode()))
				|| (CcdiApiConstants.COMPONENT_TYPE_GATEWAY
						.equalsIgnoreCase(component.getComponentType().getComponentTypeCode()))
				|| (CcdiApiConstants.COMPONENT_TYPE_VERBIAGE
						.equalsIgnoreCase(component.getComponentType().getComponentTypeCode()))
				|| (CcdiApiConstants.COMPONENT_TYPE_ENV.equalsIgnoreCase(component
						.getComponentType().getComponentTypeCode()))
				|| (CcdiApiConstants.COMPONENT_TYPE_VALIDATOR
						.equalsIgnoreCase(component.getComponentType().getComponentTypeCode()))) {
			components = componentApiRepository.getComponentData(component);

		}
		else if (null == ccdiRequest.getWildcardType() || WildcardTypeEnum.NONE.equals(ccdiRequest.getWildcardType()))
		{
			components = ccdiApiRepository.getComponentData(component);
		}
		else
		{
			components = ccdiApiWildcardRepository.getComponentData(component, ccdiRequest.getWildcardType());
		}
		List<ComponentElement> componentElements = convertCmpentListToCmpnetElementList(components);// transform
																								// back
		CcdiResponse ccdiResponse = new CcdiResponse();
		ccdiResponse.setComponentElements(componentElements);
		ccdiResponse.setCcdiRequest(ccdiRequest);
		return ccdiResponse;
	}

	/**
	 * Iterates through the list of components and convert it to component
	 * elements
	 * 
	 * @param components
	 *            List of components fetched from repository
	 * @return List of component elements
	 */
	private List<ComponentElement> convertCmpentListToCmpnetElementList(
			List<Component> components) {

		List<ComponentElement> componentElements = new ArrayList<ComponentElement>();
		if (components != null) {
			for (Component component : components) {
				componentElements.add(transformer
						.convertComponentToComponentElement(component));
			}
		}
		return componentElements;
	}

	/**
	 * Converts the component element to component
	 * 
	 * @param ccdiRequest
	 *            ccdi request object
	 * @return Component object
	 */
	private Component convertComponentElementToComponent(CcdiRequest ccdiRequest) {

		return transformer.convertComponentElementToComponent(ccdiRequest
				.getComponentElement());
	}

	
}
