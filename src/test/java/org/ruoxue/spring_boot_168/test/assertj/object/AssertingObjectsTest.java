package org.ruoxue.spring_boot_168.test.assertj.object;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

public class AssertingObjectsTest {

	@Test
	public void matches() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).matches(s -> s.length() < 12);

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).matches(s -> s.length() < 8);
	}

	@Test
	public void matchesWithDescription() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).matches(s -> s.length() < 12, "length");

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).matches(s -> s.length() < 8, "length");
	}

	@Test
	public void matchesThrowError() {
		assertThatCode(() -> {
			Object value = "AssertJ 155";
			System.out.println(value);
			assertThat(value).matches(s -> s.length() > 12, "length");
		}).isInstanceOf(AssertionError.class);

		assertThatCode(() -> {
			Object value = "AssertJ";
			System.out.println(value);
			assertThat(value).matches(s -> s.length() > 8, "length");
		}).isInstanceOf(AssertionError.class);
	}

	@Test
	public void satisfies() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).satisfies(s -> {
			assertThat(s).isNotNull();
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
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).satisfiesAnyOf(s -> {
			assertThat(s).isNotNull();
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

	@Test
	public void satisfiesThrowError() {
		assertThatCode(() -> {
			Object value = "AssertJ 155";
			System.out.println(value);
			assertThat(value).satisfies(s -> {
				assertThat(s).isNotNull();
				assertThat(s).hasSize(12);
			});
		}).isInstanceOf(AssertionError.class);

		assertThatCode(() -> {
			Object value = "AssertJ";
			System.out.println(value);
			assertThat(value).satisfies(s -> {
				assertThat(s).isNotEmpty();
			}, s -> {
				assertThat(s).hasSize(8);
			});
		}).isInstanceOf(AssertionError.class);
	}
}
