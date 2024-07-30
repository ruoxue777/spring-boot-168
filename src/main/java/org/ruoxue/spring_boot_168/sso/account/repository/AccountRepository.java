package org.ruoxue.spring_boot_168.sso.account.repository;

import org.ruoxue.spring_boot_168.sso.account.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 帳號儲存庫
 */
public interface AccountRepository extends CrudRepository<Account, String>, PagingAndSortingRepository<Account, String> {

	/**
	 * 依cid取得帳號
	 * 
	 * @param cid
	 * @return
	 */
	Account findByCid(String cid);
}
