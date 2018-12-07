package com.padmacareer.weather.json2java;

public class Wind {
	int chill;
	int direction;
	int speed;

	public Wind() {
		super();
	}

	public int getChill() {
		return chill;
	}

	public void setChill(int chill) {
		this.chill = chill;
	}

	@Override
	public String toString() {
		return String.format("Wind [chill=%s, direction=%s, speed=%s]", chill, direction, speed);
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
