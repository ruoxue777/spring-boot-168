package org.ruoxue.spring_boot_168.test.assertj.exception;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AssertJExceptionAssertionsTest {

	protected int divide(int value1, int value2) {
		return value1 / value2;
	}

	@Test
	public void isInstanceOf() {
		List<String> list = Arrays.asList("AssertJ", "155");
		assertThatThrownBy(() -> {
			list.get(2);
		}).isInstanceOf(IndexOutOfBoundsException.class);
		assertThatThrownBy(() -> divide(1, 0)).isInstanceOf(ArithmeticException.class);

		assertThatCode(() -> list.get(2)).isInstanceOf(IndexOutOfBoundsException.class);
		assertThatCode(() -> divide(1, 0)).isInstanceOf(ArithmeticException.class);
	}

	@Test
	public void hasMessage() {
		List<String> list = Arrays.asList("AssertJ", "155");
		assertThatThrownBy(() -> {
			list.get(2);
		}).hasMessage("2").hasMessageContaining("2").hasMessageMatching("2");
		assertThatThrownBy(() -> divide(1, 0)).hasMessage("/ by zero").hasMessageContaining("zero")
				.hasMessageMatching("/ by zero");

		assertThatCode(() -> list.get(2)).hasMessage("2").hasMessageContaining("2").hasMessageMatching("2");
		assertThatCode(() -> divide(1, 0)).hasMessage("/ by zero").hasMessageContaining("zero")
				.hasMessageMatching("/ by zero");
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
		
		assertThatCode(() -> {
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

	@Test
	public void noException() {
		assertThatNoException().isThrownBy(() -> {
		});

		assertThatCode(() -> {
		}).doesNotThrowAnyException();
	}

}
