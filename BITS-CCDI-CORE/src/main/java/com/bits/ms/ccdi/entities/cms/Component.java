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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;


/**
 * This class represents a Component. It maps the value from COMPONENT table.
 * 
 * @author Cognizant
 * @version 1.0
 *
 */
public class Component implements Serializable
{
	private static final long serialVersionUID = -1582522342507280496L;
	@NotNull
	private Integer id;
	private String cmsId;
	private String titleText;
	@NotNull
	private ComponentType componentType;
	private String group;
	private String error; 
	private String revision;
	private String source;
	private String componentText;
	private String cmsStatus;// This element is to know whether the content is expired are active.
	private String cdiStatus;// This element is to know whether the content is expired are active.
	private Date publishedDate;
	@NotNull
	private Date createdDate; //database insert date
	@NotNull
	private Date updatedDate; //database update date
	@NotNull
	private String createdUser;
	@NotNull
	private String updatedUser;	
	private String updatedDateFrom;
	private String updatedDateTo;
	private String publishDateFrom;
	private String publishDateTo;
	private String expryDateForSearch;	
	private String plnEffctvDateForSearch;
	private List<Context> contexts = new ArrayList<Context>();
	private List<ComponentAttribute> attributes = new ArrayList<ComponentAttribute>();

	

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the cmsId
	 */
	public String getCmsId() {
		return cmsId;
	}

	/**
	 * @param cmsId the cmsId to set
	 */
	public void setCmsId(String cmsId) {
		this.cmsId = cmsId;
	}

	/**
	 * @return the titleText
	 */
	public String getTitleText() {
		return titleText;
	}

	/**
	 * @param titleText the titleText to set
	 */
	public void setTitleText(String titleText) {
		this.titleText = titleText;
	}

	/**
	 * @param componentType the componentType to set
	 */
	public void setComponentType(ComponentType componentType) {
		this.componentType = componentType;
	}

	/**
	 * @return the componentType
	 */
	public ComponentType getComponentType() {
		return componentType;
	}

	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}

	/**
	 * @return the revision
	 */
	public String getRevision() {
		return revision;
	}

	/**
	 * @param revision the revision to set
	 */
	public void setRevision(String revision) {
		this.revision = revision;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the componentText
	 */
	public String getComponentText() {
		return componentText;
	}

	/**
	 * @param componentText the componentText to set
	 */
	public void setComponentText(String componentText) {
		this.componentText = componentText;
	}

	/**
	 * @return the cmsStatus
	 */
	public String getCmsStatus() {
		return cmsStatus;
	}

	/**
	 * @param cmsStatus the cmsStatus to set
	 */
	public void setCmsStatus(String cmsStatus) {
		this.cmsStatus = cmsStatus;
	}

	/**
	 * @return the cdiStatus
	 */
	public String getCdiStatus() {
		return cdiStatus;
	}

	/**
	 * @param cdiStatus the cdiStatus to set
	 */
	public void setCdiStatus(String cdiStatus) {
		this.cdiStatus = cdiStatus;
	}

	/**
	 * @return the publishedDate
	 */
	public Date getPublishedDate() {
		return publishedDate;
	}

	/**
	 * @param publishedDate the publishedDate to set
	 */
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
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
	 * @return the contexts
	 */
	public List<Context> getContexts() {
		return contexts;
	}

	/**
	 * @param contexts the contexts to set
	 */
	public void setContexts(List<Context> contexts) {
		this.contexts = contexts;
	}

	/**
	 * @return the attributes
	 */
	public List<ComponentAttribute> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(List<ComponentAttribute> attributes) {
		this.attributes = attributes;
	}

	

	/**
	 * @return the updatedDateFrom
	 */
	public String getUpdatedDateFrom() {
		return updatedDateFrom;
	}

	/**
	 * @param updatedDateFrom the updatedDateFrom to set
	 */
	public void setUpdatedDateFrom(String updatedDateFrom) {
		this.updatedDateFrom = updatedDateFrom;
	}

	/**
	 * @return the updatedDateTo
	 */
	public String getUpdatedDateTo() {
		return updatedDateTo;
	}

	/**
	 * @param updatedDateTo the updatedDateTo to set
	 */
	public void setUpdatedDateTo(String updatedDateTo) {
		this.updatedDateTo = updatedDateTo;
	}

	/**
	 * @return the publishDateFrom
	 */
	public String getPublishDateFrom() {
		return publishDateFrom;
	}

	/**
	 * @param publishDateFrom the publishDateFrom to set
	 */
	public void setPublishDateFrom(String publishDateFrom) {
		this.publishDateFrom = publishDateFrom;
	}

	/**
	 * @return the publishDateTo
	 */
	public String getPublishDateTo() {
		return publishDateTo;
	}

	/**
	 * @param publishDateTo the publishDateTo to set
	 */
	public void setPublishDateTo(String publishDateTo) {
		this.publishDateTo = publishDateTo;
	}

	/**
	 * @return the expryDateForSearch
	 */
	public String getExpryDateForSearch() {
		return expryDateForSearch;
	}

	/**
	 * @param expryDateForSearch the expryDateForSearch to set
	 */
	public void setExpryDateForSearch(String expryDateForSearch) {
		this.expryDateForSearch = expryDateForSearch;
	}

	/**
	 * @return the plnEffctvDateForSearch
	 */
	public String getPlnEffctvDateForSearch() {
		return plnEffctvDateForSearch;
	}

	/**
	 * @param plnEffctvDateForSearch the plnEffctvDateForSearch to set
	 */
	public void setPlnEffctvDateForSearch(String plnEffctvDateForSearch) {
		this.plnEffctvDateForSearch = plnEffctvDateForSearch;
	}

	/**
	 * Returns a hash code value for the object.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * Indicates whether some other object is "equal to" this one. 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Component other = (Component) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Component [id=" + id + ", cmsId=" + cmsId + ", title=" + titleText
				+ ", componentType=" + componentType + ", group=" + group
				+ ", error=" + error + ", revision="
				+ revision + ", source=" + source + ", componentText=" + componentText
				+ ", cmsStatus=" + cmsStatus + ", cdiStatus=" + cdiStatus
				+ ", publishedDate=" + publishedDate + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate
				+ ", createdUser=" + createdUser + ", updatedUser="
				+ updatedUser + ", contexts=" + contexts + ", attributes="
				+ attributes + "]";
	}

	
	
	
}
