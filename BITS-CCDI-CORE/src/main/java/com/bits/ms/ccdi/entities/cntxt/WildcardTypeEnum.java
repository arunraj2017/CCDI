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
 * Enum to represent the different wild card types
 *
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @version 1.0
 *
 */
public enum WildcardTypeEnum {

  
    TERM_START_WITH,
    NONE;

    /**
     * Get the wildCard value
     */
    public String value() {
        return name();
    }

    /**
     * @param v
     * @return WildcardTypeEnum
     */
    public static WildcardTypeEnum fromValue(String v) {
        return valueOf(v);
    }
}
