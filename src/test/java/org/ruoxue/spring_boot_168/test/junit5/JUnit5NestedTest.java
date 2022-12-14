package org.ruoxue.spring_boot_168.test.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class JUnit5NestedTest {

	@BeforeEach
	public void beforeEach() throws Exception {
		System.out.println("beforeEach");
	}

	@Nested
	@DisplayName("Hello World")
	public class HelloWorldTest {
		@Test
		public void helloWorld() {
			System.out.println("Hello World");
		}

		@Test
		public void helloWorld_2() {
			System.out.println("Hello World 2");
		}

		@Test
		public void helloWorld_3() {
			System.out.println("Hello World 3");
		}
	}

	@Nested
	@DisplayName("Java World")
	public class JavaWorldTest {
		@Test
		public void javaWorld() {
			System.out.println("Java World");
		}

		@Test
		public void javaWorld_2() {
			System.out.println("Java World 2");
		}

		@Test
		public void javaWorld_3() {
			System.out.println("Java World 3");
		}
	}

	@Disabled
	@Test
	public void helloWorld() {
		System.out.println("Hello World");
	}

	@Test
	public void springWorld() {
		System.out.println("Spring World");
	}
}