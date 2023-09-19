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

		Class<?> intClazz = int.class;
		System.out.println(intClazz);
		Condition<Class<?>> primitive = new Condition<Class<?>>(c -> c.isPrimitive(), "primitive");
		assertThat(intClazz).is(primitive);
	}

	@Test
	public void isNot() {
		Class<?> clazz = CharSequence.class;
		System.out.println(clazz);
		Condition<Class<?>> iface = new Condition<Class<?>>(c -> c.isPrimitive(), "interface");
		assertThat(clazz).isNot(iface);

		Class<?> intClazz = int.class;
		System.out.println(intClazz);
		Condition<Class<?>> primitive = new Condition<Class<?>>(c -> c.isInterface(), "primitive");
		assertThat(intClazz).isNot(primitive);
	}

	@Test
	public void isIn() {
		Class<?> clazz = CharSequence.class;
		System.out.println(clazz);
		assertThat(clazz).isIn(CharSequence.class, String.class);

		Class<?> intClazz = int.class;
		System.out.println(intClazz);
		assertThat(intClazz).isIn(int.class, Integer.class);
	}

	@Test
	public void isNotIn() {
		Class<?> clazz = CharSequence.class;
		System.out.println(clazz);
		assertThat(clazz).isNotIn(int.class, Integer.class);

		Class<?> intClazz = int.class;
		System.out.println(intClazz);
		assertThat(intClazz).isNotIn(CharSequence.class, String.class);
	}

	@Test
	public void isInstanceOf() {
		Class<?> clazz = CharSequence.class;
		System.out.println(clazz);
		assertThat(new String()).isInstanceOf(clazz);

		Class<?> intClazz = Integer.class;
		System.out.println(intClazz);
		assertThat(1).isInstanceOf(intClazz);
	}

	@Test
	public void isNotInstanceOf() {
		Class<?> clazz = CharSequence.class;
		System.out.println(clazz);
		assertThat(1).isNotInstanceOf(clazz);

		Class<?> intClazz = Integer.class;
		System.out.println(intClazz);
		assertThat(new String()).isNotInstanceOf(intClazz);
	}
}
