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
 * This class holds the action and value of a Validator content. Inherits other properties from ComponentElement.
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @version 1.0
 *
 */
public class Validator extends ComponentElement implements PropertyChangeListener {


	private static final long serialVersionUID = 1L;

	/**
	 * Creates Validator component type.
	 */
	public Validator() {
		this.setComponentType(ComponentTypes.Validator_Component.value());
	}
	/**
	 * Action name for which the validator rule set has to be found
	 */
	private String action;

	/**
	 * Validation Rules for the given action
	 */
	private String value;


	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}


	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
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
	 * Displays action and value of Validator.
	 */
	@Override
	public String toString() {
		return "Validator [action=" + action + ", value=" + value + "]";
	}
	
	
}
