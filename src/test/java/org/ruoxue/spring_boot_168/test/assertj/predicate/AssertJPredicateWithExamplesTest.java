package org.ruoxue.spring_boot_168.test.assertj.predicate;

import static org.assertj.core.api.Assertions.*;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class AssertJPredicateWithExamplesTest {

	@Test
	public void rejects() {
		Predicate<String> lengthGreaterThan = s -> s.length() > 3;
		System.out.println(lengthGreaterThan);
		assertThat(lengthGreaterThan).rejects("155", "151");

		Predicate<Integer> greaterThan = i -> i > 10;
		System.out.println(greaterThan);
		assertThat(greaterThan).rejects(1, 2);
	}

	@Test
	public void rejectsWithNegate() {
		Predicate<String> lengthGreaterThan = s -> s.length() > 3;
		System.out.println(lengthGreaterThan.negate());
		assertThat(lengthGreaterThan.negate()).rejects("AssertJ", "JUnit");

		Predicate<Integer> greaterThan = i -> i > 10;
		System.out.println(greaterThan.negate());
		assertThat(greaterThan.negate()).rejects(155, 151);
	}

	@Test
	public void rejectsWithAnd() {
		Predicate<String> startsWith = s -> s.startsWith("J");
		Predicate<String> endsWith = s -> s.endsWith("A");
		Predicate<String> predicate = startsWith.and(endsWith);
		System.out.println(predicate);
		assertThat(predicate).rejects("AssertJ", "AJ");

		Predicate<Integer> greaterThan = i -> i > 3;
		Predicate<Integer> lessThan = i -> i < 6;
		Predicate<Integer> intPredicate = greaterThan.and(lessThan);
		System.out.println(intPredicate);
		assertThat(intPredicate).rejects(2, 7);
	}

	@Test
	public void rejectsWithOr() {
		Predicate<String> startsWith = s -> s.startsWith("t");
		Predicate<String> endsWith = s -> s.endsWith("A");
		Predicate<String> predicate = startsWith.or(endsWith);
		System.out.println(predicate);
		assertThat(predicate).rejects("AssertJ", "JUnit");

		Predicate<Integer> greaterThan = i -> i < 3;
		Predicate<Integer> lessThan = i -> i > 6;
		Predicate<Integer> intPredicate = greaterThan.or(lessThan);
		System.out.println(intPredicate);
		assertThat(intPredicate).rejects(4, 5);
	}

	@Test
	public void rejectsWithChaining() {
		Predicate<String> isNull = Objects::isNull;
		Predicate<String> startsWith = s -> s.startsWith("t");
		Predicate<String> contains = Pattern.compile("\\wX").asPredicate();
		Predicate<String> chaining = isNull.and(startsWith).or(contains);
		System.out.println(chaining);
		assertThat(chaining).rejects("AssertJ", "JUnit");

		Predicate<Integer> intIsNull = Objects::isNull;
		Predicate<Integer> greaterThan = i -> i < 3;
		Predicate<Integer> lessThan = i -> i > 6;
		Predicate<Integer> intChaining = intIsNull.and(greaterThan).or(lessThan);
		System.out.println(intChaining);
		assertThat(intChaining).rejects(4, 5);
	}
}
