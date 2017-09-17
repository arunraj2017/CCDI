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

import java.util.Date;

/**
 * Entity is the core model class from which all entities extend their base characteristics.
 *    
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @version 1.0
 */
public class Entity{

	private static final long serialVersionUID = 1L;

	private String id;

	private String createdUser;

	private Date createdDateTime;

	private String updatedUser;

	private Date updatedDateTime;

	private boolean mutable;

	private String dataState;

	private Date updatedOn;

	private Date updatedBy;

	private Date createdOn;

	private Date createdBy;
	
	private String errorCode;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the createdUser
	 */
	public String getCreatedUser() {
		return createdUser;
	}

	/**
	 * @param createdUser the createdUser to set
	 */
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	/**
	 * @return the createdDateTime
	 */
	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	/**
	 * @param createdDateTime the createdDateTime to set
	 */
	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	/**
	 * @return the updatedUser
	 */
	public String getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * @param updatedUser the updatedUser to set
	 */
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
	 * @return the updatedDateTime
	 */
	public Date getUpdatedDateTime() {
		return updatedDateTime;
	}

	/**
	 * @param updatedDateTime the updatedDateTime to set
	 */
	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	/**
	 * @return the mutable
	 */
	public boolean isMutable() {
		return mutable;
	}

	/**
	 * @param mutable the mutable to set
	 */
	public void setMutable(boolean mutable) {
		this.mutable = mutable;
	}

	/**
	 * @return the dataState
	 */
	public String getDataState() {
		return dataState;
	}

	/**
	 * @param dataState the dataState to set
	 */
	public void setDataState(String dataState) {
		this.dataState = dataState;
	}

	/**
	 * @return the updatedOn
	 */
	public Date getUpdatedOn() {
		return updatedOn;
	}

	/**
	 * @param updatedOn the updatedOn to set
	 */
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * @return the updatedBy
	 */
	public Date getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(Date updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the createdBy
	 */
	public Date getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Date createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Displays creation and updated details of an entity.
	 */
	@Override
	public String toString() {
		return "Entity [id=" + id + ", createdUser=" + createdUser
				+ ", createdDateTime=" + createdDateTime + ", updatedUser="
				+ updatedUser + ", updatedDateTime=" + updatedDateTime
				+ ", mutable=" + mutable + ", dataState=" + dataState
				+ ", updatedOn=" + updatedOn + ", updatedBy=" + updatedBy
				+ ", createdOn=" + createdOn + ", createdBy=" + createdBy
				+ ", errorCode=" + errorCode + "]";
	}

	
}
