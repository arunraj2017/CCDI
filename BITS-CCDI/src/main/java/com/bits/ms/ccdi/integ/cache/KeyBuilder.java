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
package com.bits.ms.ccdi.integ.cache;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import com.bits.ms.ccdi.api.constants.CcdiApiConstants;
import com.bits.ms.ccdi.api.core.io.BaseAbstractRequest;
import com.bits.ms.ccdi.api.io.CcdiRequest;
import com.bits.ms.ccdi.entities.cntxt.ComponentElement;
import com.bits.ms.ccdi.entities.cntxt.ContextMetaData;
import com.bits.ms.ccdi.entities.cntxt.EnvironmentEntry;
import com.bits.ms.ccdi.entities.cntxt.Gateway;
import com.bits.ms.ccdi.entities.cntxt.GenericComponent;
import com.bits.ms.ccdi.entities.cntxt.GlossaryComponent;
import com.bits.ms.ccdi.entities.cntxt.Property;
import com.bits.ms.ccdi.entities.cntxt.Validator;
import com.bits.ms.ccdi.entities.cntxt.Verbiage;

/**
 * Key builder class for generating the cache key by using CCDI request
 * parameters
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @author Cognizant - Modified for E3
 * @version 1.0
 */
@Component
public class KeyBuilder {

	/**
	 * For logging
	 */
	private static final Logger LOGGER = LogManager.getLogger(KeyBuilder.class);
	
	/**
	 * Generates the cache key for the ccdi request
	 * 
	 * @param request
	 *            object which has the request id, correlation id and the
	 *            metadata
	 * @return cache key as String
	 */
	@Transformer
	public String build(BaseAbstractRequest request) {
		String cacheKey = null;
		try
		{
		if (request instanceof CcdiRequest) {
			cacheKey = getCacheKey((CcdiRequest) request);
		}
		}
		catch(Exception e)
		{
			LOGGER.error("Error in KeyBuilder-build:: ", e);
		}
		return cacheKey;
	}

	/**
	 * Constructs cache key with component element's meta data with use of
	 * HashCodeBuilder. <BR />
	 * Cache key will be constructed based on the component type.
	 * 
	 * @param request
	 *            request which has the component element details that need to
	 *            be retrieved along with the metadata
	 * @return cache key as String
	 */
	private String getCacheKey(CcdiRequest request) {
		ComponentElement componentElement = request.getComponentElement();
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		String prefixForHashcode = null;

		if (componentElement != null && componentElement.getMetaData() != null) {
			ContextMetaData metaData = componentElement.getMetaData().get(0);
			hashCodeBuilder.append(metaData.getVisualRole());
			hashCodeBuilder.append(metaData.getState());
			hashCodeBuilder.append(metaData.getCounty());
			hashCodeBuilder.append(metaData.getCity());
			hashCodeBuilder.append(metaData.getPlanType());
			hashCodeBuilder.append(metaData.getPlanYear());
			hashCodeBuilder.append(metaData.getProductCode());
			hashCodeBuilder.append(metaData.getBrand());
			hashCodeBuilder.append(metaData.getSite());
			hashCodeBuilder.append(metaData.getLanguage());
			hashCodeBuilder.append(metaData.getLob());
			hashCodeBuilder.append(metaData.getChannel());
			hashCodeBuilder.append(metaData.getProductFamily());
			hashCodeBuilder.append(metaData.getProviderPlan());
			hashCodeBuilder.append(metaData.getUserType());
			hashCodeBuilder.append(metaData.getVendor());
			hashCodeBuilder.append(metaData.getSiteType());
			hashCodeBuilder.append(metaData.getProviderSpeciality());
			hashCodeBuilder.append(metaData.getUserRole());
			hashCodeBuilder.append(metaData.getEntitlement());
			hashCodeBuilder.append(metaData.getExpiryDate());
			hashCodeBuilder.append(metaData.getPlanEffectiveDate());
		}
		if (componentElement != null) {
			if (CcdiApiConstants.COMPONENT_TYPE_GENERIC
					.equalsIgnoreCase(componentElement.getComponentType())) {
				GenericComponent genericContent = (GenericComponent) componentElement;
				hashCodeBuilder.append(genericContent.getCategory());
				hashCodeBuilder.append(genericContent.getPage());
				hashCodeBuilder.append(genericContent.getBlock());
				prefixForHashcode = genericContent.getComponentType() + "-"
						+ genericContent.getPage() + "-"
						+ genericContent.getCategory() + "-"
						+ genericContent.getBlock() + "-";
			} else if (CcdiApiConstants.COMPONENT_TYPE_PROPERTY
					.equalsIgnoreCase(componentElement.getComponentType())) {
				Property property = (Property) componentElement;
				hashCodeBuilder.append(property.getName());
				prefixForHashcode = property.getComponentType() + "-"
						+ property.getName() + "-";
			} else if (CcdiApiConstants.COMPONENT_TYPE_ENV
					.equalsIgnoreCase(componentElement.getComponentType())) {
				EnvironmentEntry environmentEntry = (EnvironmentEntry) componentElement;
				hashCodeBuilder.append(environmentEntry.getKey());

				prefixForHashcode = environmentEntry.getComponentType() + "-"
						+ environmentEntry.getKey() + "-";

			} else if (CcdiApiConstants.COMPONENT_TYPE_VERBIAGE
					.equalsIgnoreCase(componentElement.getComponentType())) {
				Verbiage verbiage = (Verbiage) componentElement;
				hashCodeBuilder.append(verbiage.getKey());
				prefixForHashcode = verbiage.getComponentType() + "-"
						+ verbiage.getKey() + "-";
			} else if (CcdiApiConstants.COMPONENT_TYPE_VALIDATOR
					.equalsIgnoreCase(componentElement.getComponentType())) {
				Validator validator = (Validator) componentElement;
				hashCodeBuilder.append(validator.getAction());
				prefixForHashcode = validator.getComponentType() + "-"
						+ validator.getAction() + "-";

			} else if (CcdiApiConstants.COMPONENT_TYPE_GATEWAY
					.equalsIgnoreCase(componentElement.getComponentType())) {
				Gateway gateway = (Gateway) componentElement;
				hashCodeBuilder.append(gateway.getAction());
				prefixForHashcode = gateway.getComponentType() + "-"
						+ gateway.getAction() + "-";

			} else if (CcdiApiConstants.COMPONENT_TYPE_GLOSSARY
					.equalsIgnoreCase(componentElement.getComponentType())) {
				GlossaryComponent glossaryContent = (GlossaryComponent) componentElement;
				hashCodeBuilder.append(glossaryContent.getGlossaryTerm());
				prefixForHashcode = glossaryContent.getComponentType() + "-"
						+ glossaryContent.getGlossaryTerm() + "-";
			}
		}
		int hashCode = hashCodeBuilder.toHashCode();
		LOGGER.debug("Key = " + prefixForHashcode + hashCode);
		// return Integer.valueOf(hashCode).toString();
		return prefixForHashcode + hashCode;
	}
}
