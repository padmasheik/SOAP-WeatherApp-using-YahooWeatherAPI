package com.padmacareer.restfultemplate.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String args[]) {
		RestTemplate restTemplate = new RestTemplate();

		/*
		 * System.out.println(restTemplate.getForObject(
		 * "http://api.openweathermap.org/data/2.5/weather?q={city name},{country code}&appid=8f0eba923611eccda9579490a243dcd9"
		 * , Object.class, "London", "uk")); // log.info(quote);
		 * 
		 */
		String city = "orlando, fl";
		/*
		 * System.out.println(restTemplate.getForObject(
		 * "https://query.yahooapis.com/v1/public/yql?q=select wind from weather.forecast where woeid in (select woeid from geo.places(1) where text='orlando,fl')&format=json"
		 * , Object.class));
		 */
		/*
		 * working System.out.println(restTemplate.getForObject(
		 * "https://query.yahooapis.com/v1/public/yql?q=select wind,location from weather.forecast where woeid in (select woeid from geo.places(1) where text='$[city]')&format=json"
		 * , Object.class));
		 */
		System.out.println(restTemplate.getForObject(
				"https://query.yahooapis.com/v1/public/yql?q=select wind,location from weather.forecast where woeid in (select woeid from geo.places(1) where text='"
						+ city + "')&format=json",
				Object.class));
		// System.out.println(restTemplate.getForObject(
		// "https://query.yahooapis.com/v1/public/yql?q=select wind from
		// weather.forecast where woeid in (select woeid from geo.places(1)
		// where text='orlando,fl'",Object.class));

		/*
		 * System.out.println(restTemplate.getForObject(
		 * "https://query.yahooapis.com/v1/public/yql?q=select%20item.condition.text%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22dallas%2C%20tx%22)&format=json",
		 * Object.class));
		 */

		// log.info(quote);

	}

}
// {city name},{country code}
// or example, to get weather for Yahoo! Headquarters in Sunnyvale, CA, use the
// WOEID code for Sunnyvale (2502265):
// https://weather-ydn-yql.media.yahoo.com/forecastrss?w=2502265
// https://query.yahooapis.com/v1/public/yql?q=select%20item.condition.text%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22dallas%2C%20tx%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys
