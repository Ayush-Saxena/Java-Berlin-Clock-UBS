package com.ubs.opsit.interviews.utility;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.ubs.opsit.interviews.domain.Colour;
import com.ubs.opsit.interviews.domain.Lamp;

public class ClockUtilTest {

	@Test
	public void getStateOfLampTest() {

		Lamp testLamp = new Lamp(Colour.R);
		testLamp.setState(true);

		assertThat(ClockUtil.getStateOfLamp(testLamp)).isEqualTo(Colour.R.name());
	}

	@Test
	public void getStateOfLampTest_Off() {

		Lamp testLamp = new Lamp(Colour.Y);
		testLamp.setState(false);

		assertThat(ClockUtil.getStateOfLamp(testLamp)).isEqualTo(Constants.LAMP_OFF_SIGNAL);
	}
}
