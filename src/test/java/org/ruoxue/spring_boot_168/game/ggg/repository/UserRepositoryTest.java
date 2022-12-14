package org.ruoxue.spring_boot_168.game.ggg.repository;

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
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;

	@Test
	public void repository() {
		System.out.println(repository);
		assertNotNull(repository);
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
		User result = repository.save(user);
		System.out.println(result);
		assertNotNull(result);
		assertEquals(value, result.getCid());
	}

	@Test
	public void findByCid() {
		String value = "ruoxue";
		User user = repository.findByCid(value);
		System.out.println(user);
		if (user != null) {
			assertEquals(value, user.getCid());
		}
	}

	@Test
	public void update() {
		String value = "ruoxue";
		String name = "test_player";
		User user = repository.findByCid(value);
		if (user != null) {
			user.setName(name);
			User updated = repository.save(user);
			System.out.println(user);
			assertEquals(name, updated.getName());
		}
	}

	@Test
	public void delete() {
		String value = "ruoxue";
		User user = repository.findByCid(value);
		if (user != null) {
			repository.delete(user);
			System.out.println(user);
		}
	}
}
