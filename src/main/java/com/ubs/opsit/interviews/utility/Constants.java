package com.ubs.opsit.interviews.utility;

public class Constants {

	public static final char LAMP_OFF_SIGNAL = 'O';
	public static final String EXPECTED_TIME_FORMAT = "^([0-1]\\d|2[0-4]):([0-5]\\d):([0-5]\\d)$";
	public static final String INVALID_TIME_FORMAT_MSG = "Input time is in invalid Format";
	public static final String INVALID_TIME_VALUES_MSG = "Input time values are invalid";
	public static final String HOURS_OUT_OF_BOUND_MSG = "Hours are invalid (0-24 are valid values)";
	public static final String MIN_OUT_OF_BOUND_MSG = "Minutes are invalid (0-59 are valid values)";
	public static final String SEC_OUT_OF_BOUND_MSG = "Seconds are invalid (0-59 are valid values)";
	public static final String NULL_TIME_MSG = "Input time can not be null";
}