package org.ruoxue.spring_boot_168.test.assertj.predicate;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class AssertJPredicateMethodsTest {

	@Test
	public void acceptsAll() {
		Predicate<String> lengthGreaterThan = s -> s.length() > 3;
		System.out.println(lengthGreaterThan);
		assertThat(lengthGreaterThan).acceptsAll(newArrayList("AssertJ", "JUnit"));

		Predicate<Integer> greaterThan = i -> i > 10;
		System.out.println(greaterThan);
		assertThat(greaterThan).acceptsAll(newArrayList(155, 151));
	}

	@Test
	public void acceptsAllWithNegate() {
		Predicate<String> lengthGreaterThan = s -> s.length() > 3;
		System.out.println(lengthGreaterThan.negate());
		assertThat(lengthGreaterThan.negate()).acceptsAll(newArrayList("155", "151"));

		Predicate<Integer> greaterThan = i -> i > 10;
		System.out.println(greaterThan.negate());
		assertThat(greaterThan.negate()).acceptsAll(newArrayList(1, 2));
	}

	@Test
	public void acceptsAllWithAnd() {
		Predicate<String> startsWith = s -> s.startsWith("A");
		Predicate<String> endsWith = s -> s.endsWith("J");
		Predicate<String> predicate = startsWith.and(endsWith);
		System.out.println(predicate);
		assertThat(predicate).acceptsAll(newArrayList("AssertJ", "AJ"));

		Predicate<Integer> greaterThan = i -> i > 3;
		Predicate<Integer> lessThan = i -> i < 6;
		Predicate<Integer> intPredicate = greaterThan.and(lessThan);
		System.out.println(intPredicate);
		assertThat(intPredicate).acceptsAll(newArrayList(4, 5));
	}

	@Test
	public void acceptsAllWithOr() {
		Predicate<String> startsWith = s -> s.startsWith("A");
		Predicate<String> endsWith = s -> s.endsWith("t");
		Predicate<String> predicate = startsWith.or(endsWith);
		System.out.println(predicate);
		assertThat(predicate).acceptsAll(newArrayList("AssertJ", "JUnit"));

		Predicate<Integer> greaterThan = i -> i > 3;
		Predicate<Integer> lessThan = i -> i < 6;
		Predicate<Integer> intPredicate = greaterThan.or(lessThan);
		System.out.println(intPredicate);
		assertThat(intPredicate).acceptsAll(newArrayList(7, 2));
	}

	@Test
	public void acceptsAllWithChaining() {
		Predicate<String> nonNull = Objects::nonNull;
		Predicate<String> startsWith = s -> s.startsWith("A");
		Predicate<String> contains = Pattern.compile("\\wU").asPredicate();
		Predicate<String> chaining = nonNull.and(startsWith).or(contains);
		System.out.println(chaining);
		assertThat(chaining).acceptsAll(newArrayList("AssertJ", "JUnit"));

		Predicate<Integer> intNonNull = Objects::nonNull;
		Predicate<Integer> greaterThan = i -> i > 3;
		Predicate<Integer> lessThan = i -> i < 6;
		Predicate<Integer> intChaining = intNonNull.and(greaterThan).or(lessThan);
		System.out.println(intChaining);
		assertThat(intChaining).acceptsAll(newArrayList(7, 2));
	}
}
