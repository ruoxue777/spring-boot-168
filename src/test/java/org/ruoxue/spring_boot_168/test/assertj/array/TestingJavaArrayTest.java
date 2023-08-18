package org.ruoxue.spring_boot_168.test.assertj.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

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

	@Test
	public void isIn() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat("Guava").isIn(array);

		Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(3).isIn(intArray);
	}

	@Test
	public void isNotIn() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat("Mango").isNotIn(array);

		Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(9).isNotIn(intArray);
	}

	@Test
	public void startsWith() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).startsWith("Durian");

		Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).startsWith(1);
	}
	
	@Test
	public void endsWith() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).endsWith("Pitaya");

		Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).endsWith(5);
	}
}
