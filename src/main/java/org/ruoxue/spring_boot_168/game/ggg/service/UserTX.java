package org.ruoxue.spring_boot_168.game.ggg.service;

import org.ruoxue.spring_boot_168.game.ggg.model.User;
import org.ruoxue.spring_boot_168.game.ggg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * 使用者 TX
 */
@Component
public class UserTX {

	/**
	 * 使用者儲存庫
	 */
	@Autowired
	private UserRepository userRepository;

	public UserTX() {

	}

	/**
	 * TX
	 * 
	 * 新增使用者
	 * 
	 * @param user
	 * @return
	 */
	@Transactional
	public User insert(User user) {
		User result = userRepository.save(user);
		return result;
	}

	/**
	 * TX
	 * 
	 * 更新使用者
	 * 
	 * @param user
	 * @return
	 */
	@Transactional
	public User update(User user) {
		User result = userRepository.save(user);
		return result;
	}

	/**
	 * TX
	 * 
	 * 刪除使用者
	 * 
	 * @param user
	 */
	@Transactional
	public void delete(User user) {
		userRepository.delete(user);
	}
}
