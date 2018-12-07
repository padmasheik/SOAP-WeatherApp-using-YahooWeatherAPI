package com.padmacareer.restfultemplate.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class YahooWeatherAppOriginal {

	private static final Logger log = LoggerFactory.getLogger(YahooWeatherAppOriginal.class);

	public static void main(String args[]) {
		RestTemplate restTemplate = new RestTemplate();

		// String city = "jerseycity,nj";
		System.out.println(restTemplate.getForObject(
				"https://query.yahooapis.com/v1/public/yql?q=select wind from weather.forecast where woeid in (select woeid from geo.places(1) where text='jersey city, nj')&format=json",
				QueryRequest.class));

		// log.info(query.toString());

	}

}
// QueryRequest [query=Query [count=1, created=2017-11-06T14:49:41Z, lang=en-US,
// results=Results [channel=Channel [item=null]]]]