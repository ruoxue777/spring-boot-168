package org.ruoxue.spring_boot_168.test.assertj.set;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class UnitTestAssertJSetWithExamplesTest {

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
	public void containsSequence() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).containsSequence("Banana", "Cherry");

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).containsSequence(9, 10);
	}

	@Test
	public void doesNotContainSequence() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).doesNotContainSequence("Grape", "Banana");

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).doesNotContainSequence(1, 8);
	}

	@Test
	public void containsSubsequence() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).containsSubsequence("Apple", "Cherry");

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).containsSubsequence(6, 10);
	}

	@Test
	public void doesNotContainSubsequence() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).doesNotContainSubsequence("Cherry", "Apple");

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).doesNotContainSubsequence(10, 6);
	}

	@Test
	public void doesNotContainAnyElementsOf() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		List<String> list2 = Arrays.asList("Grape", "Kiwifruit");
		System.out.println(list);
		System.out.println(list2);
		assertThat(list).doesNotContainAnyElementsOf(list2);

		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> intList2 = Arrays.asList(8, 9);
		System.out.println(intList);
		System.out.println(intList2);
		assertThat(intList).doesNotContainAnyElementsOf(intList2);
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

	@Test
	public void contains() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		Set<String> set = new HashSet<String>();
		set.add("Banana");
		set.add("Grape");
		System.out.println(set);
		
		assertThat(list)
			.contains("Apple")
			.containsAnyOf("Apple", "Grape")
			.containsExactly("Apple", "Banana", "Cherry")
			.doesNotContain("Grape")
			.anyMatch(set::contains);
	}
}
