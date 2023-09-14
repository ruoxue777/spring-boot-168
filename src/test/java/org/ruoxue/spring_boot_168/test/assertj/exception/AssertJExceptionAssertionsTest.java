package org.ruoxue.spring_boot_168.test.assertj.exception;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AssertJExceptionAssertionsTest {

	public int divide(int value1, int value2) {
		return value1 / value2;
	}

	@Test
	public void isInstanceOf() {
		assertThatThrownBy(() -> divide(1, 0)).isInstanceOf(ArithmeticException.class).hasMessageContaining("zero")
				.hasMessage("/ by zero");
	}

	@Test
	public void hasMessageContaining() {
		assertThatThrownBy(() -> {
			List<Integer> list = Arrays.asList(1, 2);
			list.get(2);
		}).isInstanceOf(IndexOutOfBoundsException.class).hasMessageContaining("2");
	}

	@Test
	public void hasCauseInstanceOf() {
		assertThatThrownBy(() -> {
			try {
				throw new IOException();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}).isInstanceOf(RuntimeException.class).hasCauseInstanceOf(IOException.class)
				.hasStackTraceContaining("IOException");
	}

	@Test
	public void exception() {
		Exception ex = new Exception();
		assertThatException().isThrownBy(() -> {
			throw ex;
		}).isEqualTo(ex).withStackTraceContaining("Exception");
	}

	@Test
	public void illegalArgumentException() {
		IllegalArgumentException ex = new IllegalArgumentException();
		assertThatIllegalArgumentException().isThrownBy(() -> {
			throw ex;
		}).isEqualTo(ex).withStackTraceContaining("IllegalArgumentException");
	}
}
