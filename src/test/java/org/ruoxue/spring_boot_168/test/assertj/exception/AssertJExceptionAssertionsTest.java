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
	public void hasCause() {
		Exception cause = new Exception("cause");
		Exception runtimeException = new RuntimeException("runtime", cause);
		assertThat(runtimeException).hasCause(cause).hasCauseReference(cause).hasCauseInstanceOf(Exception.class);

		cause = new NullPointerException("null");
		Throwable throwable = new Throwable(cause);
		assertThat(throwable).hasCause(cause).hasCauseInstanceOf(NullPointerException.class)
				.hasCauseInstanceOf(RuntimeException.class).hasCauseExactlyInstanceOf(NullPointerException.class);
	}

	@Test
	public void cause() {
		Exception cause = new Exception("cause");
		Exception runtimeException = new RuntimeException("runtime", cause);
		assertThat(runtimeException).cause().hasMessage("cause").hasMessageMatching("ca.se");

		cause = new NullPointerException("null");
		Throwable throwable = new Throwable(cause);
		assertThat(throwable).cause().hasMessage("null").hasMessageMatching("nu..");
	}

	@Test
	public void hasRootCause() {
		Exception cause = new Exception("cause");
		Exception parentCause = new IllegalStateException(cause);
		Exception runtimeException = new RuntimeException("runtime", parentCause);
		assertThat(runtimeException).hasRootCause(cause).hasRootCauseInstanceOf(Exception.class).hasCause(parentCause)
				.hasCauseInstanceOf(IllegalStateException.class);

		cause = new NullPointerException("null");
		parentCause = new IllegalStateException(cause);
		Throwable throwable = new Throwable(parentCause);
		assertThat(throwable).hasRootCause(cause).hasRootCauseInstanceOf(NullPointerException.class)
				.hasRootCauseInstanceOf(RuntimeException.class)
				.hasRootCauseExactlyInstanceOf(NullPointerException.class).hasCause(parentCause)
				.hasCauseInstanceOf(IllegalStateException.class);
	}
}
