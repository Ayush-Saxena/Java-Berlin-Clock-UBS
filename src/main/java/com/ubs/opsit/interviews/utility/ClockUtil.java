package com.ubs.opsit.interviews.utility;

import com.ubs.opsit.interviews.domain.Lamp;

public class ClockUtil {

	public static String getStateOfLamp(Lamp alamp) {

		String colour = alamp.isState() ? alamp.getColour().name() : Constants.LAMP_OFF_SIGNAL;
		return colour;
	}

}
