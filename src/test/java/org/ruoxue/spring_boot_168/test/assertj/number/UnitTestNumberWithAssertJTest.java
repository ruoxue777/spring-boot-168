package org.ruoxue.spring_boot_168.test.assertj.number;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class UnitTestNumberWithAssertJTest {

	@Test
	public void is() {
		int value = 1;
		System.out.println(value);
		Condition<Integer> greaterThan = new Condition<Integer>(i -> i > 0, "greaterThan");
		assertThat(value).is(greaterThan);

		double doubleValue = 1d;
		System.out.println(doubleValue);
		Condition<Double> doubleGreaterThan = new Condition<Double>(i -> Double.compare(i, 0) == 1,
				"doubleGreaterThan");
		assertThat(doubleValue).is(doubleGreaterThan);
	}

	@Test
	public void isNot() {
		int value = 1;
		System.out.println(value);
		Condition<Integer> greaterThan = new Condition<Integer>(i -> i < 0, "greaterThan");
		assertThat(value).isNot(greaterThan);

		double doubleValue = 1d;
		System.out.println(doubleValue);
		Condition<Double> doubleGreaterThan = new Condition<Double>(i -> Double.compare(i, 0) == -1,
				"doubleGreaterThan");
		assertThat(doubleValue).isNot(doubleGreaterThan);
	}

	@Test
	public void isIn() {
		int value = 1;
		System.out.println(value);
		assertThat(value).isIn(1, 3, 5);

		double doubleValue = 1d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isIn(1d, 2d, 3d);
	}

	@Test
	public void isNotIn() {
		int value = 1;
		System.out.println(value);
		assertThat(value).isNotIn(2, 4, 6);

		double doubleValue = 1d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isNotIn(2d, 4d, 6d);
	}

	@Test
	public void isInstanceOf() {
		int value = 1;
		System.out.println(value);
		assertThat(value).isInstanceOf(Integer.class);

		double doubleValue = 1d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isInstanceOf(Double.class);
	}

	@Test
	public void isNotInstanceOf() {
		int value = 1;
		System.out.println(value);
		assertThat(value).isNotInstanceOf(int.class);

		double doubleValue = 1d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isNotInstanceOf(double.class);
	}
}
