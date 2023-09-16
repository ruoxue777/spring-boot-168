package org.ruoxue.spring_boot_168.test.assertj.number;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.within;

import org.junit.jupiter.api.Test;

public class AssertingNumbersTest {

	@Test
	public void matches() {
		int value = 155;
		System.out.println(value);
		assertThat(value).matches(i -> i > 150);

		double doubleValue = 151.2d;
		System.out.println(doubleValue);
		assertThat(doubleValue).matches(i -> Double.compare(i, 155) < 0);
	}

	@Test
	public void matchesWithDescription() {
		int value = 155;
		System.out.println(value);
		assertThat(value).matches(i -> i > 150, "greaterThan");

		double doubleValue = 151.2d;
		System.out.println(doubleValue);
		assertThat(doubleValue).matches(i -> Double.compare(i, 155) < 0, "lessThan");
	}

	@Test
	public void matchesThrowError() {
		assertThatCode(() -> {
			int value = 155;
			System.out.println(value);
			assertThat(value).matches(i -> i < 150, "greaterThan");
		}).isInstanceOf(AssertionError.class);

		assertThatCode(() -> {
			double doubleValue = 151.2d;
			System.out.println(doubleValue);
			assertThat(doubleValue).matches(i -> Double.compare(i, 155) > 0, "lessThan");
		}).isInstanceOf(AssertionError.class);
	}

	@Test
	public void satisfies() {
		int value = 155;
		System.out.println(value);
		assertThat(value).satisfies(i -> {
			assertThat(i).isNotZero();
			assertThat(i).isCloseTo(150, within(5));
		});

		double doubleValue = 151.2d;
		System.out.println(doubleValue);
		assertThat(doubleValue).satisfies(i -> {
			assertThat(i).isPositive();
		}, i -> {
			assertThat(i).isGreaterThan(150);
		});
	}

	@Test
	public void satisfiesAnyOf() {
		int value = 155;
		System.out.println(value);
		assertThat(value).satisfiesAnyOf(i -> {
			assertThat(i).isNotZero();
			assertThat(i).isCloseTo(150, within(5));
		});

		double doubleValue = 151.2d;
		System.out.println(doubleValue);
		assertThat(doubleValue).satisfiesAnyOf(i -> {
			assertThat(i).isPositive();
		}, i -> {
			assertThat(i).isGreaterThan(155);
		});
	}

	@Test
	public void satisfiesThrowError() {
		assertThatCode(() -> {
			int value = 155;
			System.out.println(value);
			assertThat(value).satisfies(i -> {
				assertThat(i).isNotZero();
				assertThat(i).isCloseTo(170, within(5));
			});
		}).isInstanceOf(AssertionError.class);

		assertThatCode(() -> {
			double doubleValue = 151.2d;
			System.out.println(doubleValue);
			assertThat(doubleValue).satisfies(i -> {
				assertThat(i).isPositive();
			}, i -> {
				assertThat(i).isGreaterThan(160);
			});
		}).isInstanceOf(AssertionError.class);
	}
}
