/*
 * 
 * -------------------------------
 * Copyright (c) WellPoint, Inc
 * -------------------------------
 * This software is the confidential and proprietary information of WellPoint, Inc. ("Confidential Information").
 * You shall not disclose such confidential information, and shall use it only in accordance with the terms of the 
 * license agreement you entered into with WellPoint.
 */
package com.bits.ms.ccdi.resolvrs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.bits.ms.ccdi.core.exception.NoValidatorRulesetFoundException;
import com.bits.ms.ccdi.entities.cntxt.ComponentElement;
import com.bits.ms.ccdi.entities.cntxt.Validator;
import com.bits.ms.ccdi.entity.cntxt.Contexts;

/**
 * <p>
 * This class retrieves the validator RuleSet component element for the given
 * action. Along with the action name, Other context information such as brand,
 * state etc will also be used while retrieving the content. If there are more
 * than one record found for the given request, the records will be scored and
 * filtered based on the context information requested
 * </p>
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @author Cognizant - Modified for E3
 * @version 1.0
 * @see ComponentKeyResolver
 */
@Component
public class ValidatorRulesetResolver extends ComponentKeyResolver 
{
	/**
	 * For logging
	 */
	private static final Logger LOGGER = LogManager.getLogger(ValidatorRulesetResolver.class);
	
	/**
	 * Calls resolveKey in ContextKeyResolver and returns the Validator
	 * component element
	 * 
	 * @param contexts
	 *            - Context object that contains various properties about this
	 *            particular request
	 * @param action
	 *            Action name for which the Validator Ruleset information is
	 *            being requested
	 * @return Validator component element
	 * @throws NoValidatorRulesetFoundException 
	 */
	public Validator resolveRuleset(Contexts contexts, String action) throws NoValidatorRulesetFoundException{
		LOGGER.debug("(action,BusinessContext)->("+action+","+contexts.getBusinessContext()+")");
		Validator validator = (Validator) resolveKey(contexts, action, Boolean.TRUE);
		if(validator == null)
		{
			throw new NoValidatorRulesetFoundException("NO Validator text  found for " + action
					+ " key in CCDIAPI  And BusinessContext is: "
					+ contexts.getBusinessContext() + "UserContext is: "
					+ contexts.getUserContext());
		}
		LOGGER.debug("Validator=" + validator);
		return validator;
	}

	/**
	 * Creates Validator Request object with the action passed
	 * 
	 * @param action
	 *            Action name for which the Validator Ruleset information is
	 *            being requested
	 * 
	 * @return Validator component element
	 */
	@Override
	protected ComponentElement createComponentType(String... attributes) {
		Validator validator = new Validator();
		validator.setAction(attributes[0]);
		return validator;
	}

}
