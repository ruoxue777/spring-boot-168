package org.ruoxue.spring_boot_168.test.assertj.localdatetime;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class AssertJLocalDateTimeMethodsTest {

	@Test
	public void isNull() {
		String value = null;
		System.out.println(value);
		assertThat(value).isNull();

		String value2 = null;
		System.out.println(value2);
		assertThat(value2).isNull();
	}

	@Test
	public void isNotNull() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isNotNull();

		value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isNotNull();
	}

	@Test
	public void isEqualTo() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).isEqualTo("AssertJ 155");
//
//		value = "AssertJ";
//		System.out.println(value);
//		assertThat(value).isEqualTo("AssertJ");
	}

	@Test
	public void isNotEqualTo() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).isNotEqualTo("AssertJ");
//
//		value = "AssertJ";
//		System.out.println(value);
//		assertThat(value).isNotEqualTo("JUnit");
	}

	@Test
	public void isSameAs() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		LocalDateTime value2 = value;
		System.out.println(value);
		System.out.println(value2);
//		assertThat(value).isSameAs(value2);
//
//		value = "AssertJ";
//		value2 = value;
//		System.out.println(value);
//		System.out.println(value2);
//		assertThat(value).isSameAs(value2);
	}

	@Test
	public void isNotSameAs() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		String value2 = new String("AssertJ 155");
		System.out.println(value);
		System.out.println(value2);
//		assertThat(value).isNotSameAs(value2);
//
//		value =  LocalDateTime.of(2023, 10, 31, 5, 6, 7);
//		value2 = new String("AssertJ");
//		System.out.println(value);
//		System.out.println(value2);
//		assertThat(value).isNotSameAs(value2);
	}
}
