package org.ruoxue.spring_boot_168.game.ggg.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ruoxue.spring_boot_168.Application;
import org.ruoxue.spring_boot_168.game.ggg.model.GggListReponse;
import org.ruoxue.spring_boot_168.game.ggg.model.GggReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class GggClientTest {

	@Autowired
	private GggClient client;

	@Test
	public void gggClient() {
		System.out.println(client);
		assertNotNull(client);
	}

	@Test
	public void create() throws Exception {
		GggReponse gggReponse = client.create("ruoxue", "1111");
		System.out.println(gggReponse);
		assertNotNull(gggReponse);
		assertEquals(0, gggReponse.getErrorCode());
	}

	
	@Test
	public void login() throws Exception {
		GggReponse gggReponse = client.login("ruoxue", "1111");
		System.out.println(gggReponse);
		assertNotNull(gggReponse);
		assertEquals(0, gggReponse.getErrorCode());
		assertEquals("0x12345678", gggReponse.getToken());
	}

	@Test
	public void logout() throws Exception {
		GggReponse gggReponse = client.logout("ruoxue", "0x12345678");
		System.out.println(gggReponse);
		assertNotNull(gggReponse);
		assertEquals(0, gggReponse.getErrorCode());
	}

	@Test
	public void user() throws Exception {
		GggReponse gggReponse = client.user("ruoxue");
		System.out.println(gggReponse);
		assertNotNull(gggReponse);
		assertEquals(0, gggReponse.getErrorCode());
	}

	@Test
	public void users() throws Exception {
		GggListReponse gggListReponse = client.users(0, 10);
		System.out.println(gggListReponse);
		assertNotNull(gggListReponse);
		assertEquals(0, gggListReponse.getErrorCode());
		assertEquals(2, gggListReponse.getNames().size());
	}

	@Test
	public void exist() throws Exception {
		GggReponse gggReponse = client.exist("ruoxue","1111");
		System.out.println(gggReponse);
		assertNotNull(gggReponse);
		assertFalse(gggReponse.isExist());
	}

	@Test
	public void update() throws Exception {
		GggReponse gggReponse = client.update("ruoxue", "player");
		System.out.println(gggReponse);
		assertNotNull(gggReponse);
		assertEquals(0, gggReponse.getErrorCode());
	}

	@Test
	public void delete() throws Exception {
		GggReponse gggReponse = client.delete("ruoxue");
		System.out.println(gggReponse);
		assertNotNull(gggReponse);
		assertEquals(0, gggReponse.getErrorCode());
	}
}
