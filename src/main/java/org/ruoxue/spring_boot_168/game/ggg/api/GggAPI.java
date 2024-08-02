package org.ruoxue.spring_boot_168.game.ggg.api;

import java.util.Locale;

import org.ruoxue.spring_boot_168.game.ggg.ex.GggException;
import org.ruoxue.spring_boot_168.game.ggg.model.GggReponse;
import org.ruoxue.spring_boot_168.game.ggg.service.GggService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

//@RestController
@Slf4j
public class GggAPI {

	@Autowired
	private GggService gggService;

	public GggAPI() {
	}

	/**
	 * 使用者是否存在
	 * 
	 * @param webRequest
	 * @param locale
	 * @param username
	 * @param password
	 * @return
	 */
	@GetMapping(value = { "/api/ggg/user/exist" })
	public ResponseEntity<GggReponse> exist(WebRequest webRequest, Locale locale, @RequestParam String username,
			@RequestParam String password) {
		ResponseEntity<GggReponse> result = null;
		//
		try {
			boolean ret = gggService.exist(username, password);
			GggReponse gggReponse = new GggReponse();
			gggReponse.setErrorCode(0);
			gggReponse.setExist(ret);
			result = ResponseEntity.ok().body(gggReponse);
		} catch (GggException ex) {
			log.error(ex.getMessage(), ex);
			result = ResponseEntity.notFound().build();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result = ResponseEntity.notFound().build();
		}
		return result;
	}

	/**
	 * 使用者登入
	 * 
	 * @param webRequest
	 * @param locale
	 * @param username
	 * @param password
	 * @return
	 */
	@PostMapping(value = { "/api/ggg/user/login" })
	public ResponseEntity<GggReponse> login(WebRequest webRequest, Locale locale, @RequestParam String username,
			@RequestParam String password) {
		ResponseEntity<GggReponse> result = null;
		//
		try {
			GggReponse ret = gggService.login(username, password);
			result = ResponseEntity.ok().body(ret);
		} catch (GggException ex) {
			log.error(ex.getMessage(), ex);
			result = ResponseEntity.notFound().build();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			result = ResponseEntity.notFound().build();
		}
		return result;
	}
}
