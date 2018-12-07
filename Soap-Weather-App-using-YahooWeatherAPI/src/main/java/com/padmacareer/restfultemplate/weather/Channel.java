package com.padmacareer.restfultemplate.weather;

public class Channel {
	Wind wind;

	public Channel() {

	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	@Override
	public String toString() {
		return String.format("Channel [wind=%s]", wind);
	}

}
