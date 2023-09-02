package org.ruoxue.spring_boot_168.test.assertj.localdatetime;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

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
//		assertThat(value).hasYear(year);
	}

	@Test
	public void hasMonth() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).hasMonth(month)
	}

	@Test
	public void hasMonthValue() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).hasMonthValue(monthVal)
	}

	@Test
	public void hasDayOfMonth() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).hasDayOfMonth(dayOfMonth)
	}

	@Test
	public void hasHour() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).hasHour(hour)
	}

	@Test
	public void hasMinute() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).hasMinute(minute)
	}

	@Test
	public void hasSecond() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).hasSecond(second)
	}

	@Test
	public void hasNano() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).hasNano(nano)
	}

	@Test
	public void hasToString() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).hasToString(value.toString());
//
//		value = "AssertJ";
//		System.out.println(value);
//		assertThat(value).hasToString(value.toString());
	}

	@Test
	public void doesNotHave() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		Condition<String> length = new Condition<String>(s -> s.length() > 12, "length");
//
//		value = "AssertJ";
//		System.out.println(value);
//		Condition<String> nullz = new Condition<String>(s -> s == null, "null");
//		assertThat(value).doesNotHave(nullz);
	}
}
