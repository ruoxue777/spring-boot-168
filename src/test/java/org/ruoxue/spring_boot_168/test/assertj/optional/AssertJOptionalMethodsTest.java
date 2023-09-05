package org.ruoxue.spring_boot_168.test.assertj.optional;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class AssertJOptionalMethodsTest {

	@Test
	public void isNull() {
		Optional<String> value = null;
		System.out.println(value);
		assertThat(value).isNull();

		Optional<Integer> intValue = null;
		System.out.println(intValue);
		assertThat(intValue).isNull();
	}

	@Test
	public void isNotNull() {
		Optional<String> value = Optional.of("AssertJ 155");
		System.out.println(value);
		assertThat(value).isNotNull();

		Optional<Integer> intValue = Optional.of(0);
		System.out.println(intValue);
		assertThat(intValue).isNotNull();
	}

	@Test
	public void isEmpty() {
		Optional<String> value = Optional.empty();
		System.out.println(value);
		assertThat(value).isEmpty();

		Optional<Integer> intValue = Optional.empty();
		System.out.println(intValue);
		assertThat(intValue).isEmpty();
	}

	@Test
	public void isNotEmpty() {
		Optional<String> value = Optional.of("AssertJ 155");
		System.out.println(value);
		assertThat(value).isNotEmpty();

		Optional<Integer> intValue = Optional.of(0);
		System.out.println(intValue);
		assertThat(intValue).isNotEmpty();
	}

	@Test
	public void isPresent() {
		Optional<String> value = Optional.of("AssertJ 155");
		System.out.println(value);
		assertThat(value).isPresent();

		Optional<Integer> intValue = Optional.of(0);
		System.out.println(intValue);
		assertThat(intValue).isNotEmpty();
	}

	@Test
	public void isNotPresent() {
		Optional<String> value = Optional.empty();
		System.out.println(value);
		assertThat(value).isNotPresent();

		Optional<Integer> intValue = Optional.empty();
		System.out.println(intValue);
		assertThat(intValue).isNotPresent();
	}

	@Test
	public void isEqualTo() {
		Optional<String> value = Optional.of("AssertJ 155");
		System.out.println(value);
		assertThat(value).isEqualTo(Optional.of("AssertJ 155"));

		Optional<Integer> intValue = Optional.of(0);
		System.out.println(intValue);
		assertThat(intValue).isEqualTo(Optional.of(0));
	}

	@Test
	public void isNotEqualTo() {
		Optional<String> value = Optional.of("AssertJ 155");
		System.out.println(value);
		assertThat(value).isNotEqualTo(Optional.empty());

		Optional<Integer> intValue = Optional.of(0);
		System.out.println(intValue);
		assertThat(intValue).isNotEqualTo(Optional.empty());
	}

	@Test
	public void isSameAs() {
		Optional<String> value = Optional.of("AssertJ 155");
		Optional<String> value2 = value;
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isSameAs(value2);

		Optional<Integer> intValue = Optional.of(0);
		Optional<Integer> intValue2 = intValue;
		System.out.println(intValue);
		System.out.println(intValue2);
		assertThat(intValue).isSameAs(intValue2);
	}

	@Test
	public void isNotSameAs() {
		Optional<String> value = Optional.of("AssertJ 155");
		Optional<String> value2 = Optional.of("AssertJ 155");
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isNotSameAs(value2);

		Optional<Integer> intValue = Optional.of(0);
		Optional<Integer> intValue2 = Optional.of(0);
		System.out.println(intValue);
		System.out.println(intValue2);
		assertThat(intValue).isNotSameAs(intValue2);
	}
}
