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
 * This class holds the environment key value pair and inherits other properties from ComponentElement
 *
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @version 1.0
 *
 */
public class EnvironmentEntry extends ComponentElement implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	
	/**
	 * The key to get the corresponding Environment related value
	 */
	private String key;
	/**
	 * Environment specific value for the given key
	 */
	private String value;

	/**
	 * Creates environment component element.
	 */
	public EnvironmentEntry() {
		this.setComponentType(ComponentTypes.EnvironmentEntry_Component.value());
	}

	
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}


	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
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
			this.value = (String) evt.getNewValue();
		}
	}


	/**
	 * Displays key and value pair.
	 */
	@Override
	public String toString() {
		return "EnvironmentEntry [key=" + key + ", value=" + value + "]";
	}

	
}
