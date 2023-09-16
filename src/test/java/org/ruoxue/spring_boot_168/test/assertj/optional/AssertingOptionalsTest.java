package org.ruoxue.spring_boot_168.test.assertj.optional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class AssertingOptionalsTest {

	@Test
	public void matches() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		assertThat(value).matches(o -> o.isPresent());

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		assertThat(intValue).matches(o -> o.get() != null);
	}

	@Test
	public void matchesWithDescription() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		assertThat(value).matches(o -> o.isPresent(), "isPresent");

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		assertThat(intValue).matches(o -> o.get() != null, "notNull");
	}

	@Test
	public void satisfies() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		assertThat(value).satisfies(o -> {
			assertThat(o).isNotEmpty();
			assertThat(o).hasValue("AssertJ");
		});

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		assertThat(intValue).satisfies(o -> {
			assertThat(o).isNotNull();
		}, o -> {
			assertThat(o).isIn(Optional.of(151), Optional.of(155));
		});
	}

	@Test
	public void satisfiesAnyOf() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		assertThat(value).satisfiesAnyOf(o -> {
			assertThat(o).isNotEmpty();
			assertThat(o).hasValue("AssertJ");
		});

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		assertThat(intValue).satisfiesAnyOf(o -> {
			assertThat(o).isNotNull();
		}, o -> {
			assertThat(o).isIn(Optional.of(0), Optional.of(1));
		});
	}
}
