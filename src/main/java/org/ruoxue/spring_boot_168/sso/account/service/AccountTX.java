package org.ruoxue.spring_boot_168.sso.account.service;

import org.ruoxue.spring_boot_168.sso.account.model.Account;
import org.ruoxue.spring_boot_168.sso.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 帳號 TX
 */
@Component
public class AccountTX {

	/**
	 * 帳號儲存庫
	 */
	@Autowired
	private AccountRepository accountRepository;

	public AccountTX() {

	}

	/**
	 * TX
	 * 
	 * 新增帳號
	 * 
	 * @param account
	 * @return
	 */
	@Transactional
	public Account insert(Account account) {
		Account result = accountRepository.save(account);
		return result;
	}

	/**
	 * TX
	 * 
	 * 更新帳號
	 * 
	 * @param account
	 * @return
	 */
	@Transactional
	public Account update(Account account) {
		Account result = accountRepository.save(account);
		return result;
	}

	/**
	 * TX
	 * 
	 * 刪除帳號
	 * 
	 * @param account
	 */
	@Transactional
	public void delete(Account account) {
		accountRepository.delete(account);
	}
}
