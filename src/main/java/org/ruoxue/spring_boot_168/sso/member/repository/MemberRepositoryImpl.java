package org.ruoxue.spring_boot_168.sso.member.repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class MemberRepositoryImpl implements MemberRepository {

	@Override
	public String findName(String cid) {
		return "player";
	}

	@Override
	public List<String> findAll() {
		List<String> list = Arrays.asList("ruoxue", "ruoxue2");
		return list;
	}

	@Override
	public Map<String, String> findAll(int page, int size) {
		Map<String, String> map = ImmutableMap.of("ruoxue", "player");
		return map;
	}

	@Override
	public int updateName(String cid, String name) {
		return 1 / 0;
	}
}
