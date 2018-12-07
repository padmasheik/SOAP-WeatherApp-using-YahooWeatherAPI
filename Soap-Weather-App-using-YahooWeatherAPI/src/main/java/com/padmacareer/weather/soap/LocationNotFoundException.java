package com.padmacareer.weather.soap;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM, customFaultCode = "{http://padmacareer.com/weather}001_Location_Not_Found")
public class LocationNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LocationNotFoundException(String message) {
		super(message);

	}

}
