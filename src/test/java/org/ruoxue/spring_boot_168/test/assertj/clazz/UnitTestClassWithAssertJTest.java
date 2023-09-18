package org.ruoxue.spring_boot_168.test.assertj.clazz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class UnitTestClassWithAssertJTest {

//	@Test
//	public void is() {
//		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
//		System.out.println(list);
//		Condition<List<?>> size = new Condition<List<?>>(s -> s.size() > 2, "size");
//		assertThat(list).is(size);
//
//		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
//		System.out.println(intList);
//		Condition<List<?>> intSize = new Condition<List<?>>(i -> i.size() > 2, "size");
//		assertThat(intList).is(intSize);
//		
//		Class<?> clazz = String.class;
//		System.out.println(clazz);
//		Condition<String> size = new Condition<String>(s -> s.size() > 2, "size");
//		assertThat(clazz).is(condition);
//
//		Class<?> intClazz = Integer.class;
//		System.out.println(intClazz);
//		assertThat(intClazz).is(condition);
//	}
//
//	@Test
//	public void isNot() {
//		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
//		System.out.println(list);
//		Condition<List<?>> size = new Condition<List<?>>(s -> s.size() > 3, "size");
//		assertThat(list).isNot(size);
//
//		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
//		System.out.println(intList);
//		Condition<List<?>> intSize = new Condition<List<?>>(s -> s.size() > 5, "size");
//		assertThat(intList).isNot(intSize);
//	}
//
//	@Test
//	public void isIn() {
//		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
//		System.out.println(list);
//		assertThat("Banana").isIn(list);
//
//		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
//		System.out.println(intList);
//		assertThat(8).isIn(intList);
//	}
//
//	@Test
//	public void isNotIn() {
//		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
//		System.out.println(list);
//		assertThat("Grape").isNotIn(list);
//
//		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
//		System.out.println(intList);
//		assertThat(1).isNotIn(intList);
//	}
//
//	@Test
//	public void isInstanceOf() {
//		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
//		System.out.println(list);
//		assertThat(list).isInstanceOf(List.class);
//
//		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
//		System.out.println(intList);
//		assertThat(intList).isInstanceOf(List.class);
//	}
//
//	@Test
//	public void isNotInstanceOf() {
//		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
//		System.out.println(list);
//		assertThat(list).isNotInstanceOf(String.class);
//
//		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
//		System.out.println(intList);
//		assertThat(intList).isNotInstanceOf(Integer.class);
//	}
//
//	@Test
//	public void startsWith() {
//		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
//		System.out.println(list);
//		assertThat(list).startsWith("Apple");
//
//		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
//		System.out.println(intList);
//		assertThat(intList).startsWith(6);
//	}
//
//	@Test
//	public void endsWith() {
//		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
//		System.out.println(list);
//		assertThat(list).endsWith("Cherry");
//
//		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
//		System.out.println(intList);
//		assertThat(intList).endsWith(10);
//	}
}
