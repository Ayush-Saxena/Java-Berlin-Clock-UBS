package com.ubs.opsit.interviews.validator;

import org.junit.Test;

import com.ubs.opsit.interviews.exceptions.IllegalInputTimeException;

public class TimeValidatorTest {

	@Test(expected = IllegalInputTimeException.class)
	public void invalidTimeValue() throws IllegalInputTimeException {

		TimeValidator.validateTime("ab:de:fg");

	}

	@Test(expected = IllegalInputTimeException.class)
	public void invalidTimeFormat_ExcessTime() throws IllegalInputTimeException {

		TimeValidator.validateTime("24:00:01");

	}

	@Test(expected = IllegalInputTimeException.class)
	public void invalidTimeFormat() throws IllegalInputTimeException {

		TimeValidator.validateTime("00:00:123");

	}

	@Test
	public void validMidNight() throws IllegalInputTimeException {

		TimeValidator.validateTime("00:00:00");

	}

	@Test(expected = IllegalInputTimeException.class)
	public void outOfBound_Hours() throws IllegalInputTimeException {

		TimeValidator.validateTime("25:00:00");

	}

	@Test(expected = IllegalInputTimeException.class)
	public void outOfBound_Mins() throws IllegalInputTimeException {

		TimeValidator.validateTime("00:60:00");

	}

	@Test(expected = IllegalInputTimeException.class)
	public void outOfBound_Secs() throws IllegalInputTimeException {

		TimeValidator.validateTime("00:00:60");

	}

	@Test(expected = IllegalInputTimeException.class)
	public void invalidFormat_invalidDelimiter() throws IllegalInputTimeException {

		TimeValidator.validateTime("00?00?13");

	}

	@Test(expected = IllegalInputTimeException.class)
	public void invalidTime_null() throws IllegalInputTimeException {

		TimeValidator.validateTime(null);

	}

	@Test
	public void validTime() throws IllegalInputTimeException {

		TimeValidator.validateTime("23:59:00");

	}
	
	@Test(expected = IllegalInputTimeException.class)
	public void invalidFormat_singleDigits() throws IllegalInputTimeException {
		
		TimeValidator.validateTime("10:0:50");
		
	}
}
