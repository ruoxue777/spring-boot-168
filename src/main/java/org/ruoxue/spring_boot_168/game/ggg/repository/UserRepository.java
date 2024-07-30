package org.ruoxue.spring_boot_168.game.ggg.repository;

import org.ruoxue.spring_boot_168.game.ggg.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 使用者儲存庫
 */
public interface UserRepository extends CrudRepository<User, String>, PagingAndSortingRepository<User, String> {

	/**
	 * 依帳號取得使用者
	 * 
	 * @param cid
	 * @return
	 */
	User findByCid(String cid);
}
