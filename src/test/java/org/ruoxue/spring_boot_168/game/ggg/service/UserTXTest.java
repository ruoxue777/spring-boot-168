package org.ruoxue.spring_boot_168.game.ggg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ruoxue.spring_boot_168.Application;
import org.ruoxue.spring_boot_168.game.ggg.model.User;
import org.ruoxue.spring_boot_168.game.ggg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class UserTXTest {

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserTX tx;

	@Test
	public void service() {
		System.out.println(tx);
		assertNotNull(tx);
	}

	@Test
	public void insert() {
		String value = "ruoxue";
		User found = repository.findByCid(value);
		if (found != null) {
			return;
		}

		User user = new User();
		user.setCid(value);
		user.setName("player");
		user.setPassword("");
		user.setSalt("");
		User result = tx.insert(user);
		System.out.println(result);
		assertNotNull(result);
		assertEquals(value, result.getCid());
	}

	@Test
	public void update() {
		String value = "ruoxue";
		String name = "test_player";
		User user = repository.findByCid(value);
		if (user != null) {
			user.setName(name);
			User updated = tx.update(user);
			System.out.println(user);
			assertEquals(name, updated.getName());
		}
	}

	@Test
	public void delete() {
		String value = "ruoxue";
		User user = repository.findByCid(value);
		if (user != null) {
			tx.delete(user);
			System.out.println(user);
		}
	}
}
