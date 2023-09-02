package org.ruoxue.spring_boot_168.test.assertj.localdatetime;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class UnitTestLocalDateTimeWithAssertJTest {

	@Test
	public void is() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		Condition<String> length = new Condition<String>(s -> s.length() > 10, "length");
//		System.out.println(value);
//		assertThat(value).is(length);
//
//		value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
//		System.out.println(value);
//		length = new Condition<String>(s -> s.length() > 6, "length");
//		System.out.println(value);
//		assertThat(value).is(length);
	}

	@Test
	public void isNot() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
//		System.out.println(value);
//		Condition<String> length = new Condition<String>(s -> s.length() > 11, "length");
//		assertThat(value).isNot(length);
//
//		value = "AssertJ";
//		System.out.println(value);
//		length = new Condition<String>(s -> s.length() > 7, "length");
//		assertThat(value).isNot(length);
	}

	@Test
	public void isIn() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
//		System.out.println(value);
//		assertThat(value).isIn("AssertJ", "155");
//
//		value = "155";
//		System.out.println(value);
//		assertThat(value).isIn("AssertJ", "155");
	}

	@Test
	public void isNotIn() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).isNotIn("JUnit", "151");
//
//		value = "155";
//		System.out.println(value);
//		assertThat(value).isNotIn("JUnit", "151");
	}

	@Test
	public void isInstanceOf() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isInstanceOf(String.class);

//		value = new String("AssertJ 155");
//		System.out.println(value);
//		assertThat(value).isInstanceOf(String.class);
	}

	@Test
	public void isNotInstanceOf() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).isNotInstanceOf(String[].class);
//
//		value = new String("AssertJ 155");
//		System.out.println(value);
//		assertThat(value).isNotInstanceOf(String[].class);
	}
}
