package org.ruoxue.spring_boot_168.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ruoxue.spring_boot_168.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zaxxer.hikari.HikariConfig;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class DataSourceConfigTest {

	@Autowired
	private DataSourceConfig config;

	@Test
	public void config() {
		assertNotNull(config);
		HikariConfig hikariConfig = config.hikariConfig();
		String jdbcUrl = hikariConfig.getJdbcUrl();
		assertEquals("jdbc:mariadb://127.0.0.1:3306/spring_boot_168", jdbcUrl);
	}
}

