package org.ruoxue.spring_boot_168.test.assertj.optional;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class AssertJOptionalAssertionsTest {


	@Test
	public void isPresent() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		assertThat(value).isPresent();

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		assertThat(intValue).isPresent();
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
	public void contains() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		assertThat(value).contains("AssertJ");

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		assertThat(intValue).contains(155);
	}

	@Test
	public void containsInstanceOf() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		assertThat(value).containsInstanceOf(String.class);

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		assertThat(intValue).containsInstanceOf(Integer.class);
	}

	@Test
	public void containsSame() {
		String s = "AssertJ";
		Optional<String> value = Optional.of(s);
		System.out.println(value);
		assertThat(value).containsSame(s);

		Integer i = 155;
		Optional<Integer> intValue = Optional.of(i);
		System.out.println(intValue);
		assertThat(intValue).containsSame(i);
	}

	@Test
	public void containsThrowError() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		assertThat(value).contains("155");
	}

	@Test
	public void containsThrownBy() {
		assertThatThrownBy(() -> {
			Optional<String> value = Optional.of("AssertJ");
			System.out.println(value);
			assertThat(value).contains("155");
		}).isInstanceOf(AssertionError.class);
	}
}
