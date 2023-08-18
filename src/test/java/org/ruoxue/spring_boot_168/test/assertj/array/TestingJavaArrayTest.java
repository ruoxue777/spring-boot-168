package org.ruoxue.spring_boot_168.test.assertj.array;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class TestingJavaArrayTest {

	@Test
	public void is() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		Condition<String[]> length = new Condition<String[]>(s -> s.length > 2, "length");
		System.out.println(Arrays.toString(array));
		assertThat(array).is(length);

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		Condition<int[]> intLength = new Condition<int[]>(i -> i.length > 2, "length");
		assertThat(intArray).is(intLength);
	}

	@Test
	public void isNot() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		Condition<String[]> length = new Condition<String[]>(s -> s.length > 3, "length");
		assertThat(array).isNot(length);

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		Condition<int[]> intLength = new Condition<int[]>(i -> i.length > 5, "length");
		assertThat(intArray).isNot(intLength);
	}

//	@Test
//	public void isIn() {
//		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
//		List<String> list = Arrays.asList("Durian", "Guava", "Pitaya");
//		System.out.println(Arrays.toString(array));
//		System.out.println(list);
//		assertThat(array).isIn(list);
//
//		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
//		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
//		System.out.println(Arrays.toString(intArray));
//		System.out.println(intList);
//		assertThat(intArray).isIn(intList);
//	}
//
//	@Test
//	public void isInWithArray() {
//		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
//		assertThat(array).isIn((Object[]) null);
//	}
//
//	@Test
//	public void isNotIn() {
//		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
//		assertThat(array).isNotIn((Iterable) null);
//	}
//
//	@Test
//	public void isNotInWithArray() {
//		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
//		assertThat(array).isNotIn((Object[]) null);
//	}
}
