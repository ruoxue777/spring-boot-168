package org.ruoxue.spring_boot_168.test.assertj.set;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class AssertJSetMethodsTest {

	@Test
	public void isNull() {
		List<String> list = null;
		System.out.println(list);
		assertThat(list).isNull();

		List<Integer> intList = null;
		System.out.println(intList);
		assertThat(intList).isNull();
	}

	@Test
	public void isNotNull() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).isNotNull();

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).isNotNull();
	}

	@Test
	public void isEmpty() {
		List<String> list = new ArrayList<>();
		System.out.println(list);
		assertThat(list).isEmpty();

		List<Integer> intList = new ArrayList<>();
		System.out.println(intList);
		assertThat(intList).isEmpty();
	}

	@Test
	public void isNotEmpty() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).isNotEmpty();

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		assertThat(intList).isNotEmpty();
	}

	@Test
	public void isNullOrEmpty() {
		List<String> list = null;
		System.out.println(list);
		assertThat(list).isNullOrEmpty();
		list = new ArrayList<>();
		System.out.println(list);
		assertThat(list).isNullOrEmpty();

		List<Integer> intList = null;
		System.out.println(intList);
		intList = new ArrayList<>();
		System.out.println(intList);
		assertThat(intList).isNullOrEmpty();
	}

	@Test
	public void isEqualTo() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		List<String> list2 = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		System.out.println(list2);
		assertThat(list).isEqualTo(list2);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		List<Integer> intList2 = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		System.out.println(intList2);
		assertThat(intList).isEqualTo(intList2);
	}

	@Test
	public void isNotEqualTo() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		List<String> list2 = Arrays.asList("Apple", "Banana");
		System.out.println(list);
		System.out.println(list2);
		assertThat(list).isNotEqualTo(list2);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		int[] intList2 = new int[] { 1, 2, 3 };
		System.out.println(intList);
		System.out.println(intList2);
		assertThat(intList).isNotEqualTo(intList2);
	}

	@Test
	public void isSameAs() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		List<String> list2 = list;
		System.out.println(list);
		System.out.println(list2);
		assertThat(list).isSameAs(list2);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		List<Integer> intList2 = intList;
		System.out.println(intList);
		System.out.println(intList2);
		assertThat(intList).isSameAs(intList2);
	}

	@Test
	public void isNotSameAs() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		List<String> list2 = new ArrayList<>(list);
		System.out.println(list);
		System.out.println(list2);
		assertThat(list).isNotSameAs(list2);

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		List<Integer> intList2 = new ArrayList<>(intList);
		System.out.println(intList);
		System.out.println(intList2);
		assertThat(intList).isNotSameAs(intList2);
	}
}
