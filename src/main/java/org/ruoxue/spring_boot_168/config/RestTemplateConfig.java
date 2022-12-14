package org.ruoxue.spring_boot_168.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class RestTemplateConfig {

	@Value("${http-client.connectTimeout}")
	private int connectTimeout;

	@Value("${http-client.socketTimeout}")
	private int socketTimeout;

	@Bean(name = "simpleClientHttpRequestFactory")
	public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
		SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		simpleClientHttpRequestFactory.setConnectTimeout(connectTimeout);
		simpleClientHttpRequestFactory.setReadTimeout(socketTimeout);
		log.info("connectTimeout: ", connectTimeout);
		log.info("socketTimeout: ", socketTimeout);
		return simpleClientHttpRequestFactory;
	}

	@Bean(name = "restTemplate")
	public RestTemplate restTemplate(
			@Qualifier("simpleClientHttpRequestFactory") ClientHttpRequestFactory clientHttpRequestFactory) {
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		restTemplate.getMessageConverters().add(new TextHttpMessageConverter());
		return restTemplate;
	}

	public class TextHttpMessageConverter extends MappingJackson2HttpMessageConverter {
		public TextHttpMessageConverter() {
			List<MediaType> mediaTypes = new ArrayList<>();
			mediaTypes.add(MediaType.TEXT_PLAIN);
			mediaTypes.add(MediaType.TEXT_HTML);
			setSupportedMediaTypes(mediaTypes);
		}
	}
}
