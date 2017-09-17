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
package com.bits.ms.ccdi.entities.cntxt;

/**
 * Enum to represent different component types
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @version 1.0
 *
 */
public enum ComponentTypes {

	Generic_Component("GENERIC"),
	Property_Component("PROPERTY"),
    EnvironmentEntry_Component("ENVIRONMENT"),
    Verbiage_Component("VERBIAGE"),
    Gateway_Component("GATEWAY"),
	Glossary_Component("GLOSSARY"),
	Validator_Component("VALIDATOR");
    
    
    private final String value;

	/**
	 * @param v
	 */
    ComponentTypes(String v) {
        value = v;
    }

	/**
	 * @return the value
	 */
    public String value() {
        return value;
    }

    /**
     * @param v
     * @return ComponentTypes
     */
    public static ComponentTypes fromValue(String v) {
        for (ComponentTypes c: ComponentTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
