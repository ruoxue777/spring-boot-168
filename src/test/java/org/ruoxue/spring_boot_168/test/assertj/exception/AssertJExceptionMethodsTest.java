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
			throw new Exception("ex !");
		}).withMessage("ex !").withMessage("%s !", "ex").withMessageContaining("ex")
				.withStackTraceContaining("Exception").withNoCause();
	}

	@Test
	public void illegalArgumentException() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			throw new IllegalArgumentException("illegal !");
		}).withMessage("illegal !").withMessage("%s !", "illegal").withMessageContaining("illegal")
				.withStackTraceContaining("IllegalArgumentException").withNoCause();
	}

	@Test
	public void illegalStateException() {
		assertThatIllegalStateException().isThrownBy(() -> {
			throw new IllegalStateException("illegal !");
		}).withMessage("illegal !").withMessage("%s !", "illegal").withMessageContaining("illegal")
				.withStackTraceContaining("IllegalStateException").withNoCause();
	}

	@Test
	public void indexOutOfBoundsException() {
		assertThatIndexOutOfBoundsException().isThrownBy(() -> {
			throw new IndexOutOfBoundsException("index !");
		}).withMessage("index !").withMessage("%s !", "index").withMessageContaining("index")
				.withStackTraceContaining("IndexOutOfBoundsException").withNoCause();
	}

	@Test
	public void ioException() {
		assertThatIOException().isThrownBy(() -> {
			throw new IOException("io !");
		}).withMessage("io !").withMessage("%s !", "io").withMessageContaining("io")
				.withStackTraceContaining("IOException").withNoCause();
	}

	@Test
	public void nullPointerException() {
		assertThatNullPointerException().isThrownBy(() -> {
			throw new NullPointerException("null !");
		}).withMessage("null !").withMessage("%s !", "null").withMessageContaining("null")
				.withStackTraceContaining("NullPointerException").withNoCause();
	}

	@Test
	public void runtimeException() {
		assertThatRuntimeException().isThrownBy(() -> {
			throw new RuntimeException("run !");
		}).withMessage("run !").withMessage("%s !", "run").withMessageContaining("run")
				.withStackTraceContaining("RuntimeException").withNoCause();
	}
}
