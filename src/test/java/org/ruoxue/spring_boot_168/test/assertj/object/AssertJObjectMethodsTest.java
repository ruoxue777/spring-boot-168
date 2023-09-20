package org.ruoxue.spring_boot_168.test.assertj.object;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AssertJObjectMethodsTest {

	@Test
	public void isNull() {
		Object value = null;
		System.out.println(value);
		assertThat(value).isNull();

		Object value2 = null;
		System.out.println(value2);
		assertThat(value2).isNull();
	}

	@Test
	public void isNotNull() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).isNotNull();

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).isNotNull();
	}

	@Test
	public void isEmpty() {
		Object value = "";
		System.out.println(value);
		assertThat(value).isEmpty();

		Object value2 = "";
		System.out.println(value2);
		assertThat(value2).isEmpty();
	}

	@Test
	public void isNotEmpty() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).isNotEmpty();

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).isNotEmpty();
	}

	@Test
	public void isNullOrEmpty() {
		Object value = null;
		System.out.println(value);
		assertThat(value).isNullOrEmpty();
		value = "";
		System.out.println(value);
		assertThat(value).isNullOrEmpty();
	}

	@Test
	public void isEqualTo() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).isEqualTo("AssertJ 155");

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).isEqualTo("AssertJ");
	}

	@Test
	public void isNotEqualTo() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).isNotEqualTo("AssertJ");

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).isNotEqualTo("JUnit");
	}

	@Test
	public void isSameAs() {
		Object value = "AssertJ 155";
		Object value2 = value;
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isSameAs(value2);

		value = "AssertJ";
		value2 = value;
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isSameAs(value2);
	}

	@Test
	public void isNotSameAs() {
		Object value = "AssertJ 155";
		Object value2 = new Object("AssertJ 155");
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isNotSameAs(value2);

		value = "AssertJ";
		value2 = new Object("AssertJ");
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isNotSameAs(value2);
	}
}
