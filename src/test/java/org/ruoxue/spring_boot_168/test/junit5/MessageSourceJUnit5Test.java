package org.ruoxue.spring_boot_168.test.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Locale;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ruoxue.spring_boot_168.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class MessageSourceJUnit5Test {

	@Autowired
	private MessageSource messageSource;

	@Test
	public void getMessage_zh_TW() {
		String name = messageSource.getMessage("spring-boot-168.contact.name", (Object[]) null,
				Locale.TRADITIONAL_CHINESE);
		System.out.println("name: " + name);
		assertEquals("若雪", name);

		String url = messageSource.getMessage("spring-boot-168.contact.url", (Object[]) null,
				Locale.TRADITIONAL_CHINESE);
		System.out.println("url: " + url);
		assertEquals("https://www.ruoxue.org", url);

		String email = messageSource.getMessage("spring-boot-168.contact.email", (Object[]) null,
				Locale.TRADITIONAL_CHINESE);
		System.out.println("email: " + email);
		assertEquals("ruoxueorg@gmail.com", email);
	}

	@Test
	public void getMessage_en_US() {
		String name = messageSource.getMessage("spring-boot-168.contact.name", (Object[]) null, Locale.US);
		System.out.println("name: " + name);
		assertEquals("Ruoxue", name);

		String url = messageSource.getMessage("spring-boot-168.contact.url", (Object[]) null, Locale.US);
		System.out.println("url: " + url);
		assertEquals("https://www.ruoxue.org", url);

		String email = messageSource.getMessage("spring-boot-168.contact.email", (Object[]) null, Locale.US);
		System.out.println("email: " + email);
		assertEquals("ruoxueorg@gmail.com", email);
	}
	
	@Test
	public void getMessage_zh_CN() {
		String name = messageSource.getMessage("spring-boot-168.contact.name", (Object[]) null,
				Locale.SIMPLIFIED_CHINESE);
		System.out.println("name: " + name);
		assertEquals("若雪", name);

		String url = messageSource.getMessage("spring-boot-168.contact.url", (Object[]) null,
				Locale.SIMPLIFIED_CHINESE);
		System.out.println("url: " + url);
		assertEquals("https://www.ruoxue.org", url);

		String email = messageSource.getMessage("spring-boot-168.contact.email", (Object[]) null,
				Locale.SIMPLIFIED_CHINESE);
		System.out.println("email: " + email);
		assertEquals("ruoxueorg@gmail.com", email);
	}
}
