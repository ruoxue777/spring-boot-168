package org.ruoxue.spring_boot_168.test.assertj.number;

import static org.assertj.core.api.Assertions.*;


import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

public class AssertJNumberAssertionsTest {

	@Test
	public void isCloseTo() {
		int value = 155;
		assertThat(value).isCloseTo(150, Offset.offset(5));
		assertThat(value).isCloseTo(160, Offset.offset(5));

		double doubleValue = 151d;
		assertThat(doubleValue).isCloseTo(146d, Offset.offset(5d));
		assertThat(doubleValue).isCloseTo(156d, Offset.offset(5d));
	}

	@Test
	public void isNotCloseTo() {
		int value = 155;
		assertThat(value).isNotCloseTo(145, Offset.offset(5));
		assertThat(value).isNotCloseTo(165, Offset.offset(5));

		double doubleValue = 151d;
		assertThat(doubleValue).isNotCloseTo(141d, Offset.offset(5d));
		assertThat(doubleValue).isNotCloseTo(161d, Offset.offset(5d));
	}
}
