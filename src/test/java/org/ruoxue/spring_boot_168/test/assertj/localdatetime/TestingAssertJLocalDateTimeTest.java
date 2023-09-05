package org.ruoxue.spring_boot_168.test.assertj.localdatetime;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class TestingAssertJLocalDateTimeTest {

	@Test
	public void isBefore() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isBefore(LocalDateTime.of(2023, 10, 31, 5, 6, 12));
		assertThat(value).isBefore(LocalDateTime.of(2023, 10, 31, 5, 7, 7));
	}

	@Test
	public void isBeforeOrEqualTo() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isBeforeOrEqualTo(LocalDateTime.of(2023, 10, 31, 5, 6, 12));
		assertThat(value).isBeforeOrEqualTo(LocalDateTime.of(2023, 10, 31, 5, 6, 7));
	}

	@Test
	public void isAfter() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isAfter(LocalDateTime.of(2023, 10, 31, 5, 6, 2));
		assertThat(value).isAfter(LocalDateTime.of(2023, 10, 31, 5, 5, 7));
	}

	@Test
	public void isAfterOrEqualTo() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isAfterOrEqualTo(LocalDateTime.of(2023, 10, 31, 5, 6, 2));
		assertThat(value).isAfterOrEqualTo(LocalDateTime.of(2023, 10, 31, 5, 6, 7));
	}

	@Test
	public void isBetween() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isBetween(LocalDateTime.of(2023, 10, 31, 5, 6, 2), LocalDateTime.of(2023, 10, 31, 5, 6, 12));
		assertThat(value).isBetween(LocalDateTime.of(2023, 10, 31, 5, 6, 7), LocalDateTime.of(2023, 10, 31, 6, 6, 7));
	}
	
	@Test
	public void isStrictlyBetween() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isStrictlyBetween(LocalDateTime.of(2023, 10, 31, 5, 6, 2), LocalDateTime.of(2023, 10, 31, 5, 6, 12));
		assertThat(value).isStrictlyBetween(LocalDateTime.of(2023, 10, 31, 5, 6, 6), LocalDateTime.of(2023, 10, 31, 6, 6, 7));
	}	

	@Test
	public void usingDefaultComparator() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).usingDefaultComparator().isEqualTo(LocalDateTime.of(2023, 10, 31, 5, 6, 7));

		value = LocalDateTime.parse("2023-10-31T05:06:07");
		assertThat(value).usingDefaultComparator().isEqualTo(LocalDateTime.of(2023, 10, 31, 5, 6, 7));
	}

	@Test
	public void usingComparator() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		Comparator<LocalDateTime> ignoreTimeComparator = (l1, l2) -> l1.toLocalDate().compareTo(l2.toLocalDate());
		assertThat(value).usingComparator(ignoreTimeComparator).isEqualTo(LocalDateTime.of(2023, 10, 31, 0, 0, 0));

		value = LocalDateTime.parse("2023-10-31T05:06:07");
		assertThat(value).usingComparator(ignoreTimeComparator).isEqualTo(LocalDateTime.of(2023, 10, 31, 0, 0, 0));
	}

	@Test
	public void usingComparatorWithDescription() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		Comparator<LocalDateTime> ignoreTimeComparator = (l1, l2) -> l1.toLocalDate().compareTo(l2.toLocalDate());
		assertThat(value).usingComparator(ignoreTimeComparator, "ignoreTime")
				.isEqualTo(LocalDateTime.of(2023, 10, 31, 0, 0, 0));

		value = LocalDateTime.parse("2023-10-31T05:06:07");
		assertThat(value).usingComparator(ignoreTimeComparator, "ignoreTime")
				.isEqualTo(LocalDateTime.of(2023, 10, 31, 0, 0, 0));
	}
}
