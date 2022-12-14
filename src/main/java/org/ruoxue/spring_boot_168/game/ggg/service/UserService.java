package org.ruoxue.spring_boot_168.game.ggg.service;

import org.ruoxue.spring_boot_168.game.ggg.model.User;

/**
 * 使用者服務
 */
public interface UserService {

	/**
	 * 新增使用者
	 * 
	 * @param user
	 * @return
	 */
	User insert(User user);

	/**
	 * 依帳號取得使用者
	 * 
	 * @param cid
	 * @return
	 */
	User findByCid(String cid);

	/**
	 * 更新使用者
	 * 
	 * @param user
	 * @return
	 */
	User update(User user);

	/**
	 * 刪除使用者
	 * 
	 * @param user
	 */
	void delete(User user);
}
