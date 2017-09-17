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
 * Enum to represent the different CCDI Admin operations
 *
 */
public enum CcdiAdminOperationTypeEnum {

  
    ADD,
    UPDATE,
    DELETE,
    SEARCH,
    GET;

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
    public static CcdiAdminOperationTypeEnum fromValue(String v) {
        return valueOf(v);
    }
}
