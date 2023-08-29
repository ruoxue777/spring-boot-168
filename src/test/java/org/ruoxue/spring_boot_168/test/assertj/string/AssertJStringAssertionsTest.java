package org.ruoxue.spring_boot_168.test.assertj.string;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AssertJStringAssertionsTest {

	@Test
	public void contains() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).contains("AssertJ", "155");
		assertThat(value).contains("rtJ", "5");
	}

	@Test
	public void doesNotContain() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).doesNotContain("JUnit", "151");
		assertThat(value).doesNotContain("nit", "51");
	}

	@Test
	public void containsOnlyOnce() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).containsOnlyOnce("rtJ");
		assertThat(value).containsOnlyOnce("55");
	}

	@Test
	public void containsOnlyWhitespaces() {
		String value = " ";
		System.out.println(value);
		assertThat(value).containsOnlyWhitespaces();
		value = "   ";
		System.out.println(value);
		assertThat(value).containsOnlyWhitespaces();
	}

	@Test
	public void doesNotContainOnlyWhitespaces() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).doesNotContainOnlyWhitespaces();
		value = "AssertJ ";
		System.out.println(value);
		assertThat(value).doesNotContainOnlyWhitespaces();
	}

	@Test
	public void containsOnlyDigits() {
		String value = "155";
		System.out.println(value);
		assertThat(value).containsOnlyDigits();
		value = "5";
		System.out.println(value);
		assertThat(value).containsOnlyDigits();
	}

	@Test
	public void containsWhitespaces() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).containsWhitespaces();
		value = " ";
		System.out.println(value);
		assertThat(value).containsWhitespaces();
	}

	@Test
	public void doesNotContainAnyWhitespaces() {
		String value = "AssertJ155";
		System.out.println(value);
		assertThat(value).doesNotContainAnyWhitespaces();
		value = "AssertJ";
		System.out.println(value);
		assertThat(value).doesNotContainAnyWhitespaces();
	}
}
