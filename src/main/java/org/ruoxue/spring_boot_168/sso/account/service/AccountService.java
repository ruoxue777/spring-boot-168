package org.ruoxue.spring_boot_168.sso.account.service;

import org.ruoxue.spring_boot_168.sso.account.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 帳號服務
 */
public interface AccountService {

	/**
	 * 新增帳號資料
	 * 
	 * @param account
	 * @return
	 */
	Account insertAccount(Account account);

	/**
	 * 取得帳號資料
	 * 
	 * @param cid
	 * @return
	 */
	Account findByCid(String cid);

	/**
	 * 取得所有帳號資料
	 * 
	 * @param pageable
	 * @return
	 */
	Page<Account> findAll(Pageable pageable);

	/**
	 * 修改帳號資料
	 * 
	 * @param account
	 * @return
	 */
	Account updateAccount(Account account);

	/**
	 * 刪除帳號資料
	 * 
	 * @param account
	 * @return
	 */
	int deleteAccount(Account account);

	/**
	 * 新增帳號
	 * 
	 * @param account
	 * @return
	 */
	Account insert(Account account);

	/**
	 * 更新帳號
	 * 
	 * @param account
	 * @return
	 */
	Account update(Account account);

	/**
	 * 刪除帳號
	 * 
	 * @param account
	 */
	void delete(Account account);
}
