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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bits.ms.ccdi.data.repo.dao.CcdiWildcardSelectorDao;
import com.bits.ms.ccdi.entities.cntxt.WildcardTypeEnum;
import com.bits.ms.ccdi.exception.DataAccessException;

/**
 * CcdiApiWildcardRepository uses CcdiWildcardSelectorDao to get the list of
 * glossary content from repository
 * 
 * @author AB69987
 * @author Cognizant - Modified for E3
 * @version 1.0
 */
@Component
public class CcdiApiWildcardRepository {

	@Autowired
	/**
	 * DAO instance for getting the Glossary content with wildcard from content repository
	 */
	private CcdiWildcardSelectorDao ccdiWildcardSelectorDao;

	/**
	 * Returns the list of glossary content from repository
	 * 
	 * @param component
	 *            The CCDI request component
	 * @param wildcardTypeEnum
	 *            wild card type
	 * @return List of content from repository
	 * @throws SQLException
	 */
	public List<com.bits.ms.ccdi.entities.cms.Component> getComponentData(com.bits.ms.ccdi.entities.cms.Component component,
			WildcardTypeEnum wildcardTypeEnum) throws DataAccessException {
		List<com.bits.ms.ccdi.entities.cms.Component> components = ccdiWildcardSelectorDao.getComponentData(
				component, wildcardTypeEnum);
		return components;
	}

	/**
	 * @return the ccdiWildcardSelectorDao
	 */
	public CcdiWildcardSelectorDao getCcdiWildcardSelectorDao() {
		return ccdiWildcardSelectorDao;
	}

	/**
	 * @param ccdiWildcardSelectorDao the ccdiWildcardSelectorDao to set
	 */
	public void setCcdiWildcardSelectorDao(
			CcdiWildcardSelectorDao ccdiWildcardSelectorDao) {
		this.ccdiWildcardSelectorDao = ccdiWildcardSelectorDao;
	}

}
