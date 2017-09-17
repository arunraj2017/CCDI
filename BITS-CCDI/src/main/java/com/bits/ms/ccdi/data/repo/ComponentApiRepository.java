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

import com.bits.ms.ccdi.data.repo.dao.ComponentSelectorDao;
import com.bits.ms.ccdi.entities.cms.Component;
import com.bits.ms.ccdi.exception.DataAccessException;

/**
 * ComponentApiRepository uses ComponentSelectorDao to get the list of content
 * from repository based on the component type
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @author Cognizant - Modified for E3
 * @version 1.0
 */
@org.springframework.stereotype.Component
public class ComponentApiRepository {

	private static final Logger LOG = LogManager.getLogger(ComponentApiRepository.class);
	@Autowired
	/**
	 * DAO instance for getting the content from repository based on the component type
	 */
	private ComponentSelectorDao componentSelectorDao;

	/**
	 * Returns the list of content from repository based on the component type
	 * 
	 * @param component
	 *            The CCDI request component
	 * @return List of response component objects for the given component
	 *         request
	 * @throws SQLException
	 */
	public List<Component> getComponentData(Component component) throws DataAccessException {
		List<Component> components = componentSelectorDao.getComponentData(component);
		LOG.debug("Retrieved result from DB:{}", components);
		return components;
	}

	/**
	 * This method will return instance of component selector DAO.
	 * 
	 * @return the componentSelectorDao
	 */
	public ComponentSelectorDao getComponentSelectorDao() {
		return componentSelectorDao;
	}

	/**
	 * This method will set component selector dao.
	 * 
	 * @param componentSelectorDao
	 *            the componentSelectorDao to set
	 */
	public void setComponentSelectorDao(
			ComponentSelectorDao contextSelectorDao) {
		this.componentSelectorDao = contextSelectorDao;
	}

}
