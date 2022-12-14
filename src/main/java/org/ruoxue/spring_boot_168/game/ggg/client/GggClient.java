package org.ruoxue.spring_boot_168.game.ggg.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.ruoxue.commons.httpclient.HttpDeleteWithBody;
import org.ruoxue.spring_boot_168.game.ggg.ex.GggException;
import org.ruoxue.spring_boot_168.game.ggg.model.GggListReponse;
import org.ruoxue.spring_boot_168.game.ggg.model.GggReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GggClient {

	/** API 網址 */
	public static final String API_URL = "http://ggg.cc:10090";
	/** 使用者登入 */
	public static final String LOGIN = "/login";
	/** 使用者登出 */
	public static final String LOGOUT = "/logout";
	/** 使用者資訊 */
	public static final String USER = "/user";
	/** 使用者列表 */
	public static final String USERS = "/users";
	/** 使用者是否存在 */
	public static final String EXIST = "/exist";

	@Autowired
	@Qualifier("closeableHttpClient")
	private CloseableHttpClient httpClient;

	private static final Gson gson = new Gson();

	/**
	 * 新增使用者
	 * 
	 * Content-Type: application/json;charset=UTF-8
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public GggReponse create(String username, String password) throws Exception {
		GggReponse result = null;
		try {
			String requestUrl = API_URL + USER;
			HttpPost httpPost = new HttpPost(requestUrl);
			httpPost.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);

			JsonObject params = new JsonObject();
			params.addProperty("username", username);
			params.addProperty("password", password);

			StringEntity stringEntity = new StringEntity(params.toString(), "UTF-8");
			httpPost.setEntity(stringEntity);
			ResponseHandler<String> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();
				if (status >= HttpStatus.SC_OK && status < HttpStatus.SC_MULTIPLE_CHOICES) {
					HttpEntity entity = response.getEntity();
					return (entity != null ? EntityUtils.toString(entity) : null);
				} else {
					log.error("statusCode: " + status);
					log.error("statusLine: " + response.getStatusLine());
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			};
			log.info("requestUrl: " + requestUrl);
			String body = httpClient.execute(httpPost, responseHandler);
			if (StringUtils.isNotEmpty(body)) {
				result = gson.fromJson(body, GggReponse.class);
			} else {
				throw new GggException("ERRORS_NOT_EXIST");
			}
		} catch (Exception ex) {
			throw ex;
		}
		return result;
	}

	/**
	 * 使用者登入
	 * 
	 * Content-Type: application/json;charset=UTF-8
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public GggReponse login(String username, String password) throws Exception {
		GggReponse result = null;
		try {
			String requestUrl = API_URL + LOGIN;
			HttpPost httpPost = new HttpPost(requestUrl);
			httpPost.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);

			JsonObject params = new JsonObject();
			params.addProperty("username", username);
			params.addProperty("password", password);

			StringEntity stringEntity = new StringEntity(params.toString(), "UTF-8");
			httpPost.setEntity(stringEntity);
			ResponseHandler<String> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();
				if (status >= HttpStatus.SC_OK && status < HttpStatus.SC_MULTIPLE_CHOICES) {
					HttpEntity entity = response.getEntity();
					return (entity != null ? EntityUtils.toString(entity) : null);
				} else {
					log.error("statusCode: " + status);
					log.error("statusLine: " + response.getStatusLine());
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			};
			log.info("requestUrl: " + requestUrl);
			String body = httpClient.execute(httpPost, responseHandler);
			if (StringUtils.isNotEmpty(body)) {
				result = gson.fromJson(body, GggReponse.class);
			} else {
				throw new GggException("ERRORS_NOT_EXIST");
			}
		} catch (Exception ex) {
			throw ex;
		}
		return result;
	}

	/**
	 * 使用者登出
	 * 
	 * Content-Type: application/x-www-form-urlencoded
	 * 
	 * @param username
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public GggReponse logout(String username, String token) throws Exception {
		GggReponse result = null;
		try {
			String requestUrl = API_URL + LOGOUT;
			HttpPost httpPost = new HttpPost(requestUrl);
			httpPost.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);

			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("username", username));
			params.add(new BasicNameValuePair("token", token));

			UrlEncodedFormEntity urlEntity = new UrlEncodedFormEntity(params, Consts.UTF_8);
			httpPost.setEntity(urlEntity);
			ResponseHandler<String> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();
				if (status >= HttpStatus.SC_OK && status < HttpStatus.SC_MULTIPLE_CHOICES) {
					HttpEntity entity = response.getEntity();
					return (entity != null ? EntityUtils.toString(entity) : null);
				} else {
					log.error("statusCode: " + status);
					log.error("statusLine: " + response.getStatusLine());
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			};
			log.info("requestUrl: " + requestUrl);
			String body = httpClient.execute(httpPost, responseHandler);
			if (StringUtils.isNotEmpty(body)) {
				result = gson.fromJson(body, GggReponse.class);
			} else {
				throw new GggException("ERRORS_NOT_EXIST");
			}
		} catch (Exception ex) {
			throw ex;
		}
		return result;
	}

	/**
	 * 使用者資訊
	 * 
	 * Content-Type: application/x-www-form-urlencoded
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public GggReponse user(String username) throws Exception {
		GggReponse result = null;
		try {
			String requestUrl = API_URL + USER + "?username=" + username;
			HttpGet httpGet = new HttpGet(requestUrl);
			httpGet.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
			ResponseHandler<String> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();
				if (status >= HttpStatus.SC_OK && status < HttpStatus.SC_MULTIPLE_CHOICES) {
					HttpEntity entity = response.getEntity();
					return (entity != null ? EntityUtils.toString(entity) : null);
				} else {
					log.error("statusCode: " + status);
					log.error("statusLine: " + response.getStatusLine());
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			};
			log.info("requestUrl: " + requestUrl);
			String body = httpClient.execute(httpGet, responseHandler);
			if (StringUtils.isNotEmpty(body)) {
				result = gson.fromJson(body, GggReponse.class);
			} else {
				throw new GggException("ERRORS_NOT_EXIST");
			}
		} catch (Exception ex) {
			throw ex;
		}
		return result;
	}

	/**
	 * 使用者列表
	 * 
	 * Content-Type: application/x-www-form-urlencoded
	 * 
	 * @param page
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public GggListReponse users(int page, int size) throws Exception {
		GggListReponse result = null;
		try {
			String requestUrl = API_URL + USERS;
			URI uri = new URIBuilder(requestUrl) //
					.setParameter("page", String.valueOf(page)) //
					.setParameter("size", String.valueOf(size)) //
					.build();
			HttpGet httpGet = new HttpGet(uri);
			httpGet.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
			ResponseHandler<String> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();
				if (status >= HttpStatus.SC_OK && status < HttpStatus.SC_MULTIPLE_CHOICES) {
					HttpEntity entity = response.getEntity();
					return (entity != null ? EntityUtils.toString(entity) : null);
				} else {
					log.error("statusCode: " + status);
					log.error("statusLine: " + response.getStatusLine());
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			};
			log.info("requestUrl: " + requestUrl);
			String body = httpClient.execute(httpGet, responseHandler);
			if (StringUtils.isNotEmpty(body)) {
				result = gson.fromJson(body, GggListReponse.class);
			} else {
				throw new GggException("ERRORS_NOT_EXIST");
			}
		} catch (Exception ex) {
			throw ex;
		}
		return result;
	}

	/**
	 * 使用者是否存在
	 * 
	 * Content-Type: application/x-www-form-urlencoded
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public GggReponse exist(String username, String password) throws Exception {
		GggReponse result = null;
		try {
			String requestUrl = API_URL + EXIST + "?username=" + username + "&password=" + password;
			HttpGet httpGet = new HttpGet(requestUrl);
			httpGet.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
			ResponseHandler<String> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();
				if (status >= HttpStatus.SC_OK && status < HttpStatus.SC_MULTIPLE_CHOICES) {
					HttpEntity entity = response.getEntity();
					return (entity != null ? EntityUtils.toString(entity) : null);
				} else {
					log.error("statusCode: " + status);
					log.error("statusLine: " + response.getStatusLine());
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			};
			log.info("requestUrl: " + requestUrl);
			String body = httpClient.execute(httpGet, responseHandler);
			if (StringUtils.isNotEmpty(body)) {
				result = gson.fromJson(body, GggReponse.class);
			} else {
				throw new GggException("ERRORS_NOT_EXIST");
			}
		} catch (Exception ex) {
			throw ex;
		}
		return result;
	}

	/**
	 * 更新使用者
	 * 
	 * Content-Type: application/json;charset=UTF-8
	 * 
	 * @param username
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public GggReponse update(String username, String name) throws Exception {
		GggReponse result = null;
		try {
			String requestUrl = API_URL + USER;
			HttpPut httpPut = new HttpPut(requestUrl);
			httpPut.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
			JsonObject params = new JsonObject();
			params.addProperty("username", username);
			params.addProperty("name", name);
			StringEntity stringEntity = new StringEntity(params.toString(), "UTF-8");
			httpPut.setEntity(stringEntity);
			ResponseHandler<String> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();
				if (status >= HttpStatus.SC_OK && status < HttpStatus.SC_MULTIPLE_CHOICES) {
					HttpEntity entity = response.getEntity();
					return (entity != null ? EntityUtils.toString(entity) : null);
				} else {
					log.error("statusCode: " + status);
					log.error("statusLine: " + response.getStatusLine());
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			};
			log.info("requestUrl: " + requestUrl);
			String body = httpClient.execute(httpPut, responseHandler);
			if (StringUtils.isNotEmpty(body)) {
				result = gson.fromJson(body, GggReponse.class);
			} else {
				throw new GggException("ERRORS_NOT_EXIST");
			}

		} catch (Exception ex) {
			throw ex;
		}
		return result;
	}

	/**
	 * 刪除使用者
	 * 
	 * Content-Type: application/json;charset=UTF-8
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public GggReponse delete(String username) throws Exception {
		GggReponse result = null;
		try {
			String requestUrl = API_URL + USER;
			HttpDeleteWithBody httpDelete = new HttpDeleteWithBody(requestUrl);
			httpDelete.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
			JsonObject params = new JsonObject();
			params.addProperty("username", username);
			StringEntity stringEntity = new StringEntity(params.toString(), "UTF-8");
			httpDelete.setEntity(stringEntity);
			ResponseHandler<String> responseHandler = response -> {
				int status = response.getStatusLine().getStatusCode();
				if (status >= HttpStatus.SC_OK && status < HttpStatus.SC_MULTIPLE_CHOICES) {
					HttpEntity entity = response.getEntity();
					return (entity != null ? EntityUtils.toString(entity) : null);
				} else {
					log.error("statusCode: " + status);
					log.error("statusLine: " + response.getStatusLine());
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			};
			log.info("requestUrl: " + requestUrl);
			String body = httpClient.execute(httpDelete, responseHandler);
			if (StringUtils.isNotEmpty(body)) {
				result = gson.fromJson(body, GggReponse.class);
			} else {
				throw new GggException("ERRORS_NOT_EXIST");
			}

		} catch (Exception ex) {
			throw ex;
		}
		return result;
	}
}
