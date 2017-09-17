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
package com.bits.ms.ccdi.entities.cntxt;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * This class holds the name and value of a property content. Inherits other properties from ComponentElement.
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @version 1.0
 *
 */
public class Property extends ComponentElement implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;

	/**
	 * The name of the property
	 */
	private String name;
	/**
	 * The value of the property
	 */
	private String value;

	/**
	 * Creates Property component type.
	 */
	public Property() {
		this.setComponentType(ComponentTypes.Property_Component.value());
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the value
	 */
	public String getValue() {
		return this.getText();
	}


	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}


	/**
	 * This method gets called when a bound property is changed.
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("text")) {
			this.value = (String) getText();
		}
	}

	/**
	 * Displays name and value of a property.
	 */
	@Override
	public String toString() {

		return "Property [name=" + this.getName() +", value=" + this.getValue() + ", text=" + this.getText() +"]";
	}
}
