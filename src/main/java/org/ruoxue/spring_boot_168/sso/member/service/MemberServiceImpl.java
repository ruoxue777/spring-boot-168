package org.ruoxue.spring_boot_168.sso.member.service;

import org.ruoxue.spring_boot_168.sso.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Override
	public String findName(String cid) {
		return memberRepository.findName(cid);
	}
}
