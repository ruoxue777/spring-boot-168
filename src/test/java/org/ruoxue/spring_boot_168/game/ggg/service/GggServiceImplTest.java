package org.ruoxue.spring_boot_168.game.ggg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ruoxue.spring_boot_168.Application;
import org.ruoxue.spring_boot_168.game.ggg.model.GggReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class GggServiceImplTest {

	@Autowired
	private GggService service;

	@Test
	public void service() {
		System.out.println(service);
		assertNotNull(service);
	}

	@Test
	public void exist() throws Exception {
		boolean result = service.exist("ruoxue", "1111");
		System.out.println(result);
		assertFalse(result);
	}

	@Test
	public void login() {
		GggReponse gggReponse = service.login("ruoxue", "1111");
		System.out.println(gggReponse);
		assertEquals(0, gggReponse.getErrorCode());
	}
}
