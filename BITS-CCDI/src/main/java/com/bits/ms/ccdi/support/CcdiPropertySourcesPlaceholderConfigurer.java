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
package com.bits.ms.ccdi.support;


import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.bits.ms.ccdi.data.repo.dao.ComponentSelectorDao;
import com.bits.ms.ccdi.exception.DataAccessException;

/**
 * Specialization of PlaceholderConfigurerSupport that resolves ${...} placeholders within bean definition property 
 * values and @Value annotations against the current Spring Environment and its set of PropertySources. 
 * 
 * @author Cognizant
 * 
 */
public class CcdiPropertySourcesPlaceholderConfigurer extends
		PropertySourcesPlaceholderConfigurer {

	/**
	 * Merge, convert and process properties against the given bean factory.
	 * @param beanFactory
	 * @throws BeansException
	 */
	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		ComponentSelectorDao componentSelectorDao = (ComponentSelectorDao) beanFactory
				.getBean("componentSelectorDao");
		try {
			CcdiPlaceholderProperties dbProps = new CcdiPlaceholderProperties(
					componentSelectorDao);
			setProperties(dbProps);
			super.postProcessBeanFactory(beanFactory);
		} catch (DataAccessException ex) {
			throw new FatalBeanException(
					 ex.getLocalizedMessage());
		}
	}

}
