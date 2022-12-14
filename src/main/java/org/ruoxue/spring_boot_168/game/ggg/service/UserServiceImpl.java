package org.ruoxue.spring_boot_168.game.ggg.service;

import org.ruoxue.spring_boot_168.game.ggg.ex.UserException;
import org.ruoxue.spring_boot_168.game.ggg.model.User;
import org.ruoxue.spring_boot_168.game.ggg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 使用者服務實作
 */
@Service
public class UserServiceImpl implements UserService {

	/**
	 * 使用者儲存庫
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * 使用者 TX
	 */
	@Autowired
	private UserTX tx;

	public UserServiceImpl() {
	}

	/**
	 * 新增使用者
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public User insert(User user) {
		User result = null;
		try {
			result = tx.insert(user);
		} catch (UserException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new UserException(ex);
		}
		return result;
	}

	/**
	 * 依帳號取得使用者
	 * 
	 * @param cid
	 * @return
	 */
	@Override
	public User findByCid(String cid) {
		User result = null;
		try {
			result = userRepository.findByCid(cid);
		} catch (UserException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new UserException(ex);
		}
		return result;
	}

	/**
	 * 更新使用者
	 * 
	 * @param user
	 * @return
	 */
	@Override
	public User update(User user) {
		User result = null;
		try {
			result = tx.update(user);
		} catch (UserException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new UserException(ex);
		}
		return result;
	}

	/**
	 * 刪除使用者
	 * 
	 * @param user
	 */
	@Override
	public void delete(User user) {
		try {
			tx.delete(user);
		} catch (UserException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new UserException(ex);
		}
	}
}
