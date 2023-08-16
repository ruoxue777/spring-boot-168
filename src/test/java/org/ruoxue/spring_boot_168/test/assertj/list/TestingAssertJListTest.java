package org.ruoxue.spring_boot_168.test.assertj.list;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class TestingAssertJListTest {

	@Test
	public void are() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		Condition<String> length = new Condition<String>(s -> s.length() > 4, "length");
		assertThat(list).are(length);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		Condition<Integer> intValue = new Condition<Integer>(i -> i > 0, "value");
		assertThat(intList).are(intValue);
	}

	@Test
	public void areAtLeast() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		Condition<String> length = new Condition<String>(s -> s.length() > 5, "length");
		assertThat(list).areAtLeast(2, length);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		Condition<Integer> intValue = new Condition<Integer>(i -> i > 1, "value");
		assertThat(intList).areAtLeast(2, intValue);
	}

	@Test
	public void areAtLeastOne() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		Condition<String> length = new Condition<String>(s -> s.length() > 5, "length");
		assertThat(list).areAtLeastOne(length);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		Condition<Integer> intValue = new Condition<Integer>(i -> i > 4, "value");
		assertThat(intList).areAtLeastOne(intValue);
	}

	@Test
	public void areAtMost() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		Condition<String> length = new Condition<String>(s -> s.length() > 5, "length");
		assertThat(list).areAtMost(2, length);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		Condition<Integer> intValue = new Condition<Integer>(i -> i > 8, "value");
		assertThat(intList).areAtMost(2, intValue);
	}

	@Test
	public void areExactly() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		Condition<String> length = new Condition<String>(s -> s.length() > 5, "length");
		assertThat(list).areExactly(2, length);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		Condition<Integer> intValue = new Condition<Integer>(i -> i > 8, "value");
		assertThat(intList).areExactly(2, intValue);
	}

	@Test
	public void areNot() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		Condition<String> length = new Condition<String>(s -> s.length() > 7, "length");
		assertThat(list).areNot(length);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		Condition<Integer> intValue = new Condition<Integer>(i -> i > 10, "value");
		assertThat(intList).areNot(intValue);
	}

	@Test
	public void as() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		Supplier<String> description = () -> "AS Description";
		assertThat(list).as(description);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		Supplier<String> intDescription = () -> "Integer AS Description";
		assertThat(intList).as(intDescription);
	}
}
