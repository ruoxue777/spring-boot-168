package org.ruoxue.spring_boot_168.test.assertj.clazz;

import static org.assertj.core.api.Assertions.*;

import java.lang.annotation.Retention;
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

		Class<?> clazz2 = Number.class;
		System.out.println(clazz2);
		assertThat(clazz2).isAbstract();
	}

	@Test
	public void isInterface() {
		Class<?> clazz = Predicate.class;
		System.out.println(clazz);
		assertThat(clazz).isInterface();

		Class<?> clazz2 = BiPredicate.class;
		System.out.println(clazz2);
		assertThat(clazz2).isInterface();
	}

	@Test
	public void isNotInterface() {
		Class<?> clazz = String.class;
		System.out.println(clazz);
		assertThat(clazz).isNotInterface();

		Class<?> clazz2 = int.class;
		System.out.println(clazz2);
		assertThat(clazz2).isNotInterface();
	}

	@Test
	public void isFinal() {
		Class<?> clazz = Optional.class;
		System.out.println(clazz);
		assertThat(clazz).isFinal();

		Class<?> clazz2 = LocalDateTime.class;
		System.out.println(clazz2);
		assertThat(clazz2).isFinal();
	}

	@Test
	public void isNotFinal() {
		Class<?> clazz = Object.class;
		System.out.println(clazz);
		assertThat(clazz).isNotFinal();

		Class<?> clazz2 = Thread.class;
		System.out.println(clazz2);
		assertThat(clazz2).isNotFinal();
	}

	@Test
	public void isAnnotation() {
		Class<?> clazz = FunctionalInterface.class;
		System.out.println(clazz);
		assertThat(clazz).isAnnotation();

		Class<?> clazz2 = Retention.class;
		System.out.println(clazz2);
		assertThat(clazz2).isAnnotation();
	}

	@Test
	public void isNotAnnotation() {
		Class<?> clazz = Collector.class;
		System.out.println(clazz);
		assertThat(clazz).isNotAnnotation();

		Class<?> clazz2 = Stream.class;
		System.out.println(clazz2);
		assertThat(clazz2).isNotAnnotation();
	}
}
