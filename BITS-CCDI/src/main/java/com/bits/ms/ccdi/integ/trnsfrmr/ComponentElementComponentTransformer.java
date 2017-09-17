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
package com.bits.ms.ccdi.integ.trnsfrmr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bits.ms.ccdi.entities.cntxt.ComponentElement;
import com.bits.ms.ccdi.entities.cntxt.ComponentTypes;
import com.bits.ms.ccdi.entities.cntxt.EnvironmentEntry;
import com.bits.ms.ccdi.entities.cntxt.Gateway;
import com.bits.ms.ccdi.entities.cntxt.GenericComponent;
import com.bits.ms.ccdi.entities.cntxt.GlossaryComponent;
import com.bits.ms.ccdi.entities.cntxt.Property;
import com.bits.ms.ccdi.entities.cntxt.Validator;
import com.bits.ms.ccdi.entities.cntxt.Verbiage;

/**
 * Provide a standard way to convert ComponentElement to Component and
 * vice-versa
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @author Cognizant - Modified for E3
 * @version 1.0
 */
@Component
public class ComponentElementComponentTransformer {

	private static final Logger LOG = LogManager
			.getLogger(ComponentElementComponentTransformer.class);

	@Qualifier("dozer.mapper.ccdiapi")
	@Autowired
	/**
	 * The Dozer Mapper instance
	 */
	private Mapper mapper;

	/**
	 * Converts the component element object to component object
	 * 
	 * @param componentElement
	 *            The component element which needs to be converted as Component
	 * @return Component object
	 */
	public com.bits.ms.ccdi.entities.cms.Component convertComponentElementToComponent(
			ComponentElement componentElement) {
		com.bits.ms.ccdi.entities.cms.Component component = mapper.map(
				componentElement,
				com.bits.ms.ccdi.entities.cms.Component.class);
		return component;
	}

	/**
	 * Converts the component object to component element object based on the
	 * component type
	 * 
	 * @param component
	 *            The component which needs to be converted as Component element
	 * @return Component element object
	 */
	public ComponentElement convertComponentToComponentElement(
			com.bits.ms.ccdi.entities.cms.Component component) {
		try {
			if (component.getComponentType().getComponentTypeCode()
					.equals(ComponentTypes.Generic_Component.value())) {
				return mapper.map(component, GenericComponent.class);
			} else if (component.getComponentType().getComponentTypeCode()
					.equals(ComponentTypes.Property_Component.value())) {
				return mapper.map(component, Property.class);
			} else if (component.getComponentType().getComponentTypeCode()
					.equals(ComponentTypes.Gateway_Component.value())) {
				return mapper.map(component, Gateway.class);
			} else if (component.getComponentType().getComponentTypeCode()
					.equals(ComponentTypes.Verbiage_Component.value())) {
				return mapper.map(component, Verbiage.class);
			} else if (component.getComponentType().getComponentTypeCode()
					.equals(ComponentTypes.EnvironmentEntry_Component.value())) {
				return mapper.map(component, EnvironmentEntry.class);
			} else if (component.getComponentType().getComponentTypeCode()
					.equals(ComponentTypes.Validator_Component.value())) {
				return mapper.map(component, Validator.class);
			} else if (component.getComponentType().getComponentTypeCode()
					.equals(ComponentTypes.Glossary_Component.value())) {
				return mapper.map(component, GlossaryComponent.class);
			} else {
				return null;
			}
		}

		catch (Exception ex) {
			LOG.error("Error in ComponentElementComponentTransformer-convertComponentToComponentElement() :: "
					+ ex);
		}
		return null;
	}
}
