package org.ruoxue.spring_boot_168.test.assertj.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class UnitTestAssertJStringWithExamplesTest {

	@Test
	public void containsAnyOf() {
		String value = "Assertj 155";
		System.out.println(value);
		assertThat(value).containsAnyOf("Assertj", "Junit");
		assertThat(value).containsAnyOf("155", "151");
	}

	@Test
	public void containsIgnoringCase() {
		String value = "Assertj 155";
		System.out.println(value);
		assertThat(value).containsIgnoringCase("assertj");
		assertThat(value).containsIgnoringCase("RTJ");
	}

	@Test
	public void doesNotContainIgnoringCase() {
		String value = "Assertj 155";
		System.out.println(value);
		assertThat(value).doesNotContainIgnoringCase("junit");
		assertThat(value).doesNotContainIgnoringCase("NIT");
	}

	@Test
	public void containsIgnoringWhitespaces() {
		String value = "Assertj 155";
		System.out.println(value);
		assertThat(value).containsIgnoringWhitespaces("Assertj ");
		assertThat(value).containsIgnoringWhitespaces(" 155");
	}

	@Test
	public void containsIgnoringNewLines() {
		String value = "Asser\ntj 1\n55\n ";
		System.out.println(value);
		assertThat(value).containsIgnoringNewLines("Assertj", "155");
		assertThat(value).containsIgnoringNewLines("rtj", "155");
	}

//	@Test
//	public void containsPattern() {
//		String value = "Assertj 155";
//		System.out.println(value);
//		assertThat(value).containsSequence("Guava", "Pitaya");
//	}
//	
//	@Test
//	public void doesNotContainPattern() {
//		String value = "Assertj 155";
//		System.out.println(value);
//		assertThat(value).containsSequence("Guava", "Pitaya");
//	}

	@Test
	public void containsSequence() {
		String value = "Assertj 155 JUnit 151";
		System.out.println(value);
		assertThat(value).containsSequence("Assertj", " ", "155");
		assertThat(value).containsSequence("JUnit", " ", "151");
	}

	@Test
	public void containsSubsequence() {
		String value = "Assertj 155 JUnit 151";
		System.out.println(value);
		assertThat(value).containsSubsequence("Assertj", "JUnit");
		assertThat(value).containsSubsequence("155", " ", "151");
	}
}
