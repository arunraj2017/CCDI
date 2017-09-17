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

import java.util.Date;
import java.util.UUID;

/**
 * 
 * Encapsulates all HTTP-specific information about an individual HTTP request.
 * 
 * @author AB69987
 * @version 1.0
 * 
 */
public class HttpContext extends BaseContext {

	private static final long serialVersionUID = 4060053623863263260L;

	private String userAgent;

	private String referral;

	private String device;

	// New Attributes
	private String requestMethod;
	private String isAjaxRequest;
	private String securityToken;
	private String accept;
	private String acceptLanguage;
	private String acceptEncoding;
	private String requestCacheControl;
	private String deviceProfile; // we already have device
	private String cookies;
	private String jvmInstance;
	private Date httpDate;
	private String requestURL;
	private String httpCorrelationId;
	private String eventId;

	private String xff; // x-forwarded-for
						// http://en.wikipedia.org/wiki/X-Forwarded-For
						// "PUT,GET"
	private String sessionId;

	/**
	 * @param httpContext
	 */
	public HttpContext(HttpContext httpContext) {
		if (null != httpContext) {
			this.accept = httpContext.getAccept();
			this.acceptEncoding = httpContext.getAcceptEncoding();
			this.acceptLanguage = httpContext.getAcceptLanguage();
			this.cookies = httpContext.getCookies();
			this.device = httpContext.getDevice();
			this.deviceProfile = httpContext.getDeviceProfile();
			this.httpCorrelationId = httpContext.getHttpCorrelationId();
			this.httpDate = httpContext.getHttpDate();
			this.isAjaxRequest = httpContext.getIsAjaxRequest();
			this.jvmInstance = httpContext.getJvmInstance();
			this.requestURL = httpContext.getRequestURL();
			this.referral = httpContext.getReferral();
			this.requestCacheControl = httpContext.getRequestCacheControl();
			this.requestMethod = httpContext.getRequestMethod();
			this.securityToken = httpContext.getSecurityToken();
			this.sessionId = httpContext.getSessionId();
			this.userAgent = httpContext.getUserAgent();
			this.xff = httpContext.getXff();
		}

	}

	/**
	 * Create HTTP Context with correlation id. Where correlation id is randomly generated.
	 */
	public HttpContext() {
		httpCorrelationId = UUID.randomUUID().toString();
	}

	/**
	 * @return the userAgent
	 */
	public String getUserAgent() {
		return userAgent;
	}

	/**
	 * @param userAgent the userAgent to set
	 */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	/**
	 * @return the referral
	 */
	public String getReferral() {
		return referral;
	}

	/**
	 * @param referral the referral to set
	 */
	public void setReferral(String referral) {
		this.referral = referral;
	}

	/**
	 * @return the device
	 */
	public String getDevice() {
		return device;
	}

	/**
	 * @param device the device to set
	 */
	public void setDevice(String device) {
		this.device = device;
	}

	/**
	 * @return the requestMethod
	 */
	public String getRequestMethod() {
		return requestMethod;
	}

	/**
	 * @param requestMethod the requestMethod to set
	 */
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	/**
	 * @return the isAjaxRequest
	 */
	public String getIsAjaxRequest() {
		return isAjaxRequest;
	}

	/**
	 * @param isAjaxRequest the isAjaxRequest to set
	 */
	public void setIsAjaxRequest(String isAjaxRequest) {
		this.isAjaxRequest = isAjaxRequest;
	}

	/**
	 * @return the securityToken
	 */
	public String getSecurityToken() {
		return securityToken;
	}

	/**
	 * @param securityToken the securityToken to set
	 */
	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken;
	}

	/**
	 * @return the accept
	 */
	public String getAccept() {
		return accept;
	}

	/**
	 * @param accept the accept to set
	 */
	public void setAccept(String accept) {
		this.accept = accept;
	}

	/**
	 * @return the acceptLanguage
	 */
	public String getAcceptLanguage() {
		return acceptLanguage;
	}

	/**
	 * @param acceptLanguage the acceptLanguage to set
	 */
	public void setAcceptLanguage(String acceptLanguage) {
		this.acceptLanguage = acceptLanguage;
	}

	/**
	 * @return the acceptEncoding
	 */
	public String getAcceptEncoding() {
		return acceptEncoding;
	}

	/**
	 * @param acceptEncoding the acceptEncoding to set
	 */
	public void setAcceptEncoding(String acceptEncoding) {
		this.acceptEncoding = acceptEncoding;
	}

	/**
	 * @return the requestCacheControl
	 */
	public String getRequestCacheControl() {
		return requestCacheControl;
	}

	/**
	 * @param requestCacheControl the requestCacheControl to set
	 */
	public void setRequestCacheControl(String requestCacheControl) {
		this.requestCacheControl = requestCacheControl;
	}

	/**
	 * @return the deviceProfile
	 */
	public String getDeviceProfile() {
		return deviceProfile;
	}

	/**
	 * @param deviceProfile the deviceProfile to set
	 */
	public void setDeviceProfile(String deviceProfile) {
		this.deviceProfile = deviceProfile;
	}

	/**
	 * @return the cookies
	 */
	public String getCookies() {
		return cookies;
	}

	/**
	 * @param cookies the cookies to set
	 */
	public void setCookies(String cookies) {
		this.cookies = cookies;
	}

	/**
	 * @return the jvmInstance
	 */
	public String getJvmInstance() {
		return jvmInstance;
	}

	/**
	 * @param jvmInstance the jvmInstance to set
	 */
	public void setJvmInstance(String jvmInstance) {
		this.jvmInstance = jvmInstance;
	}

	/**
	 * @return the httpDate
	 */
	public Date getHttpDate() {
		return httpDate;
	}

	/**
	 * @param httpDate the httpDate to set
	 */
	public void setHttpDate(Date httpDate) {
		this.httpDate = httpDate;
	}

	/**
	 * @return the requestURL
	 */
	public String getRequestURL() {
		return requestURL;
	}

	/**
	 * @param requestURL the requestURL to set
	 */
	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}

	/**
	 * @return the httpCorrelationId
	 */
	public String getHttpCorrelationId() {
		return httpCorrelationId;
	}

	/**
	 * @param httpCorrelationId the httpCorrelationId to set
	 */
	public void setHttpCorrelationId(String httpCorrelationId) {
		this.httpCorrelationId = httpCorrelationId;
	}

	/**
	 * @return the eventId
	 */
	public String getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the xff
	 */
	public String getXff() {
		return xff;
	}

	/**
	 * @param xff the xff to set
	 */
	public void setXff(String xff) {
		this.xff = xff;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "HttpContext [userAgent=" + userAgent + ", referral=" + referral
				+ ", device=" + device + ", requestMethod=" + requestMethod
				+ ", isAjaxRequest=" + isAjaxRequest + ", securityToken="
				+ securityToken + ", accept=" + accept + ", acceptLanguage="
				+ acceptLanguage + ", acceptEncoding=" + acceptEncoding
				+ ", requestCacheControl=" + requestCacheControl
				+ ", deviceProfile=" + deviceProfile + ", cookies=" + cookies
				+ ", jvmInstance=" + jvmInstance + ", httpDate=" + httpDate
				+ ", requestURL=" + requestURL + ", httpCorrelationId="
				+ httpCorrelationId + ", eventId=" + eventId + ", xff=" + xff
				+ ", sessionId=" + sessionId + "]";
	}


}
