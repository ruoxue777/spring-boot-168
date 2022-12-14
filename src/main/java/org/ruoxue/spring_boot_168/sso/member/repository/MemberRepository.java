package org.ruoxue.spring_boot_168.sso.member.repository;

import java.util.List;
import java.util.Map;

public interface MemberRepository {

	String findName(String cid);

	List<String> findAll();

	Map<String, String> findAll(int page, int size);

	int updateName(String cid, String name);

}
