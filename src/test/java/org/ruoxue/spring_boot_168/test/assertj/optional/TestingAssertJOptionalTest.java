package org.ruoxue.spring_boot_168.test.assertj.optional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

public class TestingAssertJOptionalTest {

	@Test
	public void map() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		Function<String, String> upperCase = s -> s.toUpperCase();
		assertThat(value).map(upperCase).contains("ASSERTJ");

		value = Optional.ofNullable(null);
		System.out.println(value);
		assertThat(value).map(upperCase).isEmpty();

		Optional<Integer> intValue = Optional.of(-155);
		System.out.println(intValue);
		Function<Integer, Integer> abs = i -> Math.abs(i);
		assertThat(intValue).map(abs).contains(155);

		intValue = Optional.ofNullable(null);
		System.out.println(intValue);
		assertThat(intValue).map(abs).isEmpty();
	}

	@Test
	public void flatMap() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		Function<String, Optional<String>> upperCase = s -> s == null ? Optional.empty() : Optional.of(s.toUpperCase());
		assertThat(value).flatMap(upperCase).contains("ASSERTJ");

		value = Optional.ofNullable(null);
		System.out.println(value);
		assertThat(value).flatMap(upperCase).isEmpty();

		Optional<Integer> intValue = Optional.of(-155);
		System.out.println(intValue);
		Function<Integer, Optional<Integer>> abs = i -> i == null ? Optional.empty() : Optional.of(Math.abs(i));
		assertThat(intValue).flatMap(abs).contains(155);

		intValue = Optional.ofNullable(null);
		System.out.println(intValue);
		assertThat(intValue).flatMap(abs).isEmpty();
	}

	@Test
	public void usingDefaultComparator() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		assertThat(value).usingDefaultComparator().contains("AssertJ");

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		assertThat(intValue).usingDefaultComparator().contains(155);
	}

	@Test
	public void usingComparator() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		Comparator<Optional<String>> ignoreCase = (s1, s2) -> s1.get().toLowerCase().compareTo(s2.get().toLowerCase());
		assertThat(value).usingComparator(ignoreCase).hasValue("AssertJ");

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		Comparator<Optional<Integer>> abs = (i1, i2) -> Double.compare(i1.get(), Math.abs(i2.get()));
		assertThat(intValue).usingComparator(abs).hasValue(155);
	}

	@Test
	public void usingComparatorWithDescription() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		Comparator<Optional<String>> ignoreCase = (s1, s2) -> s1.get().toLowerCase().compareTo(s2.get().toLowerCase());
		assertThat(value).usingComparator(ignoreCase, "ignoreCase").hasValue("AssertJ");

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		Comparator<Optional<Integer>> abs = (i1, i2) -> Double.compare(i1.get(), Math.abs(i2.get()));
		assertThat(intValue).usingComparator(abs, "abs").hasValue(155);
	}
}
