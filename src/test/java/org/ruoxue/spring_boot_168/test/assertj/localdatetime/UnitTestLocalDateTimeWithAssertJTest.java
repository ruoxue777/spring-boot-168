package org.ruoxue.spring_boot_168.test.assertj.localdatetime;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class UnitTestLocalDateTimeWithAssertJTest {

	@Test
	public void is() {
		LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
		System.out.println(value);
		Condition<LocalDateTime> year = new Condition<LocalDateTime>(l -> l.getYear() > 2022, "year");
		assertThat(value).is(year);

		value = null;
		System.out.println(value);
		Condition<LocalDateTime> nullz = new Condition<LocalDateTime>(l -> l == null, "null");
		assertThat(value).is(nullz);
	}

	@Test
	public void isNot() {
		LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
		System.out.println(value);
		Condition<LocalDateTime> year = new Condition<LocalDateTime>(l -> l.getYear() > 2023, "year");
		assertThat(value).doesNotHave(year);

		value = null;
		System.out.println(value);
		Condition<LocalDateTime> nullz = new Condition<LocalDateTime>(l -> l != null, "null");
		assertThat(value).doesNotHave(nullz);
	}

	@Test
	public void isIn() {
		LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
		System.out.println(value);
		assertThat(value).isIn(LocalDateTime.parse("2023-10-31T05:06:07"), LocalDateTime.parse("2023-10-31T06:06:07"));

		value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isIn(LocalDateTime.of(2023, 10, 31, 5, 6, 7), LocalDateTime.of(2023, 10, 31, 6, 6, 7));
	}

	@Test
	public void isNotIn() {
		LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
		System.out.println(value);
		assertThat(value).isNotIn(LocalDateTime.parse("2023-10-31T04:06:07"),
				LocalDateTime.parse("2023-10-31T06:06:07"));

		value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isNotIn(LocalDateTime.of(2023, 10, 31, 4, 6, 7), LocalDateTime.of(2023, 10, 31, 6, 6, 7));
	}

	@Test
	public void isInstanceOf() {
		LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
		System.out.println(value);
		assertThat(value).isInstanceOf(LocalDateTime.class);

		value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isInstanceOf(LocalDateTime.class);
	}

	@Test
	public void isNotInstanceOf() {
		LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
		System.out.println(value);
		assertThat(value).isNotInstanceOf(LocalDate.class);

		value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isNotInstanceOf(LocalDate.class);
	}
}
