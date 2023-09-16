package org.ruoxue.spring_boot_168.test.assertj.localdatetime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.within;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

public class AssertingLocalDateTimesTest {

	@Test
	public void matches() {
		LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
		System.out.println(value);
		assertThat(value).matches(l -> l.getYear() > 2022);

		value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).matches(l -> l.getMonth() == Month.OCTOBER);
	}

	@Test
	public void matchesWithDescription() {
		LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
		System.out.println(value);
		assertThat(value).matches(l -> l.getYear() > 2022, "yearGreaterThan");

		value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).matches(l -> l.getMonth() == Month.OCTOBER, "monthEqual");
	}

	@Test
	public void matchesThrowError() {
		assertThatCode(() -> {
			LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
			System.out.println(value);
			assertThat(value).matches(l -> l.getYear() > 2024, "yearGreaterThan");
		}).isInstanceOf(AssertionError.class);

		assertThatCode(() -> {
			LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
			System.out.println(value);
			assertThat(value).matches(l -> l.getMonth() == Month.NOVEMBER, "monthEqual");
		}).isInstanceOf(AssertionError.class);
	}

	@Test
	public void satisfies() {
		LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
		System.out.println(value);
		assertThat(value).satisfies(l -> {
			assertThat(l).isNotNull();
			assertThat(l).isCloseTo(LocalDateTime.of(2023, 10, 31, 5, 6, 2), within(5, ChronoUnit.SECONDS));
		});

		value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).satisfies(p -> {
			assertThat(p).isBefore(LocalDateTime.of(2023, 10, 31, 5, 6, 12));
		}, p -> {
			assertThat(p).isIn(LocalDateTime.of(2023, 10, 31, 5, 6, 7), LocalDateTime.of(2023, 10, 31, 6, 6, 7));
		});
	}

	@Test
	public void satisfiesAnyOf() {
		LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
		System.out.println(value);
		assertThat(value).satisfiesAnyOf(l -> {
			assertThat(l).isNotNull();
			assertThat(l).isCloseTo(LocalDateTime.of(2023, 10, 31, 5, 6, 2), within(5, ChronoUnit.SECONDS));
		});

		value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).satisfiesAnyOf(p -> {
			assertThat(p).isBefore(LocalDateTime.of(2023, 10, 31, 5, 6, 12));
		}, p -> {
			assertThat(p).isIn(LocalDateTime.of(2000, 10, 31, 5, 6, 7), LocalDateTime.of(2000, 10, 31, 6, 6, 7));
		});
	}

	@Test
	public void satisfiesThrowError() {
		assertThatCode(() -> {
			LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
			System.out.println(value);
			assertThat(value).satisfies(l -> {
				assertThat(l).isNotNull();
				assertThat(l).isCloseTo(LocalDateTime.of(2023, 10, 31, 5, 6, 22), within(5, ChronoUnit.SECONDS));
			});
		}).isInstanceOf(AssertionError.class);

		assertThatCode(() -> {
			LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
			System.out.println(value);
			assertThat(value).satisfies(p -> {
				assertThat(p).isBefore(LocalDateTime.of(2023, 10, 31, 5, 6, 12));
			}, p -> {
				assertThat(p).isIn(LocalDateTime.of(2023, 10, 31, 5, 6, 8), LocalDateTime.of(2023, 10, 31, 6, 6, 7));
			});
		}).isInstanceOf(AssertionError.class);
	}
}
