package org.ruoxue.spring_boot_168.test.assertj.array;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class AssertJArrayAssertionsTest {

	@Test
	public void contains() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).contains("Guava", "Durian");

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).contains(1, 2, 3);
	}

	@Test
	public void doesNotContain() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).doesNotContain("Mango");

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).doesNotContain(9);
	}

	@Test
	public void containsOnly() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).containsOnly("Guava", "Pitaya", "Durian");

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).containsOnly(5, 4, 1, 2, 3);
	}
	
	@Test
	public void containsOnlyOnce() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya"};
		System.out.println(Arrays.toString(array));
		assertThat(array).containsOnlyOnce("Guava");

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).containsOnlyOnce(3);
	}

	@Test
	public void containsExactly() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).containsExactly("Durian", "Guava", "Pitaya");

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).containsOnly(1, 2, 3, 4, 5);
	}

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
