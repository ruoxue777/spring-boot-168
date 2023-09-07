package org.ruoxue.spring_boot_168.test.assertj.optional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import static org.assertj.core.api.Assertions.anyOf;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class UnitTestOptionalWithAssertJTest {

	@Test
	public void is() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		Condition<Optional<String>> isNotEmpty = new Condition<Optional<String>>(o -> !o.get().isEmpty(), "isEmpty");
		Condition<Optional<String>> lengthGreaterThan = new Condition<Optional<String>>(o -> o.get().length() > 2, "lengthGreaterThan");
		assertThat(value).is(anyOf(isNotEmpty, lengthGreaterThan));

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		Condition<Optional<Integer>> greaterThan = new Condition<Optional<Integer>>(o -> o.get() > 0, "greaterThan");
		Condition<Optional<Integer>> lessThan = new Condition<Optional<Integer>>(o -> o.get() < 160, "lessThan");
		assertThat(intValue).is(anyOf(greaterThan, lessThan));
	}

	@Test
	public void isNot() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		Condition<Optional<String>> isEmpty = new Condition<Optional<String>>(o -> o.get().isEmpty(), "isEmpty");
		Condition<Optional<String>> lengthLessThan = new Condition<Optional<String>>(o -> o.get().length() < 2, "lengthLessThan");
		assertThat(value).isNot(anyOf(isEmpty, lengthLessThan));

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		Condition<Optional<Integer>> lessThan = new Condition<Optional<Integer>>(o -> o.get() < 0, "greaterThan");
		Condition<Optional<Integer>> greaterThan = new Condition<Optional<Integer>>(o -> o.get() > 155, "lessThan");
		assertThat(intValue).isNot(anyOf(greaterThan, lessThan));
	}

	@Test
	public void isIn() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		assertThat(value).isIn(Optional.of("AssertJ"), Optional.of("155"));

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		assertThat(intValue).isIn(Optional.of("AssertJ"), Optional.of(155));
	}

	@Test
	public void isNotIn() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		assertThat(value).isNotIn(Optional.of("JUnit"), Optional.of("151"));

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		assertThat(intValue).isNotIn(Optional.of("JUnit"), Optional.of(151));
	}

	@Test
	public void isInstanceOf() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		assertThat(value).isInstanceOf(Optional.class);

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		assertThat(intValue).isInstanceOf(Optional.class);
	}

	@Test
	public void isNotInstanceOf() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		assertThat(value).isNotInstanceOf(String.class);

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		assertThat(intValue).isNotInstanceOf(Integer.class);
	}
}
