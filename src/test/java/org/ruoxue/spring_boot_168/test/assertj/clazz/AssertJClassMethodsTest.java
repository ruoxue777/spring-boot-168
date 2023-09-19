package org.ruoxue.spring_boot_168.test.assertj.clazz;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AssertJClassMethodsTest {

	@Test
	public void isNull() {
		Class<?> clazz = null;
		System.out.println(clazz);
		assertThat(clazz).isNull();

		Class<?> clazz2 = null;
		System.out.println(clazz2);
		assertThat(clazz2).isNull();
	}

	@Test
	public void isNotNull() {
		Class<?> clazz = String.class;
		System.out.println(clazz);
		assertThat(clazz).isNotNull();

		Class<?> clazz2 = Integer.class;
		System.out.println(clazz2);
		assertThat(clazz2).isNotNull();
	}

	@Test
	public void isEqualTo() {
		Class<?> clazz = String.class;
		Class<?> clazz2 = String.class;
		System.out.println(clazz);
		System.out.println(clazz2);
		assertThat(clazz).isEqualTo(clazz2);

		Class<?> intClazz = Integer.class;
		Class<?> intClazz2 = Integer.class;
		System.out.println(intClazz);
		System.out.println(intClazz2);
		assertThat(intClazz).isEqualTo(intClazz2);
	}

	@Test
	public void isNotEqualTo() {
		Class<?> clazz = String.class;
		Class<?> clazz2 = Character.class;
		System.out.println(clazz);
		System.out.println(clazz2);
		assertThat(clazz).isNotEqualTo(clazz2);

		Class<?> intClazz = Integer.class;
		Class<?> intClazz2 = Double.class;
		System.out.println(intClazz);
		System.out.println(intClazz2);
		assertThat(intClazz).isNotEqualTo(intClazz2);
	}

	@Test
	public void isSameAs() {
		Class<?> clazz = String.class;
		Class<?> clazz2 = clazz;
		System.out.println(clazz);
		System.out.println(clazz2);
		assertThat(clazz).isSameAs(clazz2);

		Class<?> intClazz = Integer.class;
		Class<?> intClazz2 = intClazz;
		System.out.println(intClazz);
		System.out.println(intClazz2);
		assertThat(intClazz).isSameAs(intClazz2);
	}

	@Test
	public void isNotSameAs() {
		Class<?> clazz = String.class;
		Class<?> clazz2 = Character.class;
		System.out.println(clazz);
		System.out.println(clazz2);
		assertThat(clazz).isNotSameAs(clazz2);

		Class<?> intClazz = Integer.class;
		Class<?> intClazz2 = Double.class;
		System.out.println(intClazz);
		System.out.println(intClazz2);
		assertThat(intClazz).isNotSameAs(intClazz2);
	}
}
