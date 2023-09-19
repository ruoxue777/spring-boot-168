package org.ruoxue.spring_boot_168.test.assertj.clazz;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class UnitTestClassWithAssertJTest {

	@Test
	public void is() {
		Class<?> clazz = CharSequence.class;
		System.out.println(clazz);
		Condition<Class<?>> iface = new Condition<Class<?>>(c -> c.isInterface(), "interface");
		assertThat(clazz).is(iface);

		Class<?> clazz2 = int.class;
		System.out.println(clazz2);
		Condition<Class<?>> primitive = new Condition<Class<?>>(c -> c.isPrimitive(), "primitive");
		assertThat(clazz2).is(primitive);
	}

	@Test
	public void isNot() {
		Class<?> clazz = CharSequence.class;
		System.out.println(clazz);
		Condition<Class<?>> iface = new Condition<Class<?>>(c -> c.isPrimitive(), "interface");
		assertThat(clazz).isNot(iface);

		Class<?> clazz2 = int.class;
		System.out.println(clazz2);
		Condition<Class<?>> primitive = new Condition<Class<?>>(c -> c.isInterface(), "primitive");
		assertThat(clazz2).isNot(primitive);
	}

	@Test
	public void isIn() {
		Class<?> clazz = CharSequence.class;
		System.out.println(clazz);
		assertThat(clazz).isIn(CharSequence.class, String.class);

		Class<?> clazz2 = int.class;
		System.out.println(clazz2);
		assertThat(clazz2).isIn(int.class, Integer.class);
	}

	@Test
	public void isNotIn() {
		Class<?> clazz = CharSequence.class;
		System.out.println(clazz);
		assertThat(clazz).isNotIn(int.class, Integer.class);

		Class<?> clazz2 = int.class;
		System.out.println(clazz2);
		assertThat(clazz2).isNotIn(CharSequence.class, String.class);
	}

	@Test
	public void isInstanceOf() {
		Class<?> clazz = CharSequence.class;
		System.out.println(clazz);
		assertThat(new String()).isInstanceOf(clazz);

		Class<?> clazz2 = Integer.class;
		System.out.println(clazz2);
		assertThat(1).isInstanceOf(clazz2);
	}

	@Test
	public void isNotInstanceOf() {
		Class<?> clazz = CharSequence.class;
		System.out.println(clazz);
		assertThat(1).isNotInstanceOf(clazz);

		Class<?> clazz2 = Integer.class;
		System.out.println(clazz2);
		assertThat(new String()).isNotInstanceOf(clazz2);
	}
}
