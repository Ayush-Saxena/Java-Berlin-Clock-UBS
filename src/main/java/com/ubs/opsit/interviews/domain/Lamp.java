package com.ubs.opsit.interviews.domain;

public class Lamp {

	private boolean state;

	private char colour;

	public Lamp(char colour) {

		this.state = false; // initiallyOff
		this.colour = colour;

	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public char getColour() {
		return colour;
	}

	public void setColour(char colour) {
		this.colour = colour;
	}

	public void switchOn() {
		this.state = true;
	}

	public void switchOff() {
		this.state = false;

	}

}
