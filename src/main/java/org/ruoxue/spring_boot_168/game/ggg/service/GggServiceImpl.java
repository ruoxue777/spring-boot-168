package org.ruoxue.spring_boot_168.game.ggg.service;

import org.ruoxue.spring_boot_168.game.ggg.client.GggClient;
import org.ruoxue.spring_boot_168.game.ggg.ex.GggException;
import org.ruoxue.spring_boot_168.game.ggg.model.GggReponse;
import org.ruoxue.spring_boot_168.game.ggg.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class GggServiceImpl implements GggService {

	@Autowired
	private GggClient client;

	@Autowired
	private UserService service;

	public GggServiceImpl() {
	}

	/**
	 * 使用者是否存在
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public boolean exist(String username, String password) throws Exception {
		boolean result = false;
		GggReponse gggReponse = client.exist(username, password);
		if (gggReponse != null) {
			result = gggReponse.isExist();
		}
		return result;

	}

	/**
	 * 使用者登入
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public GggReponse login(String username, String password) {
		GggReponse result = null;
		try {
			String gameUser = null;
			String gamePassword = null;
			User user = service.findByCid(username);
			if (user != null) {
				gameUser = user.getCid();
				gamePassword = user.getPassword();
			}
			String regUser = username;
			String regPassword = password;
			boolean exist = false;
			if (gameUser != null && gamePassword != null) {
				exist = exist(gameUser, gamePassword);
			} else {
				exist = exist(regUser, regPassword);
			}
			if (!exist) {
				GggReponse gggReponse = client.create(regUser, regPassword);
				if (gggReponse != null && gggReponse.getErrorCode() == 0) {
					User found = service.findByCid(username);
					if (found == null) {
						User newUser = new User();
						newUser.setCid(regUser);
						newUser.setName(regUser);
						newUser.setPassword(regPassword);
						newUser.setSalt(regPassword);
						service.insert(newUser);
					}
					gameUser = regUser;
					gamePassword = regPassword;
					result = client.login(gameUser, gamePassword);
					result.setExist(true);
				} else {
					result = gggReponse;
				}
			} else {
				if (gameUser == null) {
					User found = service.findByCid(username);
					if (found == null) {
						User newUser = new User();
						newUser.setCid(regUser);
						newUser.setName(regUser);
						newUser.setPassword(regPassword);
						newUser.setSalt(regPassword);
						service.insert(newUser);
					}
					gameUser = regUser;
					gamePassword = regPassword;
					result = client.login(gameUser, gamePassword);
					result.setExist(true);
				}
			}

		} catch (GggException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new GggException(ex);
		}
		return result;
	}
}
