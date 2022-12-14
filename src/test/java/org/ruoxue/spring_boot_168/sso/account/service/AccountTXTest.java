package org.ruoxue.spring_boot_168.sso.account.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ruoxue.spring_boot_168.Application;
import org.ruoxue.spring_boot_168.sso.account.model.Account;
import org.ruoxue.spring_boot_168.sso.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class AccountTXTest {

	@Autowired
	private AccountRepository repository;

	@Autowired
	private AccountTX tx;

	@Test
	public void service() {
		System.out.println(tx);
		assertNotNull(tx);
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
		Account result = tx.insert(account);
		System.out.println(result);
		assertNotNull(result);
		assertEquals(value, result.getCid());
	}

	@Test
	public void update() {
		String value = "ruoxue";
		String name = "test_player";
		Account account = repository.findByCid(value);
		if (account != null) {
			account.setName(name);
			Account updated = tx.update(account);
			System.out.println(account);
			assertEquals(name, updated.getName());
		}
	}

	@Test
	public void delete() {
		String value = "ruoxue";
		Account account = repository.findByCid(value);
		if (account != null) {
			tx.delete(account);
			System.out.println(account);
		}
	}
}
