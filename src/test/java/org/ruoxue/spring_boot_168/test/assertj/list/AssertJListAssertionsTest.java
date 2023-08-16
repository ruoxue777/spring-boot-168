package org.ruoxue.spring_boot_168.test.assertj.list;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class AssertJListAssertionsTest {

	@Test
	public void contains() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).contains("Banana", "Apple");

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).contains(6, 7, 8);
	}

	@Test
	public void doesNotContain() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).doesNotContain("Grape");

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).doesNotContain(1);
	}

	@Test
	public void containsOnly() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).containsOnly("Banana", "Cherry", "Apple");

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).containsOnly(10, 9, 8, 7, 6);
	}

	@Test
	public void containsExactly() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).containsExactly("Apple", "Banana", "Cherry");

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).containsExactly(6, 7, 8, 9, 10);
	}

	@Test
	public void containsAnyOf() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).containsAnyOf("Grape", "Banana", "Kiwifruit");

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).containsAnyOf(6, 1);
	}

	@Test
	public void containsAtIndex() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).contains("Apple", atIndex(0)).contains("Banana", atIndex(1)).contains("Cherry", atIndex(2));

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).contains(6, atIndex(0)).contains(8, atIndex(2));
	}

	@Test
	public void containsNull() {
		List<String> list = Arrays.asList("Apple", "Banana", null);
		System.out.println(list);
		assertThat(list).containsNull();

		List<Integer> intList = Stream.of(6, 7, 8, 9, null).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).containsNull();
	}

	@Test
	public void doesNotContainNull() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).doesNotContainNull();

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).doesNotContainNull();
	}
}
