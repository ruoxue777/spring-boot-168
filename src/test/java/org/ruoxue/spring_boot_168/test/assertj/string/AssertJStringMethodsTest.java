package org.ruoxue.spring_boot_168.test.assertj.string;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AssertJStringMethodsTest {

	@Test
	public void isNull() {
		String value = null;
		System.out.println(value);
		assertThat(value).isNull();

		String value2 = null;
		System.out.println(value2);
		assertThat(value2).isNull();
	}

	@Test
	public void isNotNull() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).isNotNull();

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).isNotNull();
	}

	@Test
	public void isEmpty() {
		String value = "";
		System.out.println(value);
		assertThat(value).isEmpty();

		String value2 = "";
		System.out.println(value2);
		assertThat(value2).isEmpty();
	}

	@Test
	public void isNotEmpty() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).isNotEmpty();

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).isNotEmpty();
	}

	@Test
	public void isNullOrEmpty() {
		String value = null;
		System.out.println(value);
		assertThat(value).isNullOrEmpty();
		value = "";
		System.out.println(value);
		assertThat(value).isNullOrEmpty();
	}

	@Test
	public void isEqualTo() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).isEqualTo("AssertJ 155");

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).isEqualTo("AssertJ");

	}

	@Test
	public void isNotEqualTo() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).isNotEqualTo("AssertJ");

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).isNotEqualTo("JUnit");
	}

	@Test
	public void isSameAs() {
		String value = "AssertJ 155";
		String value2 = value;
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
		String value = "AssertJ 155";
		String value2 = new String("AssertJ 155");
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isNotSameAs(value2);

		value = "AssertJ";
		value2 = new String("AssertJ");
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isNotSameAs(value2);
	}
}
