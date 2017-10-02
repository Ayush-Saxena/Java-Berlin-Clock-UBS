package com.ubs.opsit.interviews.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.ubs.opsit.interviews.domain.Colour;

public class BerlinClockTest {

	BerlinClock clock;

	@Before
	public void setUp() {

		clock =  new BerlinClock.Builder()
				.row().lamp(1, Colour.Y)
				.and()
				.row().lamp(4, Colour.R)
				.and()
				.row().lamp(4, Colour.R)
				.and()
				.row().lamp(2, Colour.Y).lamp(1, Colour.R).lamp(2, Colour.Y).lamp(1, Colour.R).lamp(2, Colour.Y).lamp(1, Colour.R).lamp(2, Colour.Y)
				.and()
				.row().lamp(4, Colour.Y).build();
		
		
	}

	@Test
	public void convertTime_Invalid() {

		clock.convertTime("abc");

	}
	
	@Test
	public void convertTime_correctTime(){
		
		String expected = "Y OOOO OOOO OOOOOOOOOOO OOOO";
		String s = clock.convertTime("00:00:00");
		String t = s.replace(String.valueOf('\r') + String.valueOf('\n'), " ");
		assertThat(t).isEqualTo(expected);
	}

	@Test
	public void convertTime_correctTimeAnother(){
		
		String expected = "O RRRO OOOO YYRYYRYOOOO YYOO";
		String s = clock.convertTime("15:37:37");
		String t = s.replace(String.valueOf('\r') + String.valueOf('\n'), " ");
		assertThat(t).isEqualTo(expected);
	}
}
