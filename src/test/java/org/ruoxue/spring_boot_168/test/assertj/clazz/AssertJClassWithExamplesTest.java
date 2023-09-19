package org.ruoxue.spring_boot_168.test.assertj.clazz;

import static org.assertj.core.api.Assertions.*;

import java.lang.annotation.Target;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class AssertJClassWithExamplesTest {

	@Test
	public void has() {
		Class<?> clazz = Consumer.class;
		System.out.println(clazz);
		Condition<Class<?>> iface = new Condition<Class<?>>(c -> c.isInterface(), "iface");
		assertThat(clazz).has(iface);

		Class<?> clazz2 = int.class;
		System.out.println(clazz2);
		Condition<Class<?>> primitive = new Condition<Class<?>>(c -> c.isPrimitive(), "primitive");
		assertThat(clazz2).has(primitive);
	}

	@Test
	public void hasPackage() {
		Class<?> clazz = Function.class;
		System.out.println(clazz);
		assertThat(clazz).hasPackage("java.util.function");
		assertThat(clazz).hasPackage(Package.getPackage("java.util.function"));

		Class<?> clazz2 = IntStream.class;
		System.out.println(clazz2);
		assertThat(clazz2).hasPackage("java.util.stream");
		assertThat(clazz2).hasPackage(Package.getPackage("java.util.stream"));
	}

	@Test
	public void hasAnnotation() {
		Class<?> clazz = UnaryOperator.class;
		System.out.println(clazz);
		assertThat(clazz).hasAnnotation(FunctionalInterface.class);

		Class<?> clazz2 = FunctionalInterface.class;
		System.out.println(clazz2);
		assertThat(clazz2).hasAnnotation(Target.class);
	}

	@Test
	public void hasSuperclass() {
		Class<?> clazz = String.class;
		System.out.println(clazz);
		assertThat(clazz).hasSuperclass(Object.class);

		Class<?> clazz2 = Integer.class;
		System.out.println(clazz2);
		assertThat(clazz2).hasSuperclass(Number.class);
	}

	@Test
	public void hasNoSuperclass() {
		Class<?> clazz = List.class;
		System.out.println(clazz);
		assertThat(clazz).hasNoSuperclass();

		Class<?> clazz2 = Collection.class;
		System.out.println(clazz2);
		assertThat(clazz2).hasNoSuperclass();
	}

	@Test
	public void doesNotHave() {
		Class<?> clazz = BiConsumer.class;
		System.out.println(clazz);
		Condition<Class<?>> anno = new Condition<Class<?>>(c -> c.isAnnotation(), "annotation");
		assertThat(clazz).doesNotHave(anno);

		Class<?> clazz2 = Integer.class;
		System.out.println(clazz2);
		Condition<Class<?>> primitive = new Condition<Class<?>>(c -> c.isEnum(), "enum");
		assertThat(clazz2).doesNotHave(primitive);
	}
}
