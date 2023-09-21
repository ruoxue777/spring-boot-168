package org.ruoxue.spring_boot_168.test.assertj.object;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class UnitTestObjectWithAssertJTest {

	@Test
	public void is() {
		Object value = "AssertJ";
		System.out.println(value);
		Condition<Object> equals = new Condition<Object>(o -> o.equals("AssertJ"), "equals");
		System.out.println(value);
		assertThat(value).is(equals);

		value = BigDecimal.valueOf(155);
		System.out.println(value);
		Condition<Object> toString = new Condition<Object>(o -> o.toString().equals("155"), "toString");
		System.out.println(value);
		assertThat(value).is(toString);

	}

	@Test
	public void isNot() {
		Object value = "AssertJ";
		System.out.println(value);
		Condition<Object> equals = new Condition<Object>(o -> o.equals("155"), "equals");
		System.out.println(value);
		assertThat(value).isNot(equals);

		value = BigDecimal.valueOf(155);
		System.out.println(value);
		Condition<Object> toString = new Condition<Object>(o -> o.toString().equals("AssertJ"), "toString");
		System.out.println(value);
		assertThat(value).isNot(toString);
	}

	@Test
	public void isIn() {
		Object value = "AssertJ";
		System.out.println(value);
		assertThat(value).isIn("AssertJ", "JUnit");

		value = BigDecimal.valueOf(155);
		System.out.println(value);
		assertThat(value).isIn(BigDecimal.valueOf(155), BigDecimal.valueOf(151));
	}

	@Test
	public void isNotIn() {
		Object value = "AssertJ";
		System.out.println(value);
		assertThat(value).isNotIn("JUnit", "Mockito");

		value = BigDecimal.valueOf(155);
		System.out.println(value);
		assertThat(value).isNotIn(BigDecimal.valueOf(151), BigDecimal.valueOf(152));
	}

	@Test
	public void isInstanceOf() {
		Object value = "AssertJ";
		System.out.println(value);
		assertThat(value).isInstanceOf(String.class);

		value = BigDecimal.valueOf(155);
		System.out.println(value);
		assertThat(value).isInstanceOf(BigDecimal.class);
	}

	@Test
	public void isNotInstanceOf() {
		Object value = "AssertJ";
		System.out.println(value);
		assertThat(value).isNotInstanceOf(String[].class);

		value = BigDecimal.valueOf(155);
		System.out.println(value);
		assertThat(value).isNotInstanceOf(BigDecimal[].class);
	}
}
