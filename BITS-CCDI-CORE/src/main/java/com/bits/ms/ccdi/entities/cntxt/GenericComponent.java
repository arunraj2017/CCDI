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
 * This class represents the generic content. The properties for generic content
 * are category, page and block. Inherits other properties from ComponentElement
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @version 1.0
 * 
 */
public class GenericComponent extends ComponentElement {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates generic content component type.
	 */
	public GenericComponent() {
		this.setComponentType(ComponentTypes.Generic_Component.value());
	}

	private String category;

	private String page;

	private String block;

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}

	/**
	 * @return the block
	 */
	public String getBlock() {
		return block;
	}

	/**
	 * @param block
	 *            the block to set
	 */
	public void setBlock(String block) {
		this.block = block;
	}

	/**
	 * Displays category, Page and block details of generic content.
	 */
	@Override
	public String toString() {

		return "Genric Component [Category=" + category + ", Page=" + page + ", Block=" + block + ", Text=" + this.getText() + "]";
	}

}
