package org.ruoxue.spring_boot_168.sso.member.service;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.ruoxue.spring_boot_168.sso.member.repository.MemberRepository;

@ExtendWith(SpringExtension.class)
public class MemberServiceImplMockTest {

	@Mock
	private MemberRepository memberRepository;

	@InjectMocks
	private MemberServiceImpl memberService;

	@Test
	public void findName() {
		when(memberRepository.findName(anyString())).thenReturn("mock player");
		String name = memberService.findName("ruoxue");
		System.out.println(name);
		assertEquals("mock player", name);
	}
}
