package org.ruoxue.spring_boot_168.test.assertj.optional;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class AssertJOptionalWithExamplesTest {

	@Test
	public void has() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		Condition<Optional<String>> lengthGreaterThan = new Condition<Optional<String>>(o -> o.get().length() > 2, "lengthGreaterThan");
		assertThat(value).has(lengthGreaterThan);

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		Condition<Optional<Integer>> greaterThan = new Condition<Optional<Integer>>(o -> o.get() > 0, "greaterThan");
		assertThat(intValue).has(greaterThan);
	}

	@Test
	public void hasToString() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		assertThat(value).hasToString(value.toString());

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		assertThat(intValue).hasToString(intValue.toString());
	}

	@Test
	public void hasSameClassAs() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		assertThat(value).hasSameClassAs(Optional.of("Unit Test"));

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		assertThat(intValue).hasSameClassAs(Optional.of(151));
	}

	@Test
	public void hasValue() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		assertThat(value).hasValue("AssertJ");

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		assertThat(intValue).hasValue(155);
	}

	@Test
	public void hasValueSatisfying() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		assertThat(value).hasValueSatisfying(s -> {
			assertThat(s).isEqualTo("AssertJ");
			assertThat(s).startsWith("A");
			assertThat(s).endsWith("J");
		});

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		assertThat(intValue).hasValueSatisfying(i -> {
			assertThat(i).isEqualTo(155);
			assertThat(i).isBetween(151, 155);
			assertThat(i).isCloseTo(150, within(5));
		});
	}

	@Test
	public void hasValueSatisfyingWithCondition() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		Condition<String> lengthGreaterThan = new Condition<String>(s -> s.length() > 2, "lengthGreaterThan");
		assertThat(value).hasValueSatisfying(lengthGreaterThan);

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		Condition<Integer> greaterThan = new Condition<Integer>(i -> i > 0, "greaterThan");
		assertThat(intValue).hasValueSatisfying(greaterThan);
	}

	@Test
	public void doesNotHave() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		Condition<Optional<String>> lengthLessThan = new Condition<Optional<String>>(o -> o.get().length() < 2,
				"lengthLessThan");
		assertThat(value).doesNotHave(lengthLessThan);

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		Condition<Optional<Integer>> greaterThan = new Condition<Optional<Integer>>(o -> o.get() > 155, "greaterThan");
		assertThat(intValue).doesNotHave(greaterThan);
	}

	@Test
	public void doesNotHaveSameClassAs() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		assertThat(value).doesNotHaveSameClassAs("Unit Test");

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		assertThat(intValue).doesNotHaveSameClassAs(151);
	}
}
