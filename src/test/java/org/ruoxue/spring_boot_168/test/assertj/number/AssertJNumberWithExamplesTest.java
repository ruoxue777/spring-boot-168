package org.ruoxue.spring_boot_168.test.assertj.number;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class AssertJNumberWithExamplesTest {

	@Test
	public void has() {
		int value = 0;
		System.out.println(value);
		Condition<Integer> equals = new Condition<Integer>(i -> i == 0, "equals");
		assertThat(value).has(equals);

		double doubleValue = 0d;
		System.out.println(doubleValue);
		Condition<Double> doubleEquals = new Condition<Double>(i -> Double.compare(i, 0) == 0, "equals");
		assertThat(doubleValue).has(doubleEquals);
	}

	@Test
	public void hasToString() {
		int value = 0;
		System.out.println(value);
		assertThat(value).hasToString(Integer.valueOf(value).toString());

		double doubleValue = 0d;
		System.out.println(doubleValue);
		assertThat(doubleValue).hasToString(Double.valueOf(doubleValue).toString());
	}

	@Test
	public void hasSameClassAs() {
		int value = 0;
		System.out.println(value);
		assertThat(value).hasSameClassAs(0);

		double doubleValue = 0d;
		System.out.println(doubleValue);
		assertThat(doubleValue).hasSameClassAs(0d);
	}

	@Test
	public void returns() {
		int value = 0;
		System.out.println(value);
		assertThat(value).returns(1, i -> new Integer(i + 1));

		double doubleValue = 0d;
		System.out.println(doubleValue);
		assertThat(doubleValue).returns(1d, i -> new Double(i + 1));
	}

	@Test
	public void doesNotHave() {
		int value = 0;
		System.out.println(value);
		Condition<Integer> notEquals = new Condition<Integer>(i -> i != 0, "notEquals");
		assertThat(value).doesNotHave(notEquals);

		double doubleValue = 0d;
		System.out.println(doubleValue);
		Condition<Double> doubleNotEquals = new Condition<Double>(i -> Double.compare(i, 0) != 0, "notEquals");
		assertThat(doubleValue).doesNotHave(doubleNotEquals);
	}

	@Test
	public void doesNotHaveSameClassAs() {
		int value = 0;
		System.out.println(value);
		assertThat(value).doesNotHaveSameClassAs(0d);

		double doubleValue = 0d;
		System.out.println(doubleValue);
		assertThat(doubleValue).doesNotHaveSameClassAs(0);
	}

	@Test
	public void doesNotReturn() {
		int value = 0;
		System.out.println(value);
		assertThat(value).doesNotReturn(2, i -> new Integer(i + 1));

		double doubleValue = 0d;
		System.out.println(doubleValue);
		assertThat(doubleValue).doesNotReturn(2d, i -> new Double(i + 1));
	}
}
