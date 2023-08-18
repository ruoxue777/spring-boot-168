package org.ruoxue.spring_boot_168.test.assertj.list;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class UnitTestListWithAssertJTest {

	@Test
	public void is() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		Condition<List<?>> size = new Condition<List<?>>(s -> s.size() > 2, "size");
		assertThat(list).is(size);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		Condition<List<?>> intSize = new Condition<List<?>>(i -> i.size() > 2, "size");
		assertThat(intList).is(intSize);
	}

	@Test
	public void isNot() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		Condition<List<?>> size = new Condition<List<?>>(s -> s.size() > 3, "size");
		assertThat(list).isNot(size);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		Condition<List<?>> intSize = new Condition<List<?>>(s -> s.size() > 5, "size");
		assertThat(intList).isNot(intSize);
	}

	@Test
	public void isIn() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat("Banana").isIn(list);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(8).isIn(intList);
	}

	@Test
	public void isNotIn() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat("Grape").isNotIn(list);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(1).isNotIn(intList);
	}

	@Test
	public void isInstanceOf() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).isInstanceOf(List.class);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).isInstanceOf(List.class);
	}

	@Test
	public void isNotInstanceOf() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).isNotInstanceOf(String.class);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).isNotInstanceOf(Integer.class);
	}

	@Test
	public void startsWith() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).startsWith("Durian");

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).startsWith(1);
	}

	@Test
	public void endsWith() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).endsWith("Pitaya");

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).endsWith(5);
	}
}
