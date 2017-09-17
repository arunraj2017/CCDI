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
package com.bits.ms.ccdi.entity.cntxt;

import java.util.Locale;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Encapsulates information about an user in the session
 * 
 * 
 * @author AB69987
 * @version 1.0
 */
public class UserContext extends BaseContext{

	private static final long serialVersionUID = 1L;
	private String userId; //webGuid
	private String relationshipCode; //memRelationship Code
	private Locale userLocale;
	private String userPreferences;
	private String userAction;
	private String userActionCategory;
	private String userActionLabel;
	private String entitlement;
	private String userType;
	private String userRole;
	private String userGroup;
	
	/**
	 * Default constructor.
	 */
	public UserContext() {
		super();
	  }


	/**
	 * Create user context.
	 */
	public UserContext(UserContext userContext) {
		if(null !=userContext){
		this.relationshipCode=userContext.getRelationshipCode();
		this.userAction=userContext.getUserAction();
		this.userActionCategory=userContext.getUserActionCategory();
		this.userActionLabel=userContext.getUserActionLabel();
		this.userId=userContext.getUserId();
		this.userLocale=userContext.getUserLocale();
		this.userPreferences=userContext.getUserPreferences();
		this.userType=userContext.getUserType();
		this.userRole=userContext.getUserRole();
		}
	}



	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}


	/**
	 * @return the relationshipCode
	 */
	public String getRelationshipCode() {
		return relationshipCode;
	}


	/**
	 * @param relationshipCode the relationshipCode to set
	 */
	public void setRelationshipCode(String relationshipCode) {
		this.relationshipCode = relationshipCode;
	}


	/**
	 * @return the userLocale
	 */
	public Locale getUserLocale() {
		return userLocale;
	}


	/**
	 * @param userLocale the userLocale to set
	 */
	public void setUserLocale(Locale userLocale) {
		this.userLocale = userLocale;
	}


	/**
	 * @return the userPreferences
	 */
	public String getUserPreferences() {
		return userPreferences;
	}


	/**
	 * @param userPreferences the userPreferences to set
	 */
	public void setUserPreferences(String userPreferences) {
		this.userPreferences = userPreferences;
	}


	/**
	 * @return the userAction
	 */
	public String getUserAction() {
		return userAction;
	}


	/**
	 * @param userAction the userAction to set
	 */
	public void setUserAction(String userAction) {
		this.userAction = userAction;
	}


	/**
	 * @return the userActionCategory
	 */
	public String getUserActionCategory() {
		return userActionCategory;
	}


	/**
	 * @param userActionCategory the userActionCategory to set
	 */
	public void setUserActionCategory(String userActionCategory) {
		this.userActionCategory = userActionCategory;
	}


	/**
	 * @return the userActionLabel
	 */
	public String getUserActionLabel() {
		return userActionLabel;
	}


	/**
	 * @param userActionLabel the userActionLabel to set
	 */
	public void setUserActionLabel(String userActionLabel) {
		this.userActionLabel = userActionLabel;
	}



	@Override
	public String toString() {
		
		return new ToStringBuilder(this)
		.append("UserPreferences", userPreferences)
		.append("UserLocale",userLocale)
		.append("userAction",userAction).toString();
	}


	/**
	 * @param entitlement the entitlement to set
	 */
	public void setEntitlement(String entitlement)
	{
		this.entitlement = entitlement;
	}


	/**
	 * @return the entitlement
	 */
	public String getEntitlement()
	{
		return entitlement;
	}


	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}


	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}


	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}


	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	/**
	 * @return the userGroup
	 */
	public String getUserGroup() {
		return userGroup;
	}


	/**
	 * @param userGroup the userGroup to set
	 */
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}
	
}
