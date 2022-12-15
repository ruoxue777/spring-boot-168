package org.ruoxue.spring_boot_168.sso.member.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

public class MemberRepositoryImplTest {

	private MemberRepository memberRepository = new MemberRepositoryImpl();

	@Test
	public void findName() {
		String name = memberRepository.findName("ruoxue");
		System.out.println(name);
		assertThat(name)
		.isEqualTo("player")
		.isEqualToIgnoringCase("Player")
		.startsWith("p")
		.endsWith("r")
		.contains("play")
		;
	}

	@Test
	public void findAll() {
		List<String> list = memberRepository.findAll();
		System.out.println(list);
		assertThat(list)
		.hasSize(2)
		.contains("ruoxue","ruoxue2")
		.contains("ruoxue",Index.atIndex(0))
		.contains("ruoxue2",Index.atIndex(1))
		.doesNotContain("player")
		;
	}
	
	@Test
	public void findAllThrowException() {
        assertThatThrownBy(() -> {
            List<String> list = memberRepository.findAll();
            list.get(2);
        })
        .isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining("2")
        ;
	}
	
	@Test
	public void findAllByPage() {
		Map<String, String> map = memberRepository.findAll(0,10);
		System.out.println(map);
		assertThat(map)
		.hasSize(1)
        .extractingByKey("ruoxue", as(InstanceOfAssertFactories.STRING))
        .isEqualToIgnoringCase("player")
 	    .endsWith("r")
 		.contains("play")
		;
		
        assertThat(map).extracting("ruoxue")
        .isEqualTo("player");
	}
	
	@Test
	public void updateName() {
        assertThatThrownBy(() -> memberRepository.updateName("ruoxue", "test_player"))
        .isInstanceOf(ArithmeticException.class)
        .hasMessageContaining("zero")
        .hasMessage("/ by zero")
        ;	
	}
}
