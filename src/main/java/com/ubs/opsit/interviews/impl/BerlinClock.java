/**
 * 
 */
package com.ubs.opsit.interviews.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.domain.Lamp;
import com.ubs.opsit.interviews.dto.TimeInUnits;
import com.ubs.opsit.interviews.utility.ClockUtil;
import com.ubs.opsit.interviews.validator.TimeValidator;

/**
 * @author asax30
 *
 */
public class BerlinClock implements TimeConverter {

	private final List<List<Lamp>> clock;

	public static class Builder {

		private List<List<Lamp>> clock;

		public Builder() {

			clock = new ArrayList<>();

		}

		public Builder row() {

			List<Lamp> newRow = new ArrayList<>();
			clock.add(newRow);
			return this;

		}

		public Builder and() {

			return this;

		}

		public Builder lamp(int num, char colour) {

			int lastRow = clock.size() - 1;
			for (int i = 0; i < num; i++) {

				Lamp newLamp = new Lamp(colour);
				clock.get(lastRow).add(newLamp);

			}
			return this;

		}

		public BerlinClock build() {

			return new BerlinClock(this);

		}

	}

	private BerlinClock(Builder builder) {

		this.clock = builder.clock;
	}

	@Override
	public String convertTime(String aTime)  {

		try {

			TimeInUnits inputTime = TimeValidator.validateTime(aTime);
			processTime(inputTime);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return this.toString();

	}

	private void processTime(TimeInUnits iTime) {

		processSeconds(iTime.getSec());
		processHours(iTime.getHour());
		processMinutes(iTime.getMin());

	}

	private void processSeconds(int seconds) {

		if (seconds % 2 == 0) {
			this.clock.get(0).get(0).switchOn();
		}
	}

	private void processHours(int hours) {

		// Process 2nd row
		int count = hours / 5;
		for (int i = 0; i < count; i++) {
			this.clock.get(1).get(i).switchOn();
		}

		// Process 3rd row
		int count2 = hours % 5;
		for (int i = 0; i < count2; i++) {
			this.clock.get(2).get(i).switchOn();
		}
	}

	private void processMinutes(int minutes) {

		// Process 4th row
		int count = minutes / 5;
		for (int i = 0; i < count; i++) {
			this.clock.get(3).get(i).switchOn();
		}

		// Process 5th row
		count = (minutes % 5) / 1;
		for (int i = 0; i < count; i++) {
			this.clock.get(4).get(i).switchOn();
		}
	}

	@Override
	public String toString() {

		return this.clock.stream().map(e -> {
			return e.stream().map(l -> String.valueOf(ClockUtil.getStateOfLamp(l))).collect(Collectors.joining(""));
		}).collect(Collectors.joining(String.valueOf('\r') + String.valueOf('\n')));

	}

}
