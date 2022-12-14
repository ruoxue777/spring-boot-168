package org.ruoxue.spring_boot_168.test.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class JUnit5ExpectedExceptionTest {

	@Test
	public void numberFormatException() {
		Exception exception = assertThrows(NumberFormatException.class, () -> {
			Integer.parseInt("1A");
		});

		String expectedMessage = "For input string";
		String actualMessage = exception.getMessage();
		System.out.println(actualMessage);

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void runtimeException() {
		Exception exception = assertThrows(RuntimeException.class, () -> {
			Integer.parseInt("1A");
		});

		String expectedMessage = "For input string";
		String actualMessage = exception.getMessage();
		System.out.println(actualMessage);

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void arithmeticException() {
		Exception exception = assertThrows(ArithmeticException.class, () -> {
			System.out.println(1 / 0);
		});

		String expectedMessage = "/ by zero";
		String actualMessage = exception.getMessage();
		System.out.println(actualMessage);

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void nameNotFoundException() {
		Exception exception = assertThrows(NameNotFoundException.class, () -> findByName("ruoxue"));

		String expectedMessage = "not found";
		String actualMessage = exception.getMessage();
		System.out.println(actualMessage);

		assertTrue(actualMessage.contains(expectedMessage));
	}

	public String findByName(String name) throws NameNotFoundException {
		throw new NameNotFoundException(name + " not found");
	}

	public class NameNotFoundException extends Exception {

		private static final long serialVersionUID = -2216858914752574276L;

		public NameNotFoundException(String message) {
			super(message);
		}
	}
}
