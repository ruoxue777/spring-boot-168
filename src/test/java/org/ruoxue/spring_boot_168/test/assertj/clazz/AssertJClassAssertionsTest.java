package org.ruoxue.spring_boot_168.test.assertj.clazz;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class AssertJClassAssertionsTest {

	@Test
	public void isAbstract() {
		Class<?> clazz = CharSequence.class;
		System.out.println(clazz);
		assertThat(clazz).isAbstract();

		Class<?> numberClazz = Number.class;
		System.out.println(numberClazz);
		assertThat(numberClazz).isAbstract();
	}

	@Test
	public void isInterface() {
		Class<?> clazz = Predicate.class;
		System.out.println(clazz);
		assertThat(clazz).isInterface();

		Class<?> biPredicateClazz = BiPredicate.class;
		System.out.println(biPredicateClazz);
		assertThat(biPredicateClazz).isInterface();
	}

	@Test
	public void isNotInterface() {
		Class<?> clazz = String.class;
		System.out.println(clazz);
		assertThat(clazz).isNotInterface();

		Class<?> intClazz = Integer.class;
		System.out.println(intClazz);
		assertThat(intClazz).isNotInterface();
	}

	@Test
	public void isFinal() {
		Class<?> clazz = Optional.class;
		System.out.println(clazz);
		assertThat(clazz).isFinal();

		Class<?> ldtClazz = LocalDateTime.class;
		System.out.println(ldtClazz);
		assertThat(ldtClazz).isFinal();
	}

	@Test
	public void isNotFinal() {
		Class<?> clazz = Object.class;
		System.out.println(clazz);
		assertThat(clazz).isNotFinal();

		Class<?> threadClazz = Thread.class;
		System.out.println(threadClazz);
		assertThat(threadClazz).isNotFinal();
	}

	@Test
	public void isAnnotation() {
		Class<?> clazz = FunctionalInterface.class;
		System.out.println(clazz);
		assertThat(clazz).isAnnotation();

		Class<?> deprecatedClazz = Deprecated.class;
		System.out.println(deprecatedClazz);
		assertThat(deprecatedClazz).isAnnotation();
	}

	@Test
	public void isNotAnnotation() {
		Class<?> clazz = Collector.class;
		System.out.println(clazz);
		assertThat(clazz).isNotAnnotation();

		Class<?> streamClazz = Stream.class;
		System.out.println(streamClazz);
		assertThat(streamClazz).isNotAnnotation();
	}
}
