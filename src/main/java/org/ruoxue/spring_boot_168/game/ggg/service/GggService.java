package org.ruoxue.spring_boot_168.game.ggg.service;

import org.ruoxue.spring_boot_168.game.ggg.model.GggReponse;

public interface GggService {

	/**
	 * 使用者是否存在
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	boolean exist(String username, String password) throws Exception;

	/**
	 * 使用者登入
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	GggReponse login(String username, String password);
}
