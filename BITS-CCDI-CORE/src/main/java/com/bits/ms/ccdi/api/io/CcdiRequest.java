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

package com.bits.ms.ccdi.api.io;

import java.io.Serializable;

import com.bits.ms.ccdi.api.core.io.BaseAbstractRequest;
import com.bits.ms.ccdi.entities.cntxt.CcdiAdminOperationTypeEnum;
import com.bits.ms.ccdi.entities.cntxt.ComponentElement;
import com.bits.ms.ccdi.entities.cntxt.WildcardTypeEnum;

/**
 * This class represents Ccdi Request object which has component element. Inherits other properties from BaseRequest.
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @version 1.0
 *
 */
public class CcdiRequest extends BaseAbstractRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * The Request Component
	 */
	private ComponentElement componentElement;
	/**
	 * To specify the Wild card - used for glossary content
	 */
	private WildcardTypeEnum wildcardType;
	
	/**
	 * To Specify CCDI Admin operation type.
	 * 
	 */
	private CcdiAdminOperationTypeEnum ccdiAdminOperationType;
	
	/**
	 * To specify cache check indicator - used to resolve key.
	 */
	private Boolean checkCache;
	
	/**
	 * @return the componentElement
	 */
	public ComponentElement getComponentElement() {
		return componentElement;
	}
	/**
	 * @param componentElement the componentElement to set
	 */
	public void setComponentElement(ComponentElement componentElement) {
		this.componentElement = componentElement;
	}
	/**
	 * @return the wildcardType
	 */
	public WildcardTypeEnum getWildcardType() {
		return wildcardType;
	}
	/**
	 * @param wildcardType the wildcardType to set
	 */
	public void setWildcardType(WildcardTypeEnum wildcardType) {
		this.wildcardType = wildcardType;
	}
	
	/**
	 * @return the ccdiAdminOperationType
	 */
	public CcdiAdminOperationTypeEnum getCcdiAdminOperationType() {
		return ccdiAdminOperationType;
	}
	/**
	 * @param ccdiAdminOperationType the ccdiAdminOperationType to set
	 */
	public void setCcdiAdminOperationType(
			CcdiAdminOperationTypeEnum ccdiAdminOperationType) {
		this.ccdiAdminOperationType = ccdiAdminOperationType;
	}
	/**
	 * @param checkCache the checkCache to set
	 */
	public void setCheckCache(Boolean checkCache)
	{
		this.checkCache = checkCache;
	}
	/**
	 * @return the checkCache
	 */
	public Boolean getCheckCache()
	{
		return checkCache;
	}
	/**
	 * Displays component element and wildcard type of CCDI Request.
	 */
	@Override
	public String toString() {
		return "CcdiRequest [componentElement=" + componentElement
		+ ", wildcardType=" + wildcardType + ", checkCache=" + checkCache+"]";
	}

	
}
