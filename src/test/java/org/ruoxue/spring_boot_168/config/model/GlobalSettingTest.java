package org.ruoxue.spring_boot_168.config.model;

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
public class GlobalSettingTest {

	@Autowired
	private GlobalSetting globalSetting;

	@Test
	public void globalSetting() {
		System.out.println(globalSetting);
		assertNotNull(globalSetting);
		int defaultPageSize = globalSetting.getDefaultPageSize();
		assertEquals(50, defaultPageSize);
		String tokenSecret = globalSetting.getTokenSecret();
		assertEquals("19816f04bf6089c0df8487871eb02d36", tokenSecret);
	}
}
