package org.ruoxue.spring_boot_168.test.assertj.object;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AssertJObjectAssertionsTest {

	@Test
	public void contains() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).contains("AssertJ", "155");
		assertThat(value).contains("rtJ", "5");
	}

	@Test
	public void doesNotContain() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).doesNotContain("JUnit", "151");
		assertThat(value).doesNotContain("nit", "51");
	}

	@Test
	public void containsOnlyOnce() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).containsOnlyOnce("rtJ");
		assertThat(value).containsOnlyOnce("55");
	}

	@Test
	public void containsOnlyWhitespaces() {
		Object value = " ";
		System.out.println(value);
		assertThat(value).containsOnlyWhitespaces();
		value = "   ";
		System.out.println(value);
		assertThat(value).containsOnlyWhitespaces();
	}

	@Test
	public void doesNotContainOnlyWhitespaces() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).doesNotContainOnlyWhitespaces();
		value = "AssertJ ";
		System.out.println(value);
		assertThat(value).doesNotContainOnlyWhitespaces();
	}

	@Test
	public void containsOnlyDigits() {
		Object value = "155";
		System.out.println(value);
		assertThat(value).containsOnlyDigits();
		value = "5";
		System.out.println(value);
		assertThat(value).containsOnlyDigits();
	}

	@Test
	public void containsWhitespaces() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).containsWhitespaces();
		value = " ";
		System.out.println(value);
		assertThat(value).containsWhitespaces();
	}

	@Test
	public void doesNotContainAnyWhitespaces() {
		Object value = "AssertJ155";
		System.out.println(value);
		assertThat(value).doesNotContainAnyWhitespaces();
		value = "AssertJ";
		System.out.println(value);
		assertThat(value).doesNotContainAnyWhitespaces();
	}
}
