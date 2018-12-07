package com.padmacareer.weather.soap;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.xwss.XwsSecurityInterceptor;
import org.springframework.ws.soap.security.xwss.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs // to enable spring web services
@Configuration // to mention this is spring configuration file
public class WeatherAppConfiguration extends WsConfigurerAdapter {
	// messageDispatcherServlet is specifically for soap messages(request and
	// response)
	// and identifies endpoint
	@Bean
	public ServletRegistrationBean msgDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet msgDispServlet = new MessageDispatcherServlet();
		msgDispServlet.setApplicationContext(context);
		msgDispServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(msgDispServlet, "/ws/*");

	}

	@Bean(name = "weather")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema yahooWeatherSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("WeatherPort");
		definition.setTargetNamespace("http://padmacareer.com/weather");
		definition.setLocationUri("/ws");
		definition.setSchema(yahooWeatherSchema);
		return definition;
	}

	@Bean
	public XsdSchema yahooWeatherSchema() {
		return new SimpleXsdSchema(new ClassPathResource("yahooweather.xsd"));
	}

	@Bean
	public XwsSecurityInterceptor securityInterceptor() {
		XwsSecurityInterceptor securityInterceptor = new XwsSecurityInterceptor();
		securityInterceptor.setCallbackHandler(callbackHandler());
		securityInterceptor.setPolicyConfiguration(new ClassPathResource("securityPolicy.xml"));
		return securityInterceptor;
	}

	private SimplePasswordValidationCallbackHandler callbackHandler() {
		SimplePasswordValidationCallbackHandler handler = new SimplePasswordValidationCallbackHandler();
		handler.setUsersMap(Collections.singletonMap("user", "password"));
		return handler;
	}

	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		interceptors.add(securityInterceptor());
	}
}
