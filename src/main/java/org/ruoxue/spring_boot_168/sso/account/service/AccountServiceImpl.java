package org.ruoxue.spring_boot_168.sso.account.service;

import org.ruoxue.spring_boot_168.sso.account.ex.AccountException;
import org.ruoxue.spring_boot_168.sso.account.model.Account;
import org.ruoxue.spring_boot_168.sso.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

	/**
	 * 帳號儲存庫
	 */
	@Autowired
	private AccountRepository accountRepository;

	/**
	 * 帳號 TX
	 */
	@Autowired
	private AccountTX tx;

	public AccountServiceImpl() {
	}

	/**
	 * 新增帳號資料
	 * 
	 * @param account
	 * @return
	 */
	@Override
	public Account insertAccount(Account account) {
		Account result = null;
		try {
			if (account == null) {
				throw new AccountException("account 必須有值。");
			}
			result = insert(account);
		} catch (AccountException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new AccountException(ex);
		}
		return result;
	}

	/**
	 * 取得帳號資料
	 * 
	 * @param cid
	 * @return
	 */
	@Override
	public Account findByCid(String cid) {
		Account result = null;
		try {
			if (cid == null) {
				throw new AccountException("cid 必須有值。");
			}
			result = accountRepository.findByCid(cid);
		} catch (AccountException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new AccountException(ex);
		}
		return result;
	}

	/**
	 * 取得所有帳號資料
	 * 
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<Account> findAll(Pageable pageable) {
		Page<Account> result = null;
		try {
			if (pageable == null) {
				throw new AccountException("pageable 必須有值。");
			}
			result = accountRepository.findAll(pageable);
		} catch (AccountException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new AccountException(ex);
		}
		return result;
	}

	/**
	 * 修改帳號資料
	 * 
	 * @param account
	 * @return
	 */
	@Override
	public Account updateAccount(Account account) {
		Account result = null;
		try {
			if (account == null) {
				throw new AccountException("account 必須有值。");
			}
			result = update(account);
		} catch (AccountException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new AccountException(ex);
		}
		return result;
	}

	/**
	 * 刪除帳號資料
	 * 
	 * @param account
	 * @return
	 */
	@Override
	public int deleteAccount(Account account) {
		int result = 0;
		try {
			if (account == null) {
				throw new AccountException("account 必須有值。");
			}
			delete(account);
			result = 1;
		} catch (AccountException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new AccountException(ex);
		}
		return result;
	}

	/**
	 * 新增帳號
	 * 
	 * @param account
	 * @return
	 */
	@Override
	public Account insert(Account account) {
		Account result = null;
		try {
			result = tx.insert(account);
		} catch (AccountException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new AccountException(ex);
		}
		return result;
	}

	/**
	 * 更新帳號
	 * 
	 * @param account
	 * @return
	 */
	@Override
	public Account update(Account account) {
		Account result = null;
		try {
			result = tx.update(account);
		} catch (AccountException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new AccountException(ex);
		}
		return result;
	}

	/**
	 * 刪除帳號
	 * 
	 * @param account
	 */
	@Override
	public void delete(Account account) {
		try {
			tx.delete(account);
		} catch (AccountException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new AccountException(ex);
		}
	}
}
