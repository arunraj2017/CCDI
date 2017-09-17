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
 * This class holds the gateway action and name. Inherits other properties from ComponentElement
 *
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @version 1.0
 *
 */
public class Gateway extends ComponentElement implements PropertyChangeListener{

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Creates Gateway component element.
	 */
	public Gateway() {
 		this.setComponentType(ComponentTypes.Gateway_Component.value());
	}

	/**
	 * Action name for which the Gateway name has to be found
	 */
	private String action;
	
	/**
	 * Gateway name 
	 */
	private String name;

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
	 * @return the name
	 */
	public String getName() {
		return this.getText();
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * This method gets called when a bound property is changed.
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("text")) {
			this.name = (String)evt.getNewValue();
		}
	}

	/**
	 * Displays gateway name and action.
	 */
	@Override
	public String toString() {
		return "Gateway [action=" + action + ", name=" + this.getName() + ", text=" + this.getText() +"]";
	}
	
	
}
