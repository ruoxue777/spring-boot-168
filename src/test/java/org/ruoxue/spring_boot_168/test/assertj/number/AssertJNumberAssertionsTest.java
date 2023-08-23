package org.ruoxue.spring_boot_168.test.assertj.number;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AssertJNumberAssertionsTest {

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
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).containsOnlyOnce("Guava");

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).containsOnlyOnce(3);
	}

	@Test
	public void containsOnlyNulls() {
		String[] array = new String[] { null, null, null };
		System.out.println(Arrays.toString(array));
		assertThat(array).containsOnlyNulls();

		Integer[] intArray = new Integer[] { null, null, null, null, null };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).containsOnlyNulls();
	}

	@Test
	public void containsAll() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		List<String> list = Arrays.asList("Durian", "Guava");
		System.out.println(Arrays.toString(array));
		System.out.println(list);
		assertThat(array).containsAll(list);

		Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5 };
		List<Integer> intList = Arrays.asList(1, 2, 3);
		System.out.println(Arrays.toString(intArray));
		System.out.println(intList);
		assertThat(intArray).containsAll(intList);
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
	public void containsExactlyInAnyOrder() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).containsExactlyInAnyOrder("Guava", "Pitaya", "Durian");

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).containsExactlyInAnyOrder(5, 4, 1, 2, 3);
	}
}
