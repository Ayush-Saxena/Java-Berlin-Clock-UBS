package com.ubs.opsit.interviews.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ubs.opsit.interviews.dto.TimeInUnits;
import com.ubs.opsit.interviews.exceptions.IllegalInputTimeException;
import com.ubs.opsit.interviews.utility.Constants;

public class TimeValidator {

	public static TimeInUnits validateTime(String aTime) throws IllegalInputTimeException {

		if (aTime == null) {
			throw new IllegalInputTimeException(Constants.NULL_TIME_MSG);
		}
		Pattern expected = Pattern.compile(Constants.EXPECTED_TIME_FORMAT);
		Matcher matcher = expected.matcher(aTime);
		while (!matcher.find()) {
			throw new IllegalInputTimeException(Constants.INVALID_TIME_FORMAT_MSG);
		}

		String[] times = aTime.split(":", 3);

		int hours, minutes, seconds = 0;

		try {
			hours = Integer.parseInt(times[0]);
			minutes = Integer.parseInt(times[1]);
			seconds = Integer.parseInt(times[2]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Constants.INVALID_TIME_VALUES_MSG);
		}

		if (hours < 0 || hours > 24)
			throw new IllegalInputTimeException(Constants.HOURS_OUT_OF_BOUND_MSG);
		if (hours == 24 && (minutes > 0 || seconds > 0))
			throw new IllegalInputTimeException(Constants.INVALID_TIME_FORMAT_MSG);
		if (minutes < 0 || minutes > 59)
			throw new IllegalInputTimeException(Constants.MIN_OUT_OF_BOUND_MSG);
		if (seconds < 0 || seconds > 59)
			throw new IllegalInputTimeException(Constants.SEC_OUT_OF_BOUND_MSG);

		TimeInUnits validTime = new TimeInUnits();
		validTime.setHour(hours);
		validTime.setMin(minutes);
		validTime.setSec(seconds);

		return validTime;
	}
}
