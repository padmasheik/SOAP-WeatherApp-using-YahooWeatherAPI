//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.12.07 at 10:01:53 AM EST 
//


package com.padmacareer.weather;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.padmacareer.weather package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.padmacareer.weather
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetNorthEastWeatherDetailsResponse }
     * 
     */
    public GetNorthEastWeatherDetailsResponse createGetNorthEastWeatherDetailsResponse() {
        return new GetNorthEastWeatherDetailsResponse();
    }

    /**
     * Create an instance of {@link Weatherdetails }
     * 
     */
    public Weatherdetails createWeatherdetails() {
        return new Weatherdetails();
    }

    /**
     * Create an instance of {@link GetWeatherDetailsRequest }
     * 
     */
    public GetWeatherDetailsRequest createGetWeatherDetailsRequest() {
        return new GetWeatherDetailsRequest();
    }

    /**
     * Create an instance of {@link GetNorthEastWeatherDetailsRequest }
     * 
     */
    public GetNorthEastWeatherDetailsRequest createGetNorthEastWeatherDetailsRequest() {
        return new GetNorthEastWeatherDetailsRequest();
    }

    /**
     * Create an instance of {@link GetWeatherDetailsResponse }
     * 
     */
    public GetWeatherDetailsResponse createGetWeatherDetailsResponse() {
        return new GetWeatherDetailsResponse();
    }

    /**
     * Create an instance of {@link Channel }
     * 
     */
    public Channel createChannel() {
        return new Channel();
    }

    /**
     * Create an instance of {@link Results }
     * 
     */
    public Results createResults() {
        return new Results();
    }

    /**
     * Create an instance of {@link Wind }
     * 
     */
    public Wind createWind() {
        return new Wind();
    }

}
