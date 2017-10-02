package com.ubs.opsit.interviews.domain;

public class Lamp {

	private boolean state;

	private Colour colour;

	public Lamp(Colour colour) {

		this.state = false; // initiallyOff
		this.colour = colour;

	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public void switchOn() {
		this.state = true;
	}

	public void switchOff() {
		this.state = false;

	}

}
