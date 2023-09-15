package org.ruoxue.spring_boot_168.test.assertj.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class AssertingStringsTest {

	@Test
	public void matches() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).matches(s -> s.length() < 12);

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).matches(s -> s.length() < 8);
	}

	@Test
	public void matchesWithDescription() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).matches(s -> s.length() < 12, "length");

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).matches(s -> s.length() < 8, "length");
	}

	@Test
	public void satisfies() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).satisfies(s -> {
			assertThat(s).isNotEmpty();
			assertThat(s).hasSize(11);
		});

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).satisfies(s -> {
			assertThat(s).isNotEmpty();
		}, s -> {
			assertThat(s).hasSize(7);
		});
	}

	@Test
	public void satisfiesAnyOf() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).satisfiesAnyOf(s -> {
			assertThat(s).isNotEmpty();
			assertThat(s).hasSize(11);
		});

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).satisfiesAnyOf(s -> {
			assertThat(s).isNotEmpty();
		}, s -> {
			assertThat(s).hasSize(99);
		});
	}

}
