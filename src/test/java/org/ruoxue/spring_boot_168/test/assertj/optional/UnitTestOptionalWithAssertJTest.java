package org.ruoxue.spring_boot_168.test.assertj.optional;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class UnitTestOptionalWithAssertJTest {

	@Test
	public void is() {
		String value = "AssertJ 155";
		System.out.println(value);
		Condition<String> length = new Condition<String>(s -> s.length() > 10, "length");
		System.out.println(value);
		assertThat(value).is(length);

		value = "AssertJ";
		System.out.println(value);
		length = new Condition<String>(s -> s.length() > 6, "length");
		System.out.println(value);
		assertThat(value).is(length);

	}

	@Test
	public void isNot() {
		String value = "AssertJ 155";
		System.out.println(value);
		Condition<String> length = new Condition<String>(s -> s.length() > 11, "length");
		assertThat(value).isNot(length);

		value = "AssertJ";
		System.out.println(value);
		length = new Condition<String>(s -> s.length() > 7, "length");
		assertThat(value).isNot(length);
	}

	@Test
	public void isIn() {
		String value = "AssertJ";
		System.out.println(value);
		assertThat(value).isIn("AssertJ", "155");

		value = "155";
		System.out.println(value);
		assertThat(value).isIn("AssertJ", "155");
	}

	@Test
	public void isNotIn() {
		String value = "AssertJ";
		System.out.println(value);
		assertThat(value).isNotIn("JUnit", "151");

		value = "155";
		System.out.println(value);
		assertThat(value).isNotIn("JUnit", "151");
	}

	@Test
	public void isInstanceOf() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).isInstanceOf(String.class);

		value = new String("AssertJ 155");
		System.out.println(value);
		assertThat(value).isInstanceOf(String.class);

	}

	@Test
	public void isNotInstanceOf() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).isNotInstanceOf(String[].class);

		value = new String("AssertJ 155");
		System.out.println(value);
		assertThat(value).isNotInstanceOf(String[].class);
	}

	@Test
	public void startsWith() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).startsWith("AssertJ");

		value = "155 AssertJ";
		System.out.println(value);
		assertThat(value).startsWith("155");
	}

	@Test
	public void endsWith() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).endsWith("155");

		value = "155 AssertJ";
		System.out.println(value);
		assertThat(value).endsWith("AssertJ");
	}
}
