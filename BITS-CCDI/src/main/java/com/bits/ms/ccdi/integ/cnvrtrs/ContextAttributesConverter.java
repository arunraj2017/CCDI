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
package com.bits.ms.ccdi.integ.cnvrtrs;

import java.util.ArrayList;
import java.util.List;

import org.dozer.ConfigurableCustomConverter;
import org.springframework.stereotype.Component;

import com.bits.ms.ccdi.entities.cms.ComponentAttribute;

/**
 * A Custom converter used in Dozer mapping to create the Component Attribute
 * Every Component record is identified by one or more component Attributes
 * which is passed to the CCDI service as input
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @author Cognizant - Modified for E3
 * @version 1.0
 */
@Component
public class ContextAttributesConverter implements ConfigurableCustomConverter {

	/***
	 * Instance variable to determine the component type and its corresponding
	 * input
	 */
	private String parameter;

	/**
	 * Converts specific component requests to create component Attribute
	 * 
	 * @param destination
	 *            the destination object.
	 * @param source
	 *            the source object.
	 * @param destinationClass
	 *            the destination class.
	 * @param sourceClass
	 *            the source class.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object convert(Object destination, Object source,
			Class<?> destinationClass, Class<?> sourceClass) {
		String value = null;
		// check if source is null
		if (source instanceof List) {
			List<ComponentAttribute> attributes = (List<ComponentAttribute>) source;
			for (ComponentAttribute componentAttribute : attributes) {
				String name = componentAttribute.getAttributeName();
				if (name.equals(getParameter())) {
					value = componentAttribute.getAttributeValue();
					break;
				}
			}
			return value;
		} else if (source instanceof String) {
			ArrayList<ComponentAttribute> attributes = null;
			if (destination == null) {
				attributes = new ArrayList<ComponentAttribute>();
			} else {
				attributes = (ArrayList<ComponentAttribute>) destination;
			}
			ComponentAttribute attribute = new ComponentAttribute();
			attribute.setAttributeName(getParameter());
			attribute.setAttributeValue((String) source);
			attributes.add(attribute);
			return attributes;
		}

		return null;
	}

	/**
	 * This method will get parameter
	 * 
	 * @return the parameter
	 */
	public String getParameter() {
		return parameter;
	}

	/**
	 * This method will set parameter.
	 * 
	 * @param parameter
	 *            the parameter to set
	 */
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

}