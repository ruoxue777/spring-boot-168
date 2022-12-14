package org.ruoxue.spring_boot_168.sso.account.api;

import java.util.Locale;

import org.ruoxue.spring_boot_168.sso.account.ex.AccountException;
import org.ruoxue.spring_boot_168.sso.account.model.Account;
import org.ruoxue.spring_boot_168.sso.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AccountAPI {

	@Autowired
	private AccountService service;

	private static final Gson gson = new Gson();

	public AccountAPI() {
	}

	/**
	 * 新增帳號資料
	 * 
	 * @param webRequest
	 * @param locale
	 * @param jsonParam
	 * @return
	 */
	@PostMapping(value = { "/api/sso/account" })
	public ResponseEntity<Account> insert(WebRequest webRequest, Locale locale, @RequestBody String jsonParam) {
		ResponseEntity<Account> result = null;
		try {
			Account account = service.insertAccount(gson.fromJson(jsonParam, Account.class));
			result = ResponseEntity.ok().body(account);
		} catch (AccountException ex) {
			log.error(ex.getMessage(), ex);
			result = ResponseEntity.notFound().build();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result = ResponseEntity.notFound().build();
		}
		return result;
	}

	/**
	 * 取得帳號資料
	 * 
	 * @param webRequest
	 * @param locale
	 * @param cid
	 * @return
	 */
	@GetMapping(value = { "/api/sso/account/cid/{cid}" })
	public ResponseEntity<Account> findByCid(WebRequest webRequest, Locale locale, @PathVariable String cid) {
		ResponseEntity<Account> result = null;
		try {
			Account account = service.findByCid(cid);
			result = ResponseEntity.ok().body(account);
		} catch (AccountException ex) {
			log.error(ex.getMessage(), ex);
			result = ResponseEntity.notFound().build();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result = ResponseEntity.notFound().build();
		}
		return result;
	}

	/**
	 * 取得所有帳號資料
	 * 
	 * @param webRequest
	 * @param locale
	 * @param cid
	 * @return
	 */
	@GetMapping(value = { "/api/sso/accounts" })
	public ResponseEntity<Page<Account>> findAll(WebRequest webRequest, Locale locale, Pageable pageable,
			@RequestParam int page, @RequestParam int size) {
		ResponseEntity<Page<Account>> result = null;
		try {
			Page<Account> accounts = service.findAll(pageable);
			result = ResponseEntity.ok().body(accounts);
		} catch (AccountException ex) {
			log.error(ex.getMessage(), ex);
			result = ResponseEntity.notFound().build();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result = ResponseEntity.notFound().build();
		}
		return result;
	}

	/**
	 * 修改帳號資料
	 * 
	 * @param webRequest
	 * @param locale
	 * @param name
	 * @return
	 */
	@PutMapping(value = { "/api/sso/account/cid/{cid}" })
	public ResponseEntity<Account> update(WebRequest webRequest, Locale locale, @PathVariable String cid,
			@RequestParam String name) {
		ResponseEntity<Account> result = null;
		try {
			Account account = new Account();
			account.setCid(cid);
			account.setName(name);
			Account ret = service.updateAccount(account);
			result = ResponseEntity.ok().body(ret);
		} catch (AccountException ex) {
			log.error(ex.getMessage(), ex);
			result = ResponseEntity.notFound().build();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result = ResponseEntity.notFound().build();
		}
		return result;
	}

	/**
	 * 刪除帳號資料
	 * 
	 * @param webRequest
	 * @param locale
	 * @return
	 */
	@DeleteMapping(value = { "/api/sso/account/cid/{cid}" })
	public ResponseEntity<Integer> delete(WebRequest webRequest, Locale locale, @PathVariable String cid) {
		ResponseEntity<Integer> result = null;
		try {
			Account account = new Account();
			account.setCid(cid);
			int ret = service.deleteAccount(account);
			result = ResponseEntity.ok().body(ret);
		} catch (AccountException ex) {
			log.error(ex.getMessage(), ex);
			result = ResponseEntity.notFound().build();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result = ResponseEntity.notFound().build();
		}
		return result;
	}
}
