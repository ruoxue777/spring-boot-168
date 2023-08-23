package org.ruoxue.spring_boot_168.test.assertj.string;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class UnitTestAssertJStringWithExamplesTest {

	@Test
	public void containsAnyOf() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).containsAnyOf("AssertJ", "JUnit");
		assertThat(value).containsAnyOf("155", "151");
	}

	@Test
	public void containsIgnoringCase() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).containsIgnoringCase("assertj");
		assertThat(value).containsIgnoringCase("RTJ");
	}

	@Test
	public void doesNotContainIgnoringCase() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).doesNotContainIgnoringCase("junit");
		assertThat(value).doesNotContainIgnoringCase("NIT");
	}

	@Test
	public void containsIgnoringWhitespaces() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).containsIgnoringWhitespaces("AssertJ ");
		assertThat(value).containsIgnoringWhitespaces(" 155");
	}

	@Test
	public void containsIgnoringNewLines() {
		String value = "Asser\ntJ 1\n55\n ";
		System.out.println(value);
		assertThat(value).containsIgnoringNewLines("AssertJ", "155");
		assertThat(value).containsIgnoringNewLines("rtJ", "155");
	}

	@Test
	public void containsPattern() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).containsPattern("As.e");
		assertThat(value).containsPattern("1\\d5");
	}
	
	@Test
	public void doesNotContainPattern() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).doesNotContainPattern("As.x");
		assertThat(value).doesNotContainPattern("1\\d9");
	}

	@Test
	public void containsSequence() {
		String value = "AssertJ 155 JUnit 151";
		System.out.println(value);
		assertThat(value).containsSequence("AssertJ", " ", "155");
		assertThat(value).containsSequence(Arrays.asList("AssertJ", " ", "155"));
		assertThat(value).containsSequence("JUnit", " ", "151");
	}

	@Test
	public void containsSubsequence() {
		String value = "AssertJ 155 JUnit 151";
		System.out.println(value);
		assertThat(value).containsSubsequence("AssertJ", "JUnit");
		assertThat(value).containsSubsequence(Arrays.asList("AssertJ", "JUnit"));
		assertThat(value).containsSubsequence("155", " ", "151");
	}
}
