package org.ruoxue.spring_boot_168.test.assertj.set;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class AssertJSetAssertionsTest {

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
	public void containsOnlyOnce() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).containsOnlyOnce("Banana");

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).containsOnlyOnce(8);
	}

	@Test
	public void containsOnlyNulls() {
		List<String> list = Arrays.asList(null, null, null);
		System.out.println(list);
		assertThat(list).containsOnlyNulls();

		List<Integer> intList = Arrays.asList(null, null, null, null, null);
		System.out.println(intList);
		assertThat(intList).containsOnlyNulls();
	}

	@Test
	public void containsAll() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		List<String> list2 = Arrays.asList("Apple", "Banana");
		System.out.println(list);
		System.out.println(list2);
		assertThat(list).containsAll(list2);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		List<Integer> intList2 = Arrays.asList(6, 7, 8);
		System.out.println(intList);
		System.out.println(intList2);
		assertThat(intList).containsAll(intList2);
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
	public void containsExactlyInAnyOrder() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).containsExactlyInAnyOrder("Cherry", "Apple", "Banana");

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).containsExactlyInAnyOrder(9, 10, 6, 7, 8);
	}
}
