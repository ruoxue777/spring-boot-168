package org.ruoxue.spring_boot_168.game.ggg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ruoxue.spring_boot_168.Application;
import org.ruoxue.spring_boot_168.game.ggg.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class UserServiceImplTest {

	@Autowired
	private UserService service;

	@Test
	public void service() {
		System.out.println(service);
		assertNotNull(service);
	}

	@Test
	public void insert() {
		String value = "ruoxue";
		User found = service.findByCid(value);
		if (found != null) {
			return;
		}

		User user = new User();
		user.setCid(value);
		user.setName("player");
		user.setPassword("");
		user.setSalt("");
		User result = service.insert(user);
		System.out.println(result);
		assertNotNull(result);
		assertEquals(value, result.getCid());
	}

	@Test
	public void findByCid() {
		String value = "ruoxue";
		User user = service.findByCid(value);
		System.out.println(user);
		if (user != null) {
			assertEquals(value, user.getCid());
		}
	}

	@Test
	public void update() {
		String value = "ruoxue";
		String name = "test_player";
		User user = service.findByCid(value);
		if (user != null) {
			user.setName(name);
			User updated = service.update(user);
			System.out.println(user);
			assertEquals(name, updated.getName());
		}
	}

	@Test
	public void delete() {
		String value = "ruoxue";
		User user = service.findByCid(value);
		if (user != null) {
			service.delete(user);
			System.out.println(user);
		}
	}
}
