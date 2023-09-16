package org.ruoxue.spring_boot_168.test.assertj.localdatetime;

import static org.assertj.core.api.Assertions.*;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import org.assertj.core.data.TemporalUnitWithinOffset;
import org.junit.jupiter.api.Test;

public class AssertJLocalDateTimeAssertionsTest {

	@Test
	public void isCloseTo() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isCloseTo(LocalDateTime.of(2023, 10, 31, 5, 6, 2),
				new TemporalUnitWithinOffset(5, ChronoUnit.SECONDS));
		assertThat(value).isCloseTo(LocalDateTime.of(2023, 10, 31, 5, 6, 12),
				new TemporalUnitWithinOffset(5, ChronoUnit.SECONDS));
	}

	@Test
	public void isCloseToWithin() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isCloseTo(LocalDateTime.of(2023, 10, 31, 5, 6, 2), within(5, ChronoUnit.SECONDS));
		assertThat(value).isCloseTo(LocalDateTime.of(2023, 10, 31, 5, 6, 12), within(5, ChronoUnit.SECONDS));
	}

	@Test
	public void isCloseToWithString() {
		LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
		System.out.println(value);
		assertThat(value).isCloseTo("2023-10-31T05:06:02", within(5, ChronoUnit.SECONDS));
		assertThat(value).isCloseTo("2023-10-31T05:06:12", within(5, ChronoUnit.SECONDS));
	}

	@Test
	public void isCloseToByLessThan() {
		LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
		System.out.println(value);
		assertThat(value).isCloseTo("2023-10-31T05:06:02", byLessThan(6, ChronoUnit.SECONDS));
		assertThat(value).isCloseTo("2023-10-31T05:06:12", byLessThan(6, ChronoUnit.SECONDS));
	}

	@Test
	public void isCloseToUtcNow() {
		LocalDateTime value = LocalDateTime.now(Clock.systemUTC());
		System.out.println(value);
		assertThat(value).isCloseToUtcNow(within(1, ChronoUnit.SECONDS));

		LocalDateTime value2 = LocalDateTime.now(ZoneId.of("UTC+8"));
		System.out.println(value2);
		assertThat(value2).isCloseToUtcNow(within(8, ChronoUnit.HOURS));
	}

	@Test
	public void isCloseToThrowError() {
		assertThatCode(() -> {
			LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
			System.out.println(value);
			assertThat(value).isCloseTo("2023-10-31T05:06:01", within(5, ChronoUnit.SECONDS));
		}).isInstanceOf(AssertionError.class);
	}

	@Test
	public void isCloseToThrownBy() {
		assertThatThrownBy(() -> {
			LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
			System.out.println(value);
			assertThat(value).isCloseTo("2023-10-31T05:06:01", within(5, ChronoUnit.SECONDS));
		}).isInstanceOf(AssertionError.class);
	}
}
