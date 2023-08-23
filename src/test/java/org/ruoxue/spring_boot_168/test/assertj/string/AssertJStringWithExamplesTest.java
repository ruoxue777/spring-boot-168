package org.ruoxue.spring_boot_168.test.assertj.string;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class AssertJStringWithExamplesTest {

	@Test
	public void has() {
		String value = "AssertJ 155";
		System.out.println(value);
		Condition<String> length = new Condition<String>(s -> s.length() > 2, "length");
		assertThat(value).has(length);

		value = null;
		System.out.println(value);
		Condition<String> nullz = new Condition<String>(s -> s == null, "null");
		assertThat(value).has(nullz);
	}

	@Test
	public void hasSize() {
		int expectedSize = 11;
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).hasSize(expectedSize);

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).hasSize(7);
	}

	@Test
	public void hasSizeBetween() {
		int expectedSize = 11;
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).hasSizeBetween(1, expectedSize);

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).hasSizeBetween(1, 7);
	}

	@Test
	public void hasSizeGreaterThan() {
		int expectedSize = 2;
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).hasSizeGreaterThan(expectedSize);

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).hasSizeGreaterThan(6);
	}

	@Test
	public void hasSizeLessThan() {
		int expectedSize = 12;
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).hasSizeLessThan(expectedSize);

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).hasSizeLessThan(8);
	}

	@Test
	public void hasToString() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).hasToString(value.toString());

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).hasToString(value.toString());
	}

	@Test
	public void hasSameSizeAs() {
		String value = "AssertJ 155";
		String value2 = "AssertJ 155";
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).hasSameSizeAs(value2);

		value = "AssertJ";
		value2 = "AssertJ";
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).hasSameSizeAs(value2);
	}

	@Test
	public void doesNotHave() {
		String value = "AssertJ 155";
		System.out.println(value);
		Condition<String> length = new Condition<String>(s -> s.length() > 12, "length");
		assertThat(value).doesNotHave(length);

		value = "AssertJ";
		System.out.println(value);
		Condition<String> nullz = new Condition<String>(s -> s == null, "null");
		assertThat(value).doesNotHave(nullz);
	}
}
