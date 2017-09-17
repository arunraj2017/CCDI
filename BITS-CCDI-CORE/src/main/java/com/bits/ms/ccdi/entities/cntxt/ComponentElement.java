/*
 * Application: E3
 * 
 * -------------------------------
 * Copyright (c) WellPoint, Inc
 * -------------------------------
 * This software is the confidential and proprietary information of WellPoint, Inc. ("Confidential Information").
 * You shall not disclose such confidential information, and shall use it only in accordance with the terms of the 
 * license agreement you entered into with WellPoint.
 * 
 */
package com.bits.ms.ccdi.entities.cntxt;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * An abstract class which represent the component element details. This class inherits the basic entity properties from Entity class.
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @version 1.0
 *
 */
public abstract class ComponentElement extends Entity implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id; 
	
	private String cmsId; 
	
	private String title; 
	
	private String group; 
	
	private String error; 
	
	private String text; 
	
	private String componentType; 
	
	private List<ContextMetaData> metaData; 
	
	private String revision; 
	
	private String source; 
	
	private Double score; 
	
	private String comments; 
	
	private String cmsStatus;
	
	private String cdiStatus;
	
	private Date publishedDate;
	
	private Date cmsUpdateDate; 
	
	private Date createdDate; 
	
	private Date updatedDate;
	
	private String updatedDateFrom;
	
	private String updatedDateTo;
		
	private String publishDateFrom;
	
	private String publishDateTo;
	
	private String expryDateForSearch;
	
	private String plnEffctvDateForSearch;

	/**
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the componentType
	 */
	public String getComponentType() {
		return componentType;
	}

	/**
	 * @param componentType the componentType to set
	 */
	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}

	/**
	 * @return the metaData
	 */
	public List<ContextMetaData> getMetaData() {
		return metaData;
	}

	/**
	 * @param metaData the metaData to set
	 */
	public void setMetaData(List<ContextMetaData> metaData) {
		this.metaData = metaData;
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
	 * @return the score
	 */
	public Double getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(Double score) {
		this.score = score;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
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
	 * @return the cmsUpdateDate
	 */
	public Date getCmsUpdateDate() {
		return cmsUpdateDate;
	}

	/**
	 * @param cmsUpdateDate the cmsUpdateDate to set
	 */
	public void setCmsUpdateDate(Date cmsUpdateDate) {
		this.cmsUpdateDate = cmsUpdateDate;
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
	 * Displays component element details
	 */
	@Override
	public String toString() {
		return "ComponentElement [Id=" + this.id + ", cmsId=" + cmsId + ", title="
				+ title + ", group=" + group + ", error=" + error + ", text="
				+ text + ", componentType=" + componentType + ", metaData="
				+ metaData + ", revision=" + revision + ", source=" + source
				+ ", score=" + score + ", comments=" + comments
				+ ", cmsStatus=" + cmsStatus + ", cdiStatus=" + cdiStatus
				+ ", cmsUpdateDate=" + cmsUpdateDate + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	} 

	
}
