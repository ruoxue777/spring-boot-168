package org.ruoxue.spring_boot_168.test.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

@DisplayName("JUnit World")
public class JUnit5Test {

	@BeforeAll
	public static void beforeAll() {
		System.out.println("beforeAll");
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("afterAll");
	}

	@BeforeEach
	public void beforeEach() {
		System.out.println("beforeEach");
	}

	@AfterEach
	public void afterEach() throws Exception {
		System.out.println("afterEach");
	}

	@DisplayName("Hello World")
	@Test
	public void helloWorld() {
		System.out.println("Hello World");
	}

	@DisplayName("Java World")
	@Test
	public void javaWorld() {
		System.out.println("Java World");
	}
	
	@RepeatedTest(3)
	public void repeatedHelloWorld() {
		System.out.println("Hello World");
	}

	@RepeatedTest(3)
	public void repeatedJavaWorld() {
		System.out.println("Java World");
	}

	@RepeatedTest(value = 3, name = "{displayName} {currentRepetition}/{totalRepetitions}")
	public void repeatedHelloWorld_2() {
		System.out.println("Hello World");
	}

	@RepeatedTest(value = 3, name = RepeatedTest.LONG_DISPLAY_NAME)
	public void repeatedHelloWorld_3() {
		System.out.println("Hello World");
	}

	@RepeatedTest(value = 3)
	public void repeatedHelloWorld_4(RepetitionInfo repetitionInfo) {
		System.out.println("Hello World");
		System.out.println("Repetition #" + repetitionInfo.getCurrentRepetition());
		assertEquals(3, repetitionInfo.getTotalRepetitions());
	}
}