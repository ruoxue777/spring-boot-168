package org.ruoxue.spring_boot_168.test.assertj.list;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class AssertJListWithExamplesTest {

	@Test
	public void has() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		Condition<List<?>> size = new Condition<List<?>>(s -> s.size() > 2, "size");
		assertThat(list).has(size);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		Condition<List<?>> intSize = new Condition<List<?>>(i -> i.size() > 2, "size");
		assertThat(intList).has(intSize);
	}

	@Test
	public void hasOnlyOneElementSatisfying() {
		List<String> list = Arrays.asList("Apple");
		System.out.println(list);
		assertThat(list).hasOnlyOneElementSatisfying(e -> {
			assertThat(e).hasSize(5);
		});
		assertThat(list).singleElement().matches(e -> e.length() == 5);

		List<Integer> intList = Stream.of(10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).hasOnlyOneElementSatisfying(e -> {
			assertThat(e).isGreaterThan(9);
		});
		assertThat(intList).singleElement().matches(e -> e > 9);
	}

	@Test
	public void hasSize() {
		int expectedSize = 3;
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).hasSize(expectedSize);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).hasSize(5);
	}

	@Test
	public void hasSizeBetween() {
		int expectedSize = 3;
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).hasSizeBetween(1, expectedSize);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).hasSizeBetween(1, 5);
	}

	@Test
	public void hasSizeGreaterThan() {
		int expectedSize = 2;
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).hasSizeGreaterThan(expectedSize);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).hasSizeGreaterThan(expectedSize);
	}

	@Test
	public void hasSizeLessThan() {
		int expectedSize = 4;
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).hasSizeLessThan(expectedSize);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).hasSizeLessThan(6);
	}

	@Test
	public void hasToString() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).hasToString(list.toString());

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).hasToString(intList.toString());
	}

	@Test
	public void hasSameSizeAs() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		List<String> list2 = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		System.out.println(list2);
		assertThat(list).hasSameSizeAs(list);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		List<Integer> intList2 = Arrays.asList(6, 7, 8, 9, 10);
		System.out.println(intList);
		System.out.println(intList2);
		assertThat(intList).hasSameSizeAs(intList2);
	}

	@Test
	public void hasSameElementsAs() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		List<String> list2 = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		System.out.println(list2);
		assertThat(list).hasSameElementsAs(list2);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		List<Integer> intList2 = Arrays.asList(6, 7, 8, 9, 10);
		System.out.println(intList);
		System.out.println(intList2);
		assertThat(intList).hasSameElementsAs(intList2);
	}

	@Test
	public void doesNotHave() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		Condition<List<?>> size = new Condition<List<?>>(s -> s.size() > 3, "size");
		assertThat(list).doesNotHave(size);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		Condition<List<?>> intSize = new Condition<List<?>>(s -> s.size() > 5, "size");
		assertThat(intList).doesNotHave(intSize);
	}

	@Test
	public void doesNotHaveDuplicates() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).doesNotHaveDuplicates();

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).doesNotHaveDuplicates();
	}
}
