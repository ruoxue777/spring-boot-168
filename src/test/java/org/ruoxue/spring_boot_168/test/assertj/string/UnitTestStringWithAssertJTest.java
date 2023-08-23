package org.ruoxue.spring_boot_168.test.assertj.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class UnitTestStringWithAssertJTest {

	@Test
	public void is() {
		String value = "AssertJ 155";
		System.out.println(value);
		Condition<String> length = new Condition<String>(s -> s.length() > 2, "length");
		System.out.println(value);
		assertThat(value).is(length);
	}

	@Test
	public void isNot() {
		String value = "AssertJ 155";
		System.out.println(value);
		Condition<String> length = new Condition<String>(s -> s.length() > 11, "length");
		assertThat(value).isNot(length);
	}

	@Test
	public void isIn() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(" ").isIn(value);
	}

	@Test
	public void isNotIn() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat("JUnit").isNotIn(value);
	}

	@Test
	public void isInstanceOf() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).isInstanceOf(String.class);
	}

	@Test
	public void isNotInstanceOf() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).isNotInstanceOf(String[].class);
	}

	@Test
	public void startsWith() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).startsWith("AssertJ");
	}

	@Test
	public void endsWith() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).endsWith("155");
	}
}
