package com.padmacareer.weather.json2java;

public class Results {
	Channel channel;

	public Results() {
		super();
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@Override
	public String toString() {
		return String.format("Results [channel=%s]", channel);
	}

}
