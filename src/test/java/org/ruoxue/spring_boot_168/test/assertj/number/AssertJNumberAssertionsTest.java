package org.ruoxue.spring_boot_168.test.assertj.number;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

public class AssertJNumberAssertionsTest {

	@Test
	public void isZero() {
		int value = 0;
		System.out.println(value);
		assertThat(value).isZero();

		double doubleValue = 0d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isZero();
	}

	@Test
	public void isNotZero() {
		int value = 155;
		System.out.println(value);
		assertThat(value).isNotZero();

		double doubleValue = 151.2d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isNotZero();
	}

	@Test
	public void isPositive() {
		int value = 155;
		System.out.println(value);
		assertThat(value).isPositive();

		double doubleValue = 151.2d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isPositive();
	}

	@Test
	public void isNotPositive() {
		int value = -155;
		System.out.println(value);
		assertThat(value).isNotPositive();

		double doubleValue = -151.2d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isNotPositive();
	}

	@Test
	public void isOne() {
		int value = 1;
		System.out.println(value);
		assertThat(value).isOne();

		double doubleValue = 1d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isOne();
	}

	@Test
	public void isOdd() {
		int value = 151;
		System.out.println(value);
		assertThat(value).isOdd();

		value = 1;
		System.out.println(value);
		assertThat(value).isOdd();
	}

	@Test
	public void isEven() {
		int value = 156;
		System.out.println(value);
		assertThat(value).isEven();

		value = 2;
		System.out.println(value);
		assertThat(value).isEven();
	}

	@Test
	public void isCloseTo() {
		int value = 155;
		System.out.println(value);
		assertThat(value).isCloseTo(150, Offset.offset(5));
		assertThat(value).isCloseTo(160, Offset.offset(5));

		double doubleValue = 151.2d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isCloseTo(146d, offset(5.2d));
		assertThat(doubleValue).isCloseTo(156d, offset(5.2d));
	}

	@Test
	public void isNotCloseTo() {
		int value = 155;
		System.out.println(value);
		assertThat(value).isNotCloseTo(145, Offset.offset(5));
		assertThat(value).isNotCloseTo(165, Offset.offset(5));

		double doubleValue = 151.2d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isNotCloseTo(141d, offset(5.2d));
		assertThat(doubleValue).isNotCloseTo(161d, offset(5.2d));
	}

	@Test
	public void isCloseToWithin() {
		int value = 155;
		System.out.println(value);
		assertThat(value).isCloseTo(150, within(5));
		assertThat(value).isCloseTo(160, within(5));

		double doubleValue = 151.2d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isCloseTo(146d, within(5.2d));
		assertThat(doubleValue).isCloseTo(156d, within(5.2d));
	}

	@Test
	public void isNotCloseToWithin() {
		int value = 155;
		System.out.println(value);
		assertThat(value).isNotCloseTo(145, within(5));
		assertThat(value).isNotCloseTo(165, within(5));

		double doubleValue = 151.2d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isNotCloseTo(141d, within(5.2d));
		assertThat(doubleValue).isNotCloseTo(161d, within(5.2d));
	}
}
