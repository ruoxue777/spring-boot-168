package org.ruoxue.spring_boot_168.game.ggg.model;

import java.net.URI;

import javax.annotation.concurrent.NotThreadSafe;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

@NotThreadSafe
public class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
	public static final String METHOD_NAME = "DELETE";

	public HttpDeleteWithBody(final String uri) {
		super();
		setURI(URI.create(uri));
	}

	public HttpDeleteWithBody(final URI uri) {
		super();
		setURI(uri);
	}

	public HttpDeleteWithBody() {
		super();
	}

	public String getMethod() {
		return METHOD_NAME;
	}

}
