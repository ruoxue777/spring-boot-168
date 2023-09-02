package org.ruoxue.spring_boot_168.test.assertj.localdatetime;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class AssertJLocalDateTimeAssertionsTest {

	@Test
	public void isCloseTo() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).isCloseTo(other, offset)
	}

	@Test
	public void isCloseTo2() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).isCloseTo(other, offset)
	}

	@Test
	public void isCloseToUtcNow() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).isCloseToUtcNow(offset)
	}

}
