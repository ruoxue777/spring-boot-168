package org.ruoxue.spring_boot_168.test.assertj.localdatetime;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class UnitTestAssertJLocalDateTimeWithExamplesTest {

	@Test
	public void isEqualToIgnoringHours() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isEqualToIgnoringHours(LocalDateTime.of(2023, 10, 31, 0, 6, 7));

		value = LocalDateTime.parse("2000-01-01T00:00:00");
		System.out.println(value);
		assertThat(value).isEqualToIgnoringHours(LocalDateTime.parse("2000-01-01T01:00:00"));
	}

	@Test
	public void isEqualToIgnoringMinutes() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isEqualToIgnoringMinutes(LocalDateTime.of(2023, 10, 31, 5, 0, 7));

		value = LocalDateTime.parse("2000-01-01T00:00:00");
		System.out.println(value);
		assertThat(value).isEqualToIgnoringMinutes(LocalDateTime.parse("2000-01-01T00:01:00"));
	}

	@Test
	public void isEqualToIgnoringSeconds() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isEqualToIgnoringSeconds(LocalDateTime.of(2023, 10, 31, 5, 6, 0));

		value = LocalDateTime.parse("2000-01-01T00:00:00");
		System.out.println(value);
		assertThat(value).isEqualToIgnoringSeconds(LocalDateTime.parse("2000-01-01T00:00:01"));
	}

	@Test
	public void isEqualToIgnoringNanos() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7, 123);
		System.out.println(value);
		assertThat(value).isEqualToIgnoringNanos(LocalDateTime.of(2023, 10, 31, 5, 6, 7));

		value = LocalDateTime.parse("2000-01-01T00:00:00.123");
		System.out.println(value);
		assertThat(value).isEqualToIgnoringNanos(LocalDateTime.parse("2000-01-01T00:00"));
	}
}
