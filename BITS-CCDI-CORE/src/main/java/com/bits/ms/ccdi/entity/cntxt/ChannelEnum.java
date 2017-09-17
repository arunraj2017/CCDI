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
package com.bits.ms.ccdi.entity.cntxt;

/**
 * Enum to represent the different channels present in the E3.
 * 
 * @author Jileesh Janardhanan, Raghuraman Ponniah
 * @version 1.0
 *
 */
public enum ChannelEnum {

	AC("AC", "AC"), 
	ATK("ATK", "ATK"), 
	CD("CD", "CD"), 
	CP("CP", "CP"), 
	MC("MC","MC"), 
	SALI("SALI", "SALI");

	private String type;
	private String value;

	/**
	 * @param type
	 * @param value
	 */
	ChannelEnum(String type, String value) {
		this.type = type;
		this.value = value;
	}

	/**
	 * @return type
	 */
	private String type() {
		return type;
	}

	/**
	 * @return value
	 */
	private String value() {
		return value;
	}
}
