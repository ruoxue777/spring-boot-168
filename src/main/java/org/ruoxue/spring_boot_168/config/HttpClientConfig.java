package org.ruoxue.spring_boot_168.config;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLException;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
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

@ConfigurationProperties("http-client")
@Configuration
@Slf4j
public class HttpClientConfig {

	@Value("${http-client.maxTotal}")
	private int maxTotal;

	@Value("${http-client.defaultMaxPerRoute}")
	private int defaultMaxPerRoute;

	@Value("${http-client.connectTimeout}")
	private int connectTimeout;

	@Value("${http-client.connectionRequestTimeout}")
	private int connectionRequestTimeout;

	@Value("${http-client.socketTimeout}")
	private int socketTimeout;

	@Value("${http-client.validateAfterInactivity}")
	private int validateAfterInactivity;

	@Value("${http-client.retryEnable}")
	private boolean retryEnable;

	@Value("${http-client.retryCount}")
	private int retryCount;

	@Value("${http-client.retryInterval}")
	private int retryInterval;

	@Value("${http-client.routeEnable}")
	private boolean routeEnable;

	private final List<Route> routeList = new ArrayList<>();

	@Bean(name = "poolingHttpClientConnectionManager")
	public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager() {
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		connectionManager.setMaxTotal(maxTotal);
		connectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
		connectionManager.setValidateAfterInactivity(validateAfterInactivity);
		if (routeEnable) {
			routeList.forEach(e -> {
				connectionManager.setMaxPerRoute(new HttpRoute(new HttpHost(e.getHostname())), e.getMaxConnection());
			});
		}
		return connectionManager;
	}

	@Bean(name = "requestConfigBuilder")
	public RequestConfig.Builder requestConfigBuilder() {
		RequestConfig.Builder builder = RequestConfig.custom();
		return builder.setConnectTimeout(connectTimeout) //
				.setConnectionRequestTimeout(connectionRequestTimeout) //
				.setSocketTimeout(socketTimeout);
	}

	@Bean(name = "requestConfig")
	public RequestConfig requestConfig(@Qualifier("requestConfigBuilder") RequestConfig.Builder builder) {
		return builder.build();
	}

	@Bean(name = "httpClientBuilder")
	public HttpClientBuilder httpClientBuilder(
			@Qualifier("poolingHttpClientConnectionManager") PoolingHttpClientConnectionManager poolingHttpClientConnectionManager,
			@Qualifier("requestConfig") RequestConfig requestConfig) {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager);

		if (retryEnable) {
			DefaultHttpRequestRetryHandler requestRetryHandler = new DefaultHttpRequestRetryHandler(retryCount, true,
					new ArrayList<>()) {
				public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
					log.info("Retry request, execution count: {}, exception: {}", executionCount, exception);
					if (exception instanceof SocketTimeoutException) {
						return false;
					}

					if (exception instanceof UnknownHostException) {
						return false;
					}

					if (exception instanceof SSLException) {
						return false;
					}
					if (executionCount >= retryCount) {
						return false;
					}
					try {
						Thread.sleep(retryInterval);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						return false;
					}
					return super.retryRequest(exception, executionCount, context);
				}
			};
			httpClientBuilder.setRetryHandler(requestRetryHandler);
		}

		httpClientBuilder.setDefaultRequestConfig(requestConfig);
		return httpClientBuilder;
	}

	@Bean(name = "closeableHttpClient")
	public CloseableHttpClient closeableHttpClient(
			@Qualifier("httpClientBuilder") HttpClientBuilder httpClientBuilder) {
		return httpClientBuilder.build();
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
