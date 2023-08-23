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
	}

	@Test
	public void hasSize() {
		int expectedSize = 11;
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).hasSize(expectedSize);
	}

	@Test
	public void hasSizeBetween() {
		int expectedSize = 11;
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).hasSizeBetween(1, expectedSize);
	}

	@Test
	public void hasSizeGreaterThan() {
		int expectedSize = 2;
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).hasSizeGreaterThan(expectedSize);
	}

	@Test
	public void hasSizeLessThan() {
		int expectedSize = 12;
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).hasSizeLessThan(expectedSize);
	}

	@Test
	public void hasToString() {
		String value = "AssertJ 155";
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
	}

	@Test
	public void doesNotHave() {
		String value = "AssertJ 155";
		System.out.println(value);
		Condition<String> length = new Condition<String>(s -> s.length() > 12, "length");
		assertThat(value).doesNotHave(length);
	}
}
