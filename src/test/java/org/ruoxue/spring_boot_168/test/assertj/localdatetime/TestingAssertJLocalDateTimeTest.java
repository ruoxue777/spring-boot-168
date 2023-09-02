package org.ruoxue.spring_boot_168.test.assertj.localdatetime;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class TestingAssertJLocalDateTimeTest {

	@Test
	public void isBefore() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).isBefore(other)
//		assertThat(value).isLessThan("aS").isLessThan("At");
	}

	@Test
	public void isBeforeOrEqualTo() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).isBeforeOrEqualTo(other)
//		assertThat(value).isLessThanOrEqualTo("assertj 155").isLessThanOrEqualTo("At");
	}

	@Test
	public void isAfter() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).isAfter(other)
//		assertThat(value).isGreaterThan("aS").isGreaterThan("aT");
	}

	@Test
	public void isAfterOrEqualTo() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).isAfterOrEqualTo(other)
//		assertThat(value).isGreaterThanOrEqualTo("assertj 155").isGreaterThanOrEqualTo("aT");
	}

	@Test
	public void isBetween() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).isBetween(startInclusive, endInclusive);
//		assertThat(value).isGreaterThanOrEqualTo("assertj 155").isGreaterThanOrEqualTo("aT");
	}

	@Test
	public void usingDefaultComparator() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		assertThat(value).usingDefaultComparator().contains("AssertJ", "155").doesNotContain("rtJx");
//		value = "AssertJ";
//		assertThat(value).usingDefaultComparator().startsWith("Ass").endsWith("rtJ");
	}

	@Test
	public void usingComparator() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		Comparator<String> ignoreCaseComparator = (s1, s2) -> s1.toLowerCase().compareTo(s2.toLowerCase());
//		assertThat(value).usingComparator(ignoreCaseComparator).contains("ASSERTJ", "155").doesNotContain("RTJX");
//		value = "AssertJ";
//		assertThat(value).usingComparator(ignoreCaseComparator).startsWith("ASS").endsWith("rtJ");
	}

	@Test
	public void usingComparatorWithDescription() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
//		Comparator<String> ignoreCaseComparator = (s1, s2) -> s1.toLowerCase().compareTo(s2.toLowerCase());
//		assertThat(value).usingComparator(ignoreCaseComparator, "ignoreCase").contains("ASSERTJ", "155")
//				.doesNotContain("RTJX");
//		value = "AssertJ";
//		assertThat(value).usingComparator(ignoreCaseComparator, "ignoreCase").startsWith("ASS").endsWith("rtJ");
	}
}
