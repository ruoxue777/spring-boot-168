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
		Condition<Object> equals = new Condition<Object>(o -> o.equals("AssertJ"), "equals");
		assertThat(value).has(equals);

		value = BigDecimal.valueOf(155);
		System.out.println(value);
		Condition<Object> toString = new Condition<Object>(o -> o.toString().equals("155"), "toString");
		assertThat(value).has(toString);
	}

	@Test
	public void hasSameClassAs() {
		Object value = "AssertJ";
		System.out.println(value);
		assertThat(value).hasSameClassAs("151");

		value = BigDecimal.valueOf(155);
		System.out.println(value);
		assertThat(value).hasSameClassAs(BigDecimal.valueOf(151));
	}

	@Test
	public void hasSameHashCodeAs() {
		Object value = "AssertJ";
		System.out.println(value);
		assertThat(value).hasSameHashCodeAs("AssertJ");

		value = BigDecimal.valueOf(155);
		System.out.println(value);
		assertThat(value).hasSameHashCodeAs(BigDecimal.valueOf(155));
	}

	@Test
	public void hasToString() {
		Object value = "AssertJ";
		System.out.println(value);
		assertThat(value).hasToString("AssertJ");

		value = BigDecimal.valueOf(155);
		System.out.println(value);
		assertThat(value).hasToString("155");
	}

	@Test
	public void doesNotHave() {
		Object value = "AssertJ";
		System.out.println(value);
		Condition<Object> equals = new Condition<Object>(o -> o.equals("155"), "equals");
		assertThat(value).doesNotHave(equals);

		value = BigDecimal.valueOf(155);
		System.out.println(value.toString());
		Condition<Object> toString = new Condition<Object>(o -> o.toString().equals("AssertJ"), "toString");
		assertThat(value).doesNotHave(toString);
	}

	@Test
	public void doesNotHaveSameClassAs() {
		Object value = "AssertJ";
		System.out.println(value);
		assertThat(value).doesNotHaveSameClassAs(BigDecimal.valueOf(155));

		value = BigDecimal.valueOf(155);
		System.out.println(value);
		assertThat(value).doesNotHaveSameClassAs("AssertJ");
	}

	@Test
	public void doesNotHaveSameHashCodeAs() {
		Object value = "AssertJ";
		System.out.println(value);
		assertThat(value).doesNotHaveSameHashCodeAs(BigDecimal.valueOf(155));

		value = BigDecimal.valueOf(155);
		System.out.println(value);
		assertThat(value).doesNotHaveSameHashCodeAs("AssertJ");
	}

	@Test
	public void doesNotHaveToString() {
		Object value = "AssertJ";
		System.out.println(value);
		assertThat(value).doesNotHaveToString("155");

		value = BigDecimal.valueOf(155);
		System.out.println(value);
		assertThat(value).doesNotHaveToString("AssertJ");
	}
}
