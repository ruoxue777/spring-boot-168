package org.ruoxue.spring_boot_168.sso.account.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ruoxue.spring_boot_168.Application;
import org.ruoxue.spring_boot_168.sso.account.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class AccountRepositoryTest {

	@Autowired
	private AccountRepository repository;

	@Test
	public void repository() {
		System.out.println(repository);
		assertNotNull(repository);
	}

	@Test
	public void insert() {
		String value = "ruoxue";
		Account found = repository.findByCid(value);
		if (found != null) {
			return;
		}

		Account account = new Account();
		account.setCid(value);
		account.setName("player");
		account.setPassword("");
		account.setSalt("");
		Account result = repository.save(account);
		System.out.println(result);
		assertNotNull(result);
		assertEquals(value, result.getCid());
	}

	@Test
	public void findByCid() {
		String value = "ruoxue";
		Account account = repository.findByCid(value);
		System.out.println(account);
		if (account != null) {
			assertEquals(value, account.getCid());
		}
	}

	@Test
	public void update() {
		String value = "ruoxue";
		String name = "test_player";
		Account account = repository.findByCid(value);
		if (account != null) {
			account.setName(name);
			Account updated = repository.save(account);
			System.out.println(account);
			assertEquals(name, updated.getName());
		}
	}

	@Test
	public void delete() {
		String value = "ruoxue";
		Account account = repository.findByCid(value);
		if (account != null) {
			repository.delete(account);
			System.out.println(account);
		}
	}
}
