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
package com.bits.ms.ccdi.entities.cms;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;

/**
 * This class represents a context. It maps the value CONTEXT table.
 * 
 * @author Cognizant
 * @version 1.0
 *
 */
public class Context implements Serializable {

	private static final long serialVersionUID = 1114837571444431358L;
	/**
	 * If one or more values are specified, the context applies only when the
	 * current user�s visual role matches one of the specified values. If left
	 * blank, the visual role is not used as a filter criteria to determine
	 * whether the content applies to the current user Visual roles equate to
	 * specific Wellpoint brands (and sub-brands).
	 */
	@NotNull
	private int id;
	@NotNull
	private Integer componentId;
	private String visualRole;
	private String state;
	private String county;
	private String city;
	private String planType;
	private String planYear;
	private String productCode;
	private String brand; // Used only in FAQ?
	private String language;
	private String site;
	private Date planEffectiveDate;
	private String lob;
	private String channel;
	private String vendor;
	private String userType;
	private String siteType;
	private String productFamily;
	private String providerPlan;
	private String providerSpeciality;
	private Date expiryDate;
	private String userRole;
	private String entitlement;
	
	/**
	 * @param id
	 */
	public Context(int id) {
		super();
		this.id = id;
	}

	/**
	 * Empty constructor
	 */
	public Context() {
		super();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param componentId the componentId to set
	 */
	public void setComponentId(Integer componentId) {
		this.componentId = componentId;
	}

	/**
	 * @return the componentId
	 */
	public Integer getComponentId() {
		return componentId;
	}

	/**
	 * @return the visualRole
	 */
	public String getVisualRole() {
		return visualRole;
	}

	/**
	 * @param visualRole the visualRole to set
	 */
	public void setVisualRole(String visualRole) {
		this.visualRole = visualRole;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the county
	 */
	public String getCounty() {
		return county;
	}

	/**
	 * @param county the county to set
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the planType
	 */
	public String getPlanType() {
		return planType;
	}

	/**
	 * @param planType the planType to set
	 */
	public void setPlanType(String planType) {
		this.planType = planType;
	}

	/**
	 * @return the planYear
	 */
	public String getPlanYear() {
		return planYear;
	}

	/**
	 * @param planYear the planYear to set
	 */
	public void setPlanYear(String planYear) {
		this.planYear = planYear;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the site
	 */
	public String getSite() {
		return site;
	}

	/**
	 * @param site the site to set
	 */
	public void setSite(String site) {
		this.site = site;
	}

	/**
	 * @return the planEffectiveDate
	 */
	public Date getPlanEffectiveDate() {
		return planEffectiveDate;
	}

	/**
	 * @param planEffectiveDate the planEffectiveDate to set
	 */
	public void setPlanEffectiveDate(Date planEffectiveDate) {
		this.planEffectiveDate = planEffectiveDate;
	}

	/**
	 * @return the lob
	 */
	public String getLob() {
		return lob;
	}

	/**
	 * @param lob the lob to set
	 */
	public void setLob(String lob) {
		this.lob = lob;
	}

	/**
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * @param channel the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/**
	 * @return the vendor
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
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
	 * @return the siteType
	 */
	public String getSiteType() {
		return siteType;
	}

	/**
	 * @param siteType the siteType to set
	 */
	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	/**
	 * @return the productFamily
	 */
	public String getProductFamily() {
		return productFamily;
	}

	/**
	 * @param productFamily the productFamily to set
	 */
	public void setProductFamily(String productFamily) {
		this.productFamily = productFamily;
	}

	/**
	 * @return the providerPlan
	 */
	public String getProviderPlan() {
		return providerPlan;
	}

	/**
	 * @param providerPlan the providerPlan to set
	 */
	public void setProviderPlan(String providerPlan) {
		this.providerPlan = providerPlan;
	}

	/**
	 * @return the providerSpeciality
	 */
	public String getProviderSpeciality() {
		return providerSpeciality;
	}

	/**
	 * @param providerSpeciality the providerSpeciality to set
	 */
	public void setProviderSpeciality(String providerSpeciality) {
		this.providerSpeciality = providerSpeciality;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
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
	 * @return the entitlement
	 */
	public String getEntitlement() {
		return entitlement;
	}

	/**
	 * @param entitlement the entitlement to set
	 */
	public void setEntitlement(String entitlement) {
		this.entitlement = entitlement;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Context [Id=" + this.id
			 + ", componentId=" + componentId
			 + ", visualRole=" + (StringUtils.isEmpty(visualRole) ? " " : visualRole)
			 + ", state=" + (StringUtils.isEmpty(state) ? " " : state)
			 + ", county=" + (StringUtils.isEmpty(county) ? " " : county)
			 + ", city=" + (StringUtils.isEmpty(city) ? " " : city)
			 + ", planType=" + (StringUtils.isEmpty(planType) ? " " : planType)
			 + ", planYear=" + (StringUtils.isEmpty(planYear) ? " " : planYear)
			 + ", productCode=" + (StringUtils.isEmpty(productCode) ? " " : productCode)
			 + ", brand=" + (StringUtils.isEmpty(brand) ? " " : brand)
			 + ", language=" + (StringUtils.isEmpty(language) ? " " : language)
			 + ", site=" + (StringUtils.isEmpty(site) ? " " : site)
			 + ", planEffectiveDate=" + ((planEffectiveDate==null) ? " " : planEffectiveDate)
//			 + ", planEffectiveDate=" + (StringUtils.isEmpty(planEffectiveDate.toString()) ? " " : planEffectiveDate)
			 + ", lob="	+ (StringUtils.isEmpty(lob) ? " " : lob)
			 + ", channel=" + (StringUtils.isEmpty(channel) ? " " : channel)
			 + ", vendor=" + (StringUtils.isEmpty(vendor) ? " " : vendor)
			 + ", userType=" + (StringUtils.isEmpty(userType) ? " " : userType)
			 + ", siteType=" + (StringUtils.isEmpty(siteType) ? " " : siteType)
			 + ", productFamily=" + (StringUtils.isEmpty(productFamily) ? " " : productFamily)
			 + ", providerPlan=" + (StringUtils.isEmpty(providerPlan) ? " " : providerPlan)
			 + ", providerSpeciality=" + (StringUtils.isEmpty(providerSpeciality) ? " " : providerSpeciality)
 			 + ", expiryDate=" + ((expiryDate==null)? " " : expiryDate)
//			 + ", expiryDate=" + (StringUtils.isEmpty(expiryDate.toString()) ? " " : expiryDate)
			 + ", userRole=" + (StringUtils.isEmpty(userRole) ? " " : userRole)
			 + ", entitlement=" + (StringUtils.isEmpty(entitlement) ? " " : entitlement) + "]";
	}
}
