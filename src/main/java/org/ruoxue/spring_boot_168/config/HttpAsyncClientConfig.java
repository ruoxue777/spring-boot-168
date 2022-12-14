package org.ruoxue.spring_boot_168.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.nio.reactor.IOReactorException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@ConfigurationProperties("http-async-client")
@Configuration
@Slf4j
public class HttpAsyncClientConfig {

	@Value("${http-async-client.maxTotal}")
	private int maxTotal;

	@Value("${http-async-client.defaultMaxPerRoute}")
	private int defaultMaxPerRoute;

	@Value("${http-async-client.connectTimeout}")
	private int connectTimeout;

	@Value("${http-async-client.connectionRequestTimeout}")
	private int connectionRequestTimeout;

	@Value("${http-async-client.socketTimeout}")
	private int socketTimeout;

	@Value("${http-async-client.routeEnable}")
	private boolean routeEnable;

	private final List<Route> routeList = new ArrayList<>();

	@Bean(name = "poolingNHttpClientConnectionManager")
	public PoolingNHttpClientConnectionManager poolingNHttpClientConnectionManager() {
		IOReactorConfig ioReactorConfig = IOReactorConfig.custom()
				.setIoThreadCount(200 * Runtime.getRuntime().availableProcessors()) //
				.setSoKeepAlive(true) //
				.build();

		ConnectingIOReactor ioReactor = null;
		try {
			ioReactor = new DefaultConnectingIOReactor(ioReactorConfig);
		} catch (IOReactorException ex) {
			log.error(ex.getMessage(), ex);
		}

		PoolingNHttpClientConnectionManager connectionManager = new PoolingNHttpClientConnectionManager(ioReactor);
		connectionManager.setMaxTotal(maxTotal);
		connectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
		if (routeEnable) {
			routeList.forEach(e -> {
				connectionManager.setMaxPerRoute(new HttpRoute(new HttpHost(e.getHostname())), e.getMaxConnection());
			});
		}
		return connectionManager;
	}

	@Bean(name = "asyncRequestConfigBuilder")
	public RequestConfig.Builder asyncRequestConfigBuilder() {
		RequestConfig.Builder builder = RequestConfig.custom();
		return builder.setConnectTimeout(connectTimeout) //
				.setConnectionRequestTimeout(connectionRequestTimeout) //
				.setSocketTimeout(socketTimeout);
	}

	@Bean(name = "asyncRequestConfig")
	public RequestConfig requestConfig(@Qualifier("asyncRequestConfigBuilder") RequestConfig.Builder builder) {
		return builder.build();
	}

	@Bean(name = "asyncHttpClientBuilder")
	public HttpAsyncClientBuilder asyncHttpClientBuilder(
			@Qualifier("poolingNHttpClientConnectionManager") PoolingNHttpClientConnectionManager poolingNHttpClientConnectionManager,
			@Qualifier("asyncRequestConfig") RequestConfig requestConfig) {
		HttpAsyncClientBuilder httpAsyncClientBuilder = HttpAsyncClientBuilder.create();
		httpAsyncClientBuilder.setConnectionManager(poolingNHttpClientConnectionManager);

		httpAsyncClientBuilder.setDefaultRequestConfig(requestConfig);
		return httpAsyncClientBuilder;
	}

	@Bean(name = "closeableHttpAsyncClient")
	public CloseableHttpAsyncClient closeableHttpAsyncClient(
			@Qualifier("asyncHttpClientBuilder") HttpAsyncClientBuilder asyncHttpClientBuilder) {
		return asyncHttpClientBuilder.build();
	}

	public List<Route> getRouteList() {
		return routeList;
	}

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	@Setter
	@Builder
	public static class Route {
		/** IP or DNS name */
		private String hostname;
		/** 最大連線數 */
		private int maxConnection;

		@Override
		public String toString() {
			ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
			builder.appendSuper(super.toString());
			builder.append("hostname", hostname);
			builder.append("maxConnection", maxConnection);
			return builder.toString();
		}

	}
}
