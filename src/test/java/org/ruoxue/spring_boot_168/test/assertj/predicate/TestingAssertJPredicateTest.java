package org.ruoxue.spring_boot_168.test.assertj.predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class TestingAssertJPredicateTest {

	@Test
	public void rejectsAll() {
		Predicate<String> lengthGreaterThan = s -> s.length() > 3;
		System.out.println(lengthGreaterThan);
		assertThat(lengthGreaterThan).rejectsAll(newArrayList("155", "151"));

		Predicate<Integer> greaterThan = i -> i > 10;
		System.out.println(greaterThan);
		assertThat(greaterThan).rejectsAll(newArrayList(1, 2));
	}

	@Test
	public void rejectsAllWithNegate() {
		Predicate<String> lengthGreaterThan = s -> s.length() > 3;
		System.out.println(lengthGreaterThan.negate());
		assertThat(lengthGreaterThan.negate()).rejectsAll(newArrayList("AssertJ", "JUnit"));

		Predicate<Integer> greaterThan = i -> i > 10;
		System.out.println(greaterThan.negate());
		assertThat(greaterThan.negate()).rejectsAll(newArrayList(155, 151));
	}

	@Test
	public void rejectsAllWithAnd() {
		Predicate<String> startsWith = s -> s.startsWith("J");
		Predicate<String> endsWith = s -> s.endsWith("A");
		Predicate<String> predicate = startsWith.and(endsWith);
		System.out.println(predicate);
		assertThat(predicate).rejectsAll(newArrayList("AssertJ", "AJ"));

		Predicate<Integer> greaterThan = i -> i > 3;
		Predicate<Integer> lessThan = i -> i < 6;
		Predicate<Integer> intPredicate = greaterThan.and(lessThan);
		System.out.println(intPredicate);
		assertThat(intPredicate).rejectsAll(newArrayList(2, 7));
	}

	@Test
	public void rejectsAllWithOr() {
		Predicate<String> startsWith = s -> s.startsWith("t");
		Predicate<String> endsWith = s -> s.endsWith("A");
		Predicate<String> predicate = startsWith.or(endsWith);
		System.out.println(predicate);
		assertThat(predicate).rejectsAll(newArrayList("AssertJ", "JUnit"));

		Predicate<Integer> greaterThan = i -> i < 3;
		Predicate<Integer> lessThan = i -> i > 6;
		Predicate<Integer> intPredicate = greaterThan.or(lessThan);
		System.out.println(intPredicate);
		assertThat(intPredicate).rejectsAll(newArrayList(4, 5));
	}

	@Test
	public void rejectsAllWithChaining() {
		Predicate<String> isNull = Objects::isNull;
		Predicate<String> startsWith = s -> s.startsWith("t");
		Predicate<String> contains = Pattern.compile("\\wX").asPredicate();
		Predicate<String> chaining = isNull.and(startsWith).or(contains);
		System.out.println(chaining);
		assertThat(chaining).rejectsAll(newArrayList("AssertJ", "JUnit"));

		Predicate<Integer> intIsNull = Objects::isNull;
		Predicate<Integer> greaterThan = i -> i < 3;
		Predicate<Integer> lessThan = i -> i > 6;
		Predicate<Integer> intChaining = intIsNull.and(greaterThan).or(lessThan);
		System.out.println(intChaining);
		assertThat(intChaining).rejectsAll(newArrayList(4, 5));
	}
}
