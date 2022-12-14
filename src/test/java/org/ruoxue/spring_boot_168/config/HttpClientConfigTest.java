package org.ruoxue.spring_boot_168.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ruoxue.spring_boot_168.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class HttpClientConfigTest {

	@Autowired
	private HttpClientConfig config;

	@Test
	public void config() {
		assertNotNull(config);
		System.out.println("maxTotal: " + config.poolingHttpClientConnectionManager().getMaxTotal());
		System.out.println("routeList: " + config.getRouteList());
		assertEquals(3, config.getRouteList().size());
	}
}
