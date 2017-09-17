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


/**
 * Encapsulates information about an HTTP request that matches a defined route.
 * 
 * @author AB69987
 * @version 1.0
 */
public class RequestContext extends BaseContext
{

	private static final long serialVersionUID = 1L;

	private String requestScope;

	private String action;

	private String ipAddress;

	/**
	 * @param requestContext
	 */
	public RequestContext(RequestContext requestContext)
	{
		if (null != requestContext)
		{
			this.action = requestContext.getAction();
			this.requestScope = requestContext.getRequestScope();
			this.ipAddress = requestContext.getIpAddress();
		}

	}

	/**
	 * Default Constructor.
	 */
	public RequestContext()
	{
	}

	/**
	 * @return the requestScope
	 */
	public String getRequestScope()
	{
		return requestScope;
	}

	/**
	 * @param requestScope
	 *            the requestScope to set
	 */
	public void setRequestScope(String requestScope)
	{
		this.requestScope = requestScope;
	}

	/**
	 * @return the action
	 */
	public String getAction()
	{
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(String action)
	{
		this.action = action;
	}

	/**
	 * @return the ipAddress
	 */
	public String getIpAddress()
	{
		return ipAddress;
	}

	/**
	 * @param ipAddress
	 *            the ipAddress to set
	 */
	public void setIpAddress(String ipAddress)
	{
		this.ipAddress = ipAddress;
	}

	@Override
	public String toString()
	{
		return "RequestContext [requestScope=" + requestScope + ", action=" + action + ", ipAddress=" + ipAddress + "]";
	}
}
