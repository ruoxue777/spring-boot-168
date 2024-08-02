package org.ruoxue.spring_boot_168.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

//@Configuration
@Slf4j
public class HttpClientRestTemplateConfig {

	@Autowired
	@Qualifier("closeableHttpClient")
	private CloseableHttpClient closeableHttpClient;

	@Bean(name = "httpComponentsClientHttpRequestFactory")
	public ClientHttpRequestFactory httpComponentsClientHttpRequestFactory() {
		return new HttpComponentsClientHttpRequestFactory(closeableHttpClient);
	}

	@Bean(name = "httpClientRestTemplate")
	public RestTemplate restTemplate(
			@Qualifier("httpComponentsClientHttpRequestFactory") ClientHttpRequestFactory clientHttpRequestFactory) {
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
