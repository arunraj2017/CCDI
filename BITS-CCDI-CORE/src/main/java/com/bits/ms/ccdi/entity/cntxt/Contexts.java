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


import java.io.Serializable;


/**
 * This class holds the reference of different context types present in E3. The different context types are BusinessContext, HttpContext,
 * ActivityContext, RequestContext and UserContext.
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @author Cognizant - Modified for E3
 * @version 1.0
 * 
 */
public class Contexts implements Serializable
{

	private static final long serialVersionUID = 2705197117612383615L;

	/**
	 * Encapsulates all the business related information about a request (PortalContext and ProcessContext extends BusinessContext)
	 */
	private BusinessContext businessContext;

	/**
	 * Encapsulates all HTTP-specific information about an individual HTTP request.
	 */
	private HttpContext httpContext;

	/**
	 * Encapsulates information like job and task activity details. (JobContext and TaskContext extends ActivityContext)
	 */
	private ActivityContext activityContext;

	/**
	 * Encapsulates information about an HTTP request that matches a defined route.
	 */
	private RequestContext requestContext;

	/**
	 * Encapsulates information about an user in the session
	 */
	private UserContext userContext;
	
	/**
	 * Encapsulates information about System.
	 */
	private SystemContext systemContext;

	/**
	 * empty constructor.
	 */
	public Contexts()
	{
		this.systemContext = SystemContext.getInstance();
	}

	/**
	 * @param contexts
	 */
	public Contexts(Contexts contexts)
	{
		this.businessContext = new BusinessContext(contexts.getBusinessContext());
		this.httpContext = new HttpContext(contexts.getHttpContext());
		this.activityContext = new ActivityContext(contexts.getActivityContext());
		this.requestContext = new RequestContext(contexts.getRequestContext());
		this.userContext = new UserContext(contexts.getUserContext());
		this.systemContext = SystemContext.getInstance();
	}

	/**
	 * Returns all the business related information about a request.
	 * PortalContext and ProcessContext extends BusinessContext.
	 *  
	 * @return the businessContext
	 */
	public BusinessContext getBusinessContext()
	{
		return businessContext;
	}

	/**
	 * Sets all the business related information about a request.
	 * PortalContext and ProcessContext extends BusinessContext.
	 * 
	 * @param businessContext
	 *            the businessContext to set
	 */
	public void setBusinessContext(BusinessContext businessContext)
	{
		this.businessContext = businessContext;
	}

	/**
	 * Returns all HTTP-specific information about an individual HTTP request.
	 * 
	 * @return the httpContext
	 */
	public HttpContext getHttpContext()
	{
		return httpContext;
	}

	/**
	 * Sets all HTTP-specific information about an individual HTTP request.
	 * 
	 * @param httpContext
	 *            the httpContext to set
	 */
	public void setHttpContext(HttpContext httpContext)
	{
		this.httpContext = httpContext;
	}

	/**
	 * Returns all the information like job and task activity details.
	 * JobContext and TaskContext extends ActivityContext
	 * 
	 * @return the activityContext
	 */
	public ActivityContext getActivityContext()
	{
		return activityContext;
	}

	/**
	 * Sets all the information like job and task activity details.
	 * JobContext and TaskContext extends ActivityContext
	 * 
	 * @param activityContext
	 *            the activityContext to set
	 */
	public void setActivityContext(ActivityContext activityContext)
	{
		this.activityContext = activityContext;
	}

	/**
	 * Returns information about an HTTP request that matches a defined route.
	 * 
	 * @return the requestContext
	 */
	public RequestContext getRequestContext()
	{
		return requestContext;
	}

	/**
	 * Sets information about an HTTP request that matches a defined route.
	 * 
	 * @param requestContext
	 *            the requestContext to set
	 */
	public void setRequestContext(RequestContext requestContext)
	{
		this.requestContext = requestContext;
	}

	/**
	 * Returns information about an user in the session.
	 * 
	 * @return the userContext
	 */
	public UserContext getUserContext()
	{
		return userContext;
	}

	/**
	 * Set user information retrieved from the session.
	 * 
	 * @param userContext
	 *            the userContext to set
	 */
	public void setUserContext(UserContext userContext)
	{
		this.userContext = userContext;
	}

	/**
	 * @return the systemContext
	 */
	public SystemContext getSystemContext() {
		return systemContext;
	}


	@Override
	public String toString()
	{
		return "Contexts [businessContext=" + businessContext + ", httpContext=" + httpContext + ", activityContext=" + activityContext
				+ ", requestContext=" + requestContext + ", userContext=" + userContext + ", systemContext=" + systemContext + "]";
	}

}
