package com.ubs.opsit.interviews.utility;

import com.ubs.opsit.interviews.domain.Lamp;

public class ClockUtil {

	public static char getStateOfLamp(Lamp alamp) {

		char colour = alamp.isState() ? alamp.getColour() : Constants.LAMP_OFF_SIGNAL;
		return colour;

	}

}
