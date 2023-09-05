package org.ruoxue.spring_boot_168.test.assertj.localdatetime;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class UnitTestAssertJLocalDateTimeWithExamplesTest {

	@Test
	public void isEqualToIgnoringHours() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		LocalDateTime value2 = LocalDateTime.of(2023, 10, 31, 0, 6, 7);
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isEqualToIgnoringHours(value2);

		value = LocalDateTime.parse("2000-01-01T00:00:00");
		value2 = LocalDateTime.parse("2000-01-01T01:00:00");
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isEqualToIgnoringHours(value2);
	}

	@Test
	public void isEqualToIgnoringMinutes() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		LocalDateTime value2 = LocalDateTime.of(2023, 10, 31, 5, 0, 7);
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isEqualToIgnoringHours(value2);

		value = LocalDateTime.parse("2000-01-01T00:00:00");
		value2 = LocalDateTime.parse("2000-01-01T00:01:00");
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isEqualToIgnoringHours(value2);
	}

	@Test
	public void isEqualToIgnoringSeconds() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		LocalDateTime value2 = LocalDateTime.of(2023, 10, 31, 5, 6, 0);
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isEqualToIgnoringHours(value2);

		value = LocalDateTime.parse("2000-01-01T00:00:00");
		value2 = LocalDateTime.parse("2000-01-01T00:00:01");
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isEqualToIgnoringHours(value2);
	}

	@Test
	public void isEqualToIgnoringNanos() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		LocalDateTime value2 = LocalDateTime.of(2023, 10, 31, 5, 6, 7, 123);
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isEqualToIgnoringHours(value2);

		value = LocalDateTime.parse("2000-01-01T00:00:00");
		value2 = LocalDateTime.parse("2000-01-01T00:00:00.123");
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isEqualToIgnoringHours(value2);
	}
}
