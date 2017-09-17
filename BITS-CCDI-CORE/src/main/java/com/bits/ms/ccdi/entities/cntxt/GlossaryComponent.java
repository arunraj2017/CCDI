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


/**
 * This class holds the glossary term for glossary content. Inherits other properties from ComponentElement
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @version 1.0
 *
 */
public class GlossaryComponent extends ComponentElement {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates Glossary content component element. 
	 */
	public GlossaryComponent() {
		this.setComponentType(ComponentTypes.Glossary_Component.value());
	}
	
	/**
	 * The term for which the glossary description needs to be retrieved
	 */
	private String glossaryTerm;

	
	/**
	 * @return the glossaryTerm
	 */
	public String getGlossaryTerm() {
		return glossaryTerm;
	}


	/**
	 * @param glossaryTerm the glossaryTerm to set
	 */
	public void setGlossaryTerm(String glossaryTerm) {
		this.glossaryTerm = glossaryTerm;
	}


	/**
	 * Displays glossary term 
	 */
	@Override
	public String toString() {
		
		return "Glossary [Term=" + glossaryTerm + ", Text=" + this.getText() + "]";

	}
	
	
}
