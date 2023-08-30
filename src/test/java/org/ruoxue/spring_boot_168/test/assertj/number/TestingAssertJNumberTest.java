package org.ruoxue.spring_boot_168.test.assertj.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import java.util.Comparator;
import org.junit.jupiter.api.Test;

public class TestingAssertJNumberTest {

	@Test
	public void isLessThan() {
		int value = 0;
		System.out.println(value);
		assertThat(value).isLessThan(1);

		double doubleValue = 0d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isLessThan(1d);
	}

	@Test
	public void isLessThanOrEqualTo() {
		int value = 0;
		System.out.println(value);
		assertThat(value).isLessThanOrEqualTo(0).isLessThanOrEqualTo(1);

		double doubleValue = 0d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isLessThanOrEqualTo(0d).isLessThanOrEqualTo(1d);
	}

	@Test
	public void isGreaterThan() {
		int value = 0;
		System.out.println(value);
		assertThat(value).isGreaterThan(-1);

		double doubleValue = 0d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isGreaterThan(-1d);
	}

	@Test
	public void isGreaterThanOrEqualTo() {
		int value = 0;
		System.out.println(value);
		assertThat(value).isGreaterThanOrEqualTo(0).isGreaterThanOrEqualTo(-1);

		double doubleValue = 0d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isGreaterThanOrEqualTo(0d).isGreaterThanOrEqualTo(-1d);
	}

	@Test
	public void usingDefaultComparator() {
		int value = 1;
		System.out.println(value);
		assertThat(value).usingDefaultComparator().isPositive().isCloseTo(-4, within(5));

		double doubleValue = 1d;
		System.out.println(doubleValue);
		assertThat(doubleValue).usingDefaultComparator().isPositive().isCloseTo(-4d, within(5d));
	}

	@Test
	public void usingComparator() {
		int value = 1;
		System.out.println(value);
		Comparator<Integer> absComparator = (i1, i2) -> Integer.compare(i1, Math.abs(i2));
		assertThat(value).usingComparator(absComparator).isEqualTo(-1);

		double doubleValue = 1d;
		System.out.println(doubleValue);
		Comparator<Double> doubleAbsComparator = (d1, d2) -> Double.compare(d1, Math.abs(d2));
		assertThat(doubleValue).usingComparator(doubleAbsComparator).isEqualTo(-1d);
	}

	@Test
	public void usingComparatorWithDescription() {
		int value = 1;
		System.out.println(value);
		Comparator<Integer> absComparator = (i1, i2) -> Integer.compare(i1, Math.abs(i2));
		assertThat(value).usingComparator(absComparator, "absComparator").isEqualTo(-1);

		double doubleValue = 1d;
		System.out.println(doubleValue);
		Comparator<Double> doubleAbsComparator = (d1, d2) -> Double.compare(d1, Math.abs(d2));
		assertThat(doubleValue).usingComparator(doubleAbsComparator, "doubleAbsComparator").isEqualTo(-1d);
	}
}
