package org.ruoxue.spring_boot_168.test.assertj.localdatetime;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.Month;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class AssertJLocalDateTimeWithExamplesTest {

	@Test
	public void has() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		Condition<LocalDateTime> year = new Condition<LocalDateTime>(d -> d.getYear() > 2022, "year");
		assertThat(value).has(year);

		value = null;
		System.out.println(value);
		Condition<LocalDateTime> nullz = new Condition<LocalDateTime>(d -> d == null, "null");
		assertThat(value).has(nullz);
	}

	@Test
	public void hasYear() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).hasYear(2023);

		value = LocalDateTime.of(2000, 01, 01, 0, 0, 0);
		System.out.println(value);
		assertThat(value).hasYear(2000);
	}

	@Test
	public void hasMonth() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).hasMonth(Month.OCTOBER);

		value = LocalDateTime.of(2000, 01, 01, 0, 0, 0);
		System.out.println(value);
		assertThat(value).hasMonth(Month.JANUARY);
	}

	@Test
	public void hasMonthValue() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).hasMonthValue(10);

		value = LocalDateTime.of(2000, 01, 01, 0, 0, 0);
		System.out.println(value);
		assertThat(value).hasMonthValue(1);
	}

	@Test
	public void hasDayOfMonth() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).hasDayOfMonth(31);

		value = LocalDateTime.of(2000, 01, 01, 0, 0, 0);
		System.out.println(value);
		assertThat(value).hasDayOfMonth(1);
	}

	@Test
	public void hasHour() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).hasHour(5);

		value = LocalDateTime.of(2000, 01, 01, 0, 0, 0);
		System.out.println(value);
		assertThat(value).hasHour(0);
	}

	@Test
	public void hasMinute() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).hasMinute(6);

		value = LocalDateTime.of(2000, 01, 01, 0, 0, 0);
		System.out.println(value);
		assertThat(value).hasMinute(0);
	}

	@Test
	public void hasSecond() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).hasSecond(7);

		value = LocalDateTime.of(2000, 01, 01, 0, 0, 0);
		System.out.println(value);
		assertThat(value).hasSecond(0);
	}

	@Test
	public void hasNano() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7, 111);
		System.out.println(value);
		assertThat(value).hasNano(111);

		value = LocalDateTime.of(2000, 01, 01, 0, 0, 0, 999);
		System.out.println(value);
		assertThat(value).hasNano(999);
	}

	@Test
	public void hasToString() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).hasToString("2023-10-31T05:06:07");

		value = LocalDateTime.of(2000, 01, 01, 0, 0, 0);
		System.out.println(value);
		assertThat(value).hasToString("2000-01-01T00:00");
	}

	@Test
	public void doesNotHave() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		Condition<LocalDateTime> year = new Condition<LocalDateTime>(d -> d.getYear() > 2023, "year");
		assertThat(value).doesNotHave(year);

		value = null;
		System.out.println(value);
		Condition<LocalDateTime> nullz = new Condition<LocalDateTime>(d -> d != null, "null");
		assertThat(value).doesNotHave(nullz);
	}
}
