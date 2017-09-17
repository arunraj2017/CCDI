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
package com.bits.ms.ccdi.api.cache;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * <p>
 * This class contains methods to get and put the value from cache based on the
 * component type
 * </p>
 * 
 * @version 1.0
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 */
@Service
public class CacheService {

	/**
	 * The central interface to provide configuration of the application.
	 */
	@Autowired
	private ApplicationContext applicationContext;

	/**
	 * Map containing the JNDI name for each type of Cache component
	 */

	@Resource(name = "jndiMapping")
	private Map<String, String> jndiMapping;;

	/**
	 * Fetch the content from the cache for the given key
	 * 
	 * @param applnName
	 *            component type which is used to get the cache object
	 * @param key
	 *            key to get an element from cache
	 * @return an object which is the value fetched from cache for the key
	 */
	public Object get(String applnName, Object key) {
		Map<Object, Object> cache = (Map<Object, Object>) applicationContext
				.getBean(jndiMapping.get(applnName));
		return cache.get(key);
	}

	/**
	 * Stores the key value pair in cache
	 * 
	 * @param applnName
	 *            component type which is used to get the cache object
	 * @param key
	 *            key of the element to be placed in cache
	 * @param value
	 *            value to be placed in cache
	 * @return true if the key value pair is placed in the cache.
	 */
	public boolean put(String applnName, Object key, Object value) {
		Map<Object, Object> cache = (Map<Object, Object>) applicationContext
				.getBean(jndiMapping.get(applnName));
		cache.put(key, value);
		return true;
	}

	/**
	 * Sets the jndi map
	 * 
	 * @param jndiMapping
	 *            A map object holds string as key and value
	 */
	public void setJndiMapping(Map<String, String> jndiMapping) {
		this.jndiMapping = jndiMapping;
	}

}
