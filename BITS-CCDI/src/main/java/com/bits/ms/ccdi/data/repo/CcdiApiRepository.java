/*
 * Application: Wellpoint Enrollment System
 * 
 * -------------------------------
 * Copyright (c) WellPoint, Inc
 * -------------------------------
 * This software is the confidential and proprietary information of WellPoint, Inc. ("Confidential Information").
 * You shall not disclose such confidential information, and shall use it only in accordance with the terms of the 
 * license agreement you entered into with WellPoint.
 */
package com.bits.ms.ccdi.data.repo;


import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bits.ms.ccdi.data.repo.dao.CcdiSelectorDao;


/**
 * CcdiApiRepository uses CcdiSelectorDao to get the list of Generic or Glossary content from content repository
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @version 1.0
 */
@Component
public class CcdiApiRepository
{
	private static final Logger LOG = LogManager.getLogger(CcdiApiRepository.class);
	/**
	 * DAO instance for getting the Generic or Glossary content from content repository
	 */
	@Autowired
	private CcdiSelectorDao ccdiSelectorDao;

	/**
	 * Returns the list of Generic or Glossary content from content repository
	 * 
	 * @param component
	 *            The CCDI request component
	 * @return
	 * @return List of response component objects for the given component request
	 * @throws SQLException
	 */
	public List<com.bits.ms.ccdi.entities.cms.Component> getComponentData(com.bits.ms.ccdi.entities.cms.Component component)
			throws com.bits.ms.ccdi.exception.DataAccessException
	{
		List<com.bits.ms.ccdi.entities.cms.Component> components = ccdiSelectorDao.getComponentData(component);
		LOG.debug("Components size=" + components.size());
		return components;
	}

	/**
	 * @return the ccdiSelectorDao
	 */
	public CcdiSelectorDao getCcdiSelectorDao()
	{
		return ccdiSelectorDao;
	}

	/**
	 * @param ccdiSelectorDao
	 *            the ccdiSelectorDao to set
	 */
	public void setCcdiSelectorDao(CcdiSelectorDao ccdiSelectorDao)
	{
		this.ccdiSelectorDao = ccdiSelectorDao;
	}
}
