/*
 * Application: E3
 * 
 * -------------------------------
 * Copyright (c) WellPoint, Inc
 * -------------------------------
 * This software is the confidential and proprietary information of WellPoint, Inc. ("Confidential Information").
 * You shall not disclose such confidential information, and shall use it only in accordance with the terms of the 
 * license agreement you entered into with WellPoint.
 */
package com.bits.ms.ccdi.entities.cms;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;

/**
 * This class represents the attributes of a Component. It maps the value from
 * COMPONENT_ATTRIBUTES table.
 * 
 * @author Cognizant
 * @version 1.0
 * 
 */
public class ComponentAttribute implements Serializable {


	private static final long serialVersionUID = 8600010983943286627L;
	@NotNull
	private Integer attributeId;
	@NotNull
	private Integer componentId;
	private String attributeName;
	private String attributeValue;

	
	/**
	 * @return the attributeId
	 */
	public Integer getAttributeId() {
		return attributeId;
	}

	/**
	 * @param attributeId the attributeId to set
	 */
	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}

	/**
	 * @return the componentId
	 */
	public Integer getComponentId() {
		return componentId;
	}

	/**
	 * @param componentId the componentId to set
	 */
	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
	}

	/**
	 * @return the attributeName
	 */
	public String getAttributeName() {
		return attributeName;
	}

	/**
	 * @param attributeName the attributeName to set
	 */
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	/**
	 * @return the attributeValue
	 */
	public String getAttributeValue() {
		return attributeValue;
	}

	/**
	 * @param attributeValue the attributeValue to set
	 */
	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	@Override
	public String toString() {
		return "ComponentAttribute [attributeId=" + attributeId
				+ ", componentId=" + componentId 
				+ ", attributeName=" + (StringUtils.isEmpty(attributeName)?" " :attributeName)  
				+ ", attributeValue=" + (StringUtils.isEmpty(attributeValue) ? " " : attributeValue)
				+ "]";
	}
	


	
}
