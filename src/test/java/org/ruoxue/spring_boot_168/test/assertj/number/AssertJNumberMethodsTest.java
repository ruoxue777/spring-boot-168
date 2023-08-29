package org.ruoxue.spring_boot_168.test.assertj.number;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AssertJNumberMethodsTest {

	@Test
	public void isNull() {
		Integer value = null;
		System.out.println(value);
		assertThat(value).isNull();

		Double doubleValue = null;
		System.out.println(doubleValue);
		assertThat(doubleValue).isNull();
	}

	@Test
	public void isNotNull() {
		Integer value = 155;
		System.out.println(value);
		assertThat(value).isNotNull();

		Double doubleValue = 151.2d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isNotNull();
	}

	@Test
	public void isEqualTo() {
		int value = 155;
		System.out.println(value);
		assertThat(value).isEqualTo(155);

		Double doubleValue = 151.2d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isEqualTo(151.2d);
	}

	@Test
	public void isNotEqualTo() {
		int value = 155;
		System.out.println(value);
		assertThat(value).isNotEqualTo(1);

		Double doubleValue = 151.2d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isNotEqualTo(1.2d);
	}

	@Test
	public void isSameAs() {
		Integer value = 155;
		Integer value2 = value;
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isSameAs(value2);

		Double doubleValue = 151.2d;
		Double doubleValue2 = doubleValue;
		System.out.println(doubleValue);
		System.out.println(doubleValue2);
		assertThat(doubleValue).isSameAs(doubleValue2);
	}

	@Test
	public void isNotSameAs() {
		int value = 155;
		int value2 = value;
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isNotSameAs(value2);

		double doubleValue = 151.2d;
		double doubleValue2 = doubleValue;
		System.out.println(doubleValue);
		System.out.println(doubleValue2);
		assertThat(doubleValue).isNotSameAs(doubleValue2);
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
}
