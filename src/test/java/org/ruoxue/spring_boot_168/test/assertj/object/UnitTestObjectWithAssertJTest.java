package org.ruoxue.spring_boot_168.test.assertj.object;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class UnitTestObjectWithAssertJTest {

	@Test
	public void is() {
		Object value = "AssertJ 155";
		System.out.println(value);
		Condition<Object> length = new Condition<Object>(s -> s.length() > 10, "length");
		System.out.println(value);
		assertThat(value).is(length);

		value = "AssertJ";
		System.out.println(value);
		length = new Condition<Object>(s -> s.length() > 6, "length");
		System.out.println(value);
		assertThat(value).is(length);

	}

	@Test
	public void isNot() {
		Object value = "AssertJ 155";
		System.out.println(value);
		Condition<Object> length = new Condition<Object>(s -> s.length() > 11, "length");
		assertThat(value).isNot(length);

		value = "AssertJ";
		System.out.println(value);
		length = new Condition<Object>(s -> s.length() > 7, "length");
		assertThat(value).isNot(length);
	}

	@Test
	public void isIn() {
		Object value = "AssertJ";
		System.out.println(value);
		assertThat(value).isIn("AssertJ", "155");

		value = "155";
		System.out.println(value);
		assertThat(value).isIn("AssertJ", "155");
	}

	@Test
	public void isNotIn() {
		Object value = "AssertJ";
		System.out.println(value);
		assertThat(value).isNotIn("JUnit", "151");

		value = "155";
		System.out.println(value);
		assertThat(value).isNotIn("JUnit", "151");
	}

	@Test
	public void isInstanceOf() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).isInstanceOf(Object.class);

		value = new Object("AssertJ 155");
		System.out.println(value);
		assertThat(value).isInstanceOf(Object.class);

	}

	@Test
	public void isNotInstanceOf() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).isNotInstanceOf(Object[].class);

		value = new Object("AssertJ 155");
		System.out.println(value);
		assertThat(value).isNotInstanceOf(Object[].class);
	}

	@Test
	public void startsWith() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).startsWith("AssertJ");

		value = "155 AssertJ";
		System.out.println(value);
		assertThat(value).startsWith("155");
	}

	@Test
	public void endsWith() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).endsWith("155");

		value = "155 AssertJ";
		System.out.println(value);
		assertThat(value).endsWith("AssertJ");
	}
}
