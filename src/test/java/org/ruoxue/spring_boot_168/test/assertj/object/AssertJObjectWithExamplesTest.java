package org.ruoxue.spring_boot_168.test.assertj.object;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class AssertJObjectWithExamplesTest {

	@Test
	public void has() {
		Object value = "AssertJ";
		System.out.println(value);
		Condition<Object> equals = new Condition<Object>(s -> s.equals("AssertJ"), "equals");
		assertThat(value).has(equals);

		value = BigDecimal.valueOf(155);
		System.out.println(value.toString());
		Condition<Object> toString = new Condition<Object>(s -> s.toString().equals("155"), "toString");
		assertThat(value).has(toString);
	}

//	@Test
//	public void hasSameClassAs() {
//		int expectedSize = 11;
//		Object value = "AssertJ 155";
//		System.out.println(value);
//		assertThat(value).hasSize(expectedSize);
//
//		value = "AssertJ";
//		System.out.println(value);
//		assertThat(value).hasSize(7);
//	}
//
//	@Test
//	public void hasSameHashCodeAs() {
//		int expectedSize = 11;
//		Object value = "AssertJ 155";
//		System.out.println(value);
//		assertThat(value).hasSizeBetween(1, expectedSize);
//
//		value = "AssertJ";
//		System.out.println(value);
//		assertThat(value).hasSizeBetween(1, 7);
//	}
//
//	@Test
//	public void hasToString() {
//		int expectedSize = 2;
//		Object value = "AssertJ 155";
//		System.out.println(value);
//		assertThat(value).hasSizeGreaterThan(expectedSize);
//
//		value = "AssertJ";
//		System.out.println(value);
//		assertThat(value).hasSizeGreaterThan(6);
//	}
//
//	@Test
//	public void doesNotHave() {
//		Object value = "AssertJ 155";
//		System.out.println(value);
//		Condition<Object> length = new Condition<Object>(s -> s.length() > 12, "length");
//		assertThat(value).doesNotHave(length);
//
//		value = "AssertJ";
//		System.out.println(value);
//		Condition<Object> nullz = new Condition<Object>(s -> s == null, "null");
//		assertThat(value).doesNotHave(nullz);
//	}
//	@Test
//	public void doesNotHaveSameClassAs() {
//		Object value = "AssertJ 155";
//		Object value2 = "AssertJ 155";
//		System.out.println(value);
//		System.out.println(value2);
//		assertThat(value).hasSameSizeAs(value2);
//
//		value = "AssertJ";
//		value2 = "AssertJ";
//		System.out.println(value);
//		System.out.println(value2);
//		assertThat(value).hasSameSizeAs(value2);
//	}
//
	//
//	@Test
//	public void doesNotHaveSameHashCodeAs() {
//		int expectedSize = 12;
//		Object value = "AssertJ 155";
//		System.out.println(value);
//		assertThat(value).hasSizeLessThan(expectedSize);
//
//		value = "AssertJ";
//		System.out.println(value);
//		assertThat(value).hasSizeLessThan(8);
//	}
//	@Test
//	public void doesNotHaveToString() {
//		int expectedSize = 12;
//		Object value = "AssertJ 155";
//		System.out.println(value);
//		assertThat(value).hasSizeLessThan(expectedSize);
//
//		value = "AssertJ";
//		System.out.println(value);
//		assertThat(value).hasSizeLessThan(8);
//	}
}
