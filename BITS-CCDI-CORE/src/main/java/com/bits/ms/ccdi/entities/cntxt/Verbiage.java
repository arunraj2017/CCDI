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
 * This class holds the key and text of a Verbiage content. Inherits other properties from ComponentElement.
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @version 1.0
 *
 */
public class Verbiage extends ComponentElement implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates Verbiage component element.
	 */
	public Verbiage() {
		this.setComponentType(ComponentTypes.Verbiage_Component.value());
	}

	/**
	 * The key to get the corresponding Verbiage text
	 */
	private String key;
	
	/**
	 * The Verbiage text
	 */
	private String text;



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
	 * This method gets called when a bound property is changed.
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("text")) {
			this.text = (String) evt.getNewValue();
		}
	}
	
	/**
	 * Displays key text pair for verbiage component element type.
	 */
	@Override
	public String toString() {
		
		return "Verbiage [Key=" + key + ", Text=" + text + "]";
	}
	
}
