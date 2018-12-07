package com.padmacareer.weather.soap;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.padmacareer.weather.Channel;
import com.padmacareer.weather.GetNorthEastWeatherDetailsRequest;
import com.padmacareer.weather.GetNorthEastWeatherDetailsResponse;
import com.padmacareer.weather.GetWeatherDetailsRequest;
import com.padmacareer.weather.GetWeatherDetailsResponse;
import com.padmacareer.weather.Results;
import com.padmacareer.weather.Weatherdetails;
import com.padmacareer.weather.Wind;
import com.padmacareer.weather.json2java.QueryRequest;

@Endpoint
public class YahooWeatherApp {
	private static Map<String, String> northEastCities = new LinkedHashMap<>();
	static {
		northEastCities.put("newyork city", "ny");
		northEastCities.put("philadelphia", "pa");
		northEastCities.put("washington", "dc");
		northEastCities.put("boston", "ma");
		northEastCities.put("baltimore", "md");
		northEastCities.put("providence", "ri");
		northEastCities.put("hartford", "ct");
	}
	private static final Logger log = LoggerFactory.getLogger(YahooWeatherApp.class);
	private static GetWeatherDetailsResponse response = new GetWeatherDetailsResponse();
	private static GetNorthEastWeatherDetailsResponse northEastresponse = new GetNorthEastWeatherDetailsResponse();
	private static RestTemplate restTemplate = new RestTemplate();

	@PayloadRoot(namespace = "http://padmacareer.com/weather", localPart = "GetWeatherDetailsRequest")
	@ResponsePayload
	public GetWeatherDetailsResponse processWeather(@RequestPayload GetWeatherDetailsRequest request) {
		QueryRequest weatherDetails = callYahooWeather(request.getCity(), request.getState());
		Weatherdetails wd = populateResponse(weatherDetails, request.getCity(), request.getState());
		response.setWeatherdetails(wd);
		return response;
	}

	@PayloadRoot(namespace = "http://padmacareer.com/weather", localPart = "GetNorthEastWeatherDetailsRequest")
	@ResponsePayload
	public GetNorthEastWeatherDetailsResponse processWeather(
			@RequestPayload GetNorthEastWeatherDetailsRequest request) {
		for (Map.Entry<String, String> loc : northEastCities.entrySet()) {

			QueryRequest weatherDetails = callYahooWeather(loc.getKey(), loc.getValue());
			Weatherdetails wd = populateResponse(weatherDetails, loc.getKey(), loc.getValue());
			northEastresponse.getWeatherdetails().add(wd);
		}
		return northEastresponse;
	}

	private static QueryRequest callYahooWeather(String city, String state) {

		String loc = city + "," + state;
		System.out.println("location : " + loc);
		QueryRequest weatherDetails = restTemplate.getForObject(
				"https://query.yahooapis.com/v1/public/yql?q=select wind from weather.forecast where woeid in (select woeid from geo.places(1) where text='"
						+ loc + "')&format=json",
				QueryRequest.class);
		if (weatherDetails.getQuery().getResults() == null)
			throw new LocationNotFoundException("Invalid city/state : " + loc);
		return weatherDetails;

		// log.info(query.toString());

	}

	private static Weatherdetails populateResponse(QueryRequest weatherDetails, String city, String state) {
		Weatherdetails weatherdata = new Weatherdetails();
		weatherdata.setCount(weatherDetails.getQuery().getCount());
		weatherdata.setCreated(weatherDetails.getQuery().getCreated());
		weatherdata.setLang(weatherDetails.getQuery().getLang());
		weatherdata.setCity(city);
		weatherdata.setState(state);
		weatherdata.setResults(populateResults(weatherDetails));
		return weatherdata;
	}

	private static Results populateResults(QueryRequest weatherDetails) {
		Results results = new Results();
		Channel channel = new Channel();
		Wind wind = new Wind();
		wind.setChill(weatherDetails.getQuery().getResults().getChannel().getWind().getChill());
		wind.setDirection(weatherDetails.getQuery().getResults().getChannel().getWind().getDirection());
		wind.setSpeed(weatherDetails.getQuery().getResults().getChannel().getWind().getSpeed());
		channel.setWind(wind);
		results.setChannel(channel);
		return results;
	}

}
