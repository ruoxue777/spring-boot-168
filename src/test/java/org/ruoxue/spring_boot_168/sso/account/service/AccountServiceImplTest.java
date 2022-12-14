package org.ruoxue.spring_boot_168.sso.account.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ruoxue.spring_boot_168.Application;
import org.ruoxue.spring_boot_168.sso.account.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
public class AccountServiceImplTest {

	@Autowired
	private AccountService service;

	@Test
	public void service() {
		System.out.println(service);
		assertNotNull(service);
	}

	@Test
	public void insertAccount() {
		Account account = new Account();
		account.setCid("ruoxue");
		account.setName("player");
		account.setPassword("1111");
		Account result = service.insertAccount(account);
		System.out.println(result);
		assertNotNull(result);
	}

	@Test
	public void findByCid() {
		Account result = service.findByCid("ruoxue");
		System.out.println(result);
		assertNotNull(result);
	}

	@Test
	public void findAll() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<Account> result = service.findAll(pageable);
		System.out.println(result);
		assertNotNull(result);
	}

	@Test
	public void updateAccount() {
		Account account = new Account();
		account.setCid("ruoxue");
		account.setName("player");
		Account result = service.updateAccount(account);
		System.out.println(result);
		assertNotNull(result);
	}

	@Test
	public void deleteAccount() {
		Account account = new Account();
		account.setCid("ruoxue");
		int result = service.deleteAccount(account);
		System.out.println(result);
		assertTrue(result > 0);
	}
}
