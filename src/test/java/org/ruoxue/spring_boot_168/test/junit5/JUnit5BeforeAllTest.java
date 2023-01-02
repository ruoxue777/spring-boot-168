package org.ruoxue.spring_boot_168.test.junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class JUnit5BeforeAllTest {

	@BeforeAll
	public static void beforeAll() throws Exception {
		System.out.println("beforeAll");
	}

	@AfterAll
	public static void afterAll() throws Exception {
		System.out.println("afterAll");
	}

	@BeforeEach
	public void beforeEach() throws Exception {
		System.out.println("beforeEach");
	}

	@AfterEach
	public void afterEach() throws Exception {
		System.out.println("afterEach");
	}

	@RepeatedTest(value = 2)
	public void javaWorld() {
		System.out.println("Java World");
	}
}
