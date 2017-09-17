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
 * This class represents types of Component. It maps the value from CMPNT_TYPE table.
 * 
 * @author Cognizant
 * @version 1.0
 * 
 */
public class ComponentType implements Serializable
{
	private static final long serialVersionUID = -1012689435774538131L;
	@NotNull
	private String componentTypeCode;
	private String codeValue;

	public ComponentType()
	{
		super();
	}
	public ComponentType(String componentTypeCode) {
		super();
		this.componentTypeCode = componentTypeCode;
	}

	/**
	 * @return the componentTypeCode
	 */
	public String getComponentTypeCode() {
		return componentTypeCode;
	}

	/**
	 * @param componentTypeCode the componentTypeCode to set
	 */
	public void setComponentTypeCode(String componentTypeCode) {
		this.componentTypeCode = componentTypeCode;
	}

	/**
	 * @return the codeValue
	 */
	public String getCodeValue() {
		return codeValue;
	}

	/**
	 * @param codeValue the codeValue to set
	 */
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	/**
	 * Returns a hash code value for the object.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((componentTypeCode == null) ? 0 : componentTypeCode.hashCode());
		result = prime * result + ((codeValue == null) ? 0 : codeValue.hashCode());
		return result;
	}
	
	/**
	 * Indicates whether some other object is "equal to" this one. 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComponentType other = (ComponentType) obj;
		if (componentTypeCode == null) {
			if (other.componentTypeCode != null)
				return false;
		} else if (!componentTypeCode.equals(other.componentTypeCode))
			return false;
		if (codeValue == null) {
			if (other.codeValue != null)
				return false;
		} else if (!codeValue.equals(other.codeValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ComponentType [componentTypeCode=" + componentTypeCode
				+ ", codeValue=" + (StringUtils.isEmpty(codeValue)?" ": codeValue) + "]";
	}


}
