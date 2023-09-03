package org.ruoxue.spring_boot_168.test.assertj.localdatetime;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

public class AssertJLocalDateTimeMethodsTest {

	@Test
	public void isNull() {
		LocalDateTime value = null;
		System.out.println(value);
		assertThat(value).isNull();

		LocalDateTime value2 = null;
		System.out.println(value2);
		assertThat(value2).isNull();
	}

	@Test
	public void isNotNull() {
		LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
		System.out.println(value);
		assertThat(value).isNotNull();

		value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isNotNull();
	}

	@Test
	public void isEqualTo() {
		LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
		System.out.println(value);
		assertThat(value).isEqualTo(LocalDateTime.of(2023, 10, 31, 5, 6, 7));

		value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isEqualTo(LocalDateTime.parse("2023-10-31T05:06:07"));
	}

	@Test
	public void isNotEqualTo() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isNotEqualTo(LocalDateTime.parse("2023-10-31T00:00:00"));

		value = LocalDateTime.parse("2023-10-31T00:00:00");
		System.out.println(value);
		assertThat(value).isNotEqualTo(LocalDateTime.of(2023, 10, 31, 5, 6, 7));
	}

	@Test
	public void isSameAs() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		LocalDateTime value2 = value;
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isSameAs(value2);

		value = LocalDateTime.parse("2023-10-31T05:06:07");
		value2 = value;
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isSameAs(value2);
	}

	@Test
	public void isNotSameAs() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		LocalDateTime value2 = LocalDateTime.parse("2023-10-31T05:06:07");
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isNotSameAs(value2);

		value = LocalDateTime.parse("2023-10-31T05:06:07");
		value2 = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isNotSameAs(value2);
	}

	@Test
	public void isEqualToThrowError() {
		LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
		System.out.println(value);
		assertThat(value).isEqualTo(LocalDateTime.of(2023, 10, 31, 5, 6, 8));
	}

	@Test
	public void isEqualToThrownBy() {
		assertThatThrownBy(() -> {
			LocalDateTime value = LocalDateTime.parse("2023-10-31T05:06:07");
			System.out.println(value);
			assertThat(value).isEqualTo(LocalDateTime.of(2023, 10, 31, 5, 6, 8));
		}).isInstanceOf(AssertionError.class);
	}

}
