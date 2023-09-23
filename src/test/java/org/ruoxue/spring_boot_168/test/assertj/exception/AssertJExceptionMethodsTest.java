package org.ruoxue.spring_boot_168.test.assertj.exception;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.BDDAssertions.thenCode;
import static org.assertj.core.api.BDDAssertions.thenNoException;

import java.io.IOException;

public class AssertJExceptionMethodsTest {

	@Test
	public void noException() {
		assertThatNoException().isThrownBy(() -> {
		});

		thenNoException().isThrownBy(() -> {
		});

		assertThatCode(() -> {
		}).doesNotThrowAnyException();

		thenCode(() -> {
		}).doesNotThrowAnyException();
	}

	@Test
	public void exception() {
		assertThatException().isThrownBy(() -> {
			throw new Exception("ex");
		}).withMessage("ex").withStackTraceContaining("Exception");
	}

	@Test
	public void illegalArgumentException() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			throw new IllegalArgumentException("illegal");
		}).withMessage("illegal").withStackTraceContaining("IllegalArgumentException");
	}

	@Test
	public void illegalStateException() {
		assertThatIllegalStateException().isThrownBy(() -> {
			throw new IllegalStateException("illegal");
		}).withMessage("illegal").withStackTraceContaining("IllegalStateException");
	}

	@Test
	public void indexOutOfBoundsException() {
		assertThatIndexOutOfBoundsException().isThrownBy(() -> {
			throw new IndexOutOfBoundsException("index");
		}).withMessage("index").withStackTraceContaining("IndexOutOfBoundsException");
	}

	@Test
	public void ioException() {
		assertThatIOException().isThrownBy(() -> {
			throw new IOException("io");
		}).withMessage("io").withStackTraceContaining("IOException");
	}

	@Test
	public void nullPointerException() {
		assertThatNullPointerException().isThrownBy(() -> {
			throw new NullPointerException("null");
		}).withMessage("null").withStackTraceContaining("NullPointerException");
	}

	@Test
	public void runtimeException() {
		assertThatRuntimeException().isThrownBy(() -> {
			throw new RuntimeException("run");
		}).withMessage("run").withStackTraceContaining("RuntimeException");
	}
}
