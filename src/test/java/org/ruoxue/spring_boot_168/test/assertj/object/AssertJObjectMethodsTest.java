package org.ruoxue.spring_boot_168.test.assertj.object;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class AssertJObjectMethodsTest {

	@Test
	public void isNull() {
		Object value = null;
		System.out.println(value);
		assertThat(value).isNull();

		Object value2 = null;
		System.out.println(value2);
		assertThat(value2).isNull();
	}

	@Test
	public void isNotNull() {
		Object value = "AssertJ";
		System.out.println(value);
		assertThat(value).isNotNull();

		value = BigDecimal.valueOf(155);
		System.out.println(value);
		assertThat(value).isNotNull();
	}

	@Test
	public void isEqualTo() {
		Object value = "AssertJ";
		System.out.println(value);
		assertThat(value).isEqualTo("AssertJ");

		value = BigDecimal.valueOf(155);
		System.out.println(value);
		assertThat(value).isEqualTo(BigDecimal.valueOf(155));
	}

	@Test
	public void isNotEqualTo() {
		Object value = "AssertJ";
		System.out.println(value);
		assertThat(value).isNotEqualTo("155");

		value = BigDecimal.valueOf(155);
		System.out.println(value);
		assertThat(value).isNotEqualTo(155);
	}

	@Test
	public void isSameAs() {
		Object value = "AssertJ";
		Object value2 = value;
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isSameAs(value2);

		value = BigDecimal.valueOf(155);
		value2 = value;
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isSameAs(value2);
	}

	@Test
	public void isNotSameAs() {
		Object value = "AssertJ";
		Object value2 = new String("AssertJ");
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isNotSameAs(value2);

		value = BigDecimal.valueOf(155);
		value2 = BigDecimal.valueOf(155);
		System.out.println(value);
		System.out.println(value2);
		assertThat(value).isNotSameAs(value2);
	}
}
