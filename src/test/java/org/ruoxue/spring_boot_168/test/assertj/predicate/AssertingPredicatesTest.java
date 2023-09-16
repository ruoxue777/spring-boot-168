package org.ruoxue.spring_boot_168.test.assertj.predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

public class AssertingPredicatesTest {

	@Test
	public void matches() {
		Predicate<String> lengthGreaterThan = s -> s.length() > 3;
		System.out.println(lengthGreaterThan);
		assertThat(lengthGreaterThan).matches(p -> p.test("AssertJ"));

		Predicate<Integer> greaterThan = i -> i > 10;
		System.out.println(greaterThan);
		assertThat(greaterThan).matches(p -> p.test(155));
	}

	@Test
	public void matchesWithDescription() {
		Predicate<String> lengthGreaterThan = s -> s.length() > 3;
		System.out.println(lengthGreaterThan);
		assertThat(lengthGreaterThan).matches(p -> p.test("AssertJ"), "lengthGreaterThan");

		Predicate<Integer> greaterThan = i -> i > 10;
		System.out.println(greaterThan);
		assertThat(greaterThan).matches(p -> p.test(155), "greaterThan");
	}

	@Test
	public void matchesThrowError() {
		assertThatCode(() -> {
			Predicate<String> lengthGreaterThan = s -> s.length() < 3;
			System.out.println(lengthGreaterThan);
			assertThat(lengthGreaterThan).matches(p -> p.test("AssertJ"), "lengthGreaterThan");
		}).isInstanceOf(AssertionError.class);

		assertThatCode(() -> {
			Predicate<Integer> greaterThan = i -> i < 10;
			System.out.println(greaterThan);
			assertThat(greaterThan).matches(p -> p.test(155), "greaterThan");
		}).isInstanceOf(AssertionError.class);
	}

	@Test
	public void satisfies() {
		Predicate<String> lengthGreaterThan = s -> s.length() > 3;
		System.out.println(lengthGreaterThan);
		assertThat(lengthGreaterThan).satisfies(p -> {
			assertThat(p).accepts("AssertJ", "JUnit");
			assertThat(p).rejects("155", "151");
		});

		Predicate<Integer> greaterThan = i -> i > 10;
		System.out.println(greaterThan);
		assertThat(greaterThan).satisfies(p -> {
			assertThat(p).accepts(155, 151);
		}, p -> {
			assertThat(p).rejects(1, 2);
		});
	}

	@Test
	public void satisfiesAnyOf() {
		Predicate<String> lengthGreaterThan = s -> s.length() > 3;
		System.out.println(lengthGreaterThan);
		assertThat(lengthGreaterThan).satisfiesAnyOf(p -> {
			assertThat(p).accepts("AssertJ", "JUnit");
			assertThat(p).rejects("155", "151");
		});

		Predicate<Integer> greaterThan = i -> i > 10;
		System.out.println(greaterThan);
		assertThat(greaterThan).satisfiesAnyOf(p -> {
			assertThat(p).accepts(155, 151);
		}, p -> {
			assertThat(p).rejects(100, 200);
		});
	}

	@Test
	public void satisfiesThrowError() {
		assertThatCode(() -> {
			Predicate<String> lengthGreaterThan = s -> s.length() > 3;
			System.out.println(lengthGreaterThan);
			assertThat(lengthGreaterThan).satisfies(p -> {
				assertThat(p).accepts("AssertJ", "JUnit");
				assertThat(p).rejects("9155", "9151");
			});
		}).isInstanceOf(AssertionError.class);

		assertThatCode(() -> {
			Predicate<Integer> greaterThan = i -> i > 10;
			System.out.println(greaterThan);
			assertThat(greaterThan).satisfies(p -> {
				assertThat(p).accepts(155, 151);
			}, p -> {
				assertThat(p).rejects(91, 92);
			});
		}).isInstanceOf(AssertionError.class);
	}
}
