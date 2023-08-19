package org.ruoxue.spring_boot_168.test.assertj.array;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.atIndex;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class UnitTestAssertJArrayWithExamplesTest {

	@Test
	public void containsAnyOf() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).containsAnyOf("Durian", "Mango");

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).containsAnyOf(1, 9);
	}

	@Test
	public void containsAtIndex() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).contains("Durian", atIndex(0)).contains("Guava", atIndex(1)).contains("Pitaya", atIndex(2));

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).contains(1, atIndex(0)).contains(3, atIndex(2));
	}

	@Test
	public void containsSequence() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).containsSequence("Guava", "Pitaya");

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).containsSequence(4, 5);
	}

	@Test
	public void containsSubsequence() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).containsSubsequence("Guava", "Pitaya");

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).containsSubsequence(4, 5);
	}

	@Test
	public void containsNull() {
		String[] array = new String[] { "Durian", "Guava", null };
		System.out.println(Arrays.toString(array));
		assertThat(array).containsNull();

		Integer[] intArray = new Integer[] { 1, 2, 3, 4, null };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).containsNull();
	}

	@Test
	public void doesNotContainNull() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).doesNotContainNull();

		Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).doesNotContainNull();
	}
}
