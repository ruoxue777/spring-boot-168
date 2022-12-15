package org.ruoxue.spring_boot_168.test.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AssertJExceptionTest {


	public int divide(int value1, int value2) {
		return value1 / value2;
	}
	
	@Test
	public void assertThatThrownBy_1() {
		assertThatThrownBy(() -> divide(1, 0))
		.isInstanceOf(ArithmeticException.class)
		.hasMessageContaining("zero")
		.hasMessage("/ by zero");
	}

	@Test
	public void assertThatThrownBy_2() {
		assertThatThrownBy(() -> {
			List<Integer> list = Arrays.asList(1, 2);
			list.get(2);
		})
		.isInstanceOf(IndexOutOfBoundsException.class)
		.hasMessageContaining("2");
	}
	
	@Test
	public void assertThatThrownBy_3() {
		assertThatThrownBy(() -> {
            try {
                throw new IOException();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        })
		.isInstanceOf(RuntimeException.class)
		.hasCauseInstanceOf(IOException.class)
		.hasStackTraceContaining("IOException");
	}	

	@Test
	public void assertThatExceptionOfType_1() {
		assertThatExceptionOfType(ArithmeticException.class)
		.isThrownBy(() -> divide(1, 0))
		.withMessageContaining("zero")
		.withMessage("/ by zero");
	}
	
	@Test
	public void assertThatExceptionOfType_2() {
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
		.isThrownBy(() -> {
			List<Integer> list = Arrays.asList(1, 2);
			list.get(2);
		})
		.withMessageContaining("2");
	}
	
	@Test
	public void assertThatExceptionOfType_3() {
		assertThatExceptionOfType(RuntimeException.class)
		.isThrownBy(() -> {
            try {
                throw new IOException();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
		})
		.withCauseExactlyInstanceOf(IOException.class)
		.withStackTraceContaining("IOException");
	}	

	@Test
	public void assertThatThrown() {
		Throwable thrown = catchThrowable(() -> {
			List<Integer> list = Arrays.asList(1, 2);
			list.get(2);
		});

		assertThat(thrown)
		.isInstanceOf(IndexOutOfBoundsException.class)
		.hasMessageContaining("2");
	}

}
