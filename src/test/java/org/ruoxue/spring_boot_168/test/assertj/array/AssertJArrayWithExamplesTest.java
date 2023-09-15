package org.ruoxue.spring_boot_168.test.assertj.array;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class AssertJArrayWithExamplesTest {

	@Test
	public void has() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		Condition<String[]> length = new Condition<String[]>(s -> s.length > 2, "length");
		assertThat(array).has(length);

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		Condition<int[]> intLength = new Condition<int[]>(i -> i.length > 2, "length");
		assertThat(intArray).has(intLength);
	}

	@Test
	public void hasOnlyOneElementSatisfying() {
		String[] array = new String[] { "Durian" };
		System.out.println(Arrays.toString(array));
		assertThat(array).hasOnlyOneElementSatisfying(e -> {
			assertThat(e).hasSize(6);
		});

		Integer[] intArray = new Integer[] { 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).hasOnlyOneElementSatisfying(e -> {
			assertThat(e).isGreaterThan(4);
		});
	}

	@Test
	public void hasSize() {
		int expectedSize = 3;
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).hasSize(expectedSize);

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).hasSize(5);
	}

	@Test
	public void hasSizeBetween() {
		int expectedSize = 3;
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).hasSizeBetween(1, expectedSize);

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).hasSizeBetween(1, 5);
	}

	@Test
	public void hasSizeGreaterThan() {
		int expectedSize = 2;
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).hasSizeGreaterThan(expectedSize);

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).hasSizeGreaterThan(expectedSize);
	}

	@Test
	public void hasSizeLessThan() {
		int expectedSize = 4;
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).hasSizeLessThan(expectedSize);

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).hasSizeLessThan(6);
	}

	@Test
	public void hasToString() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).hasToString(array.toString());

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).hasToString(intArray.toString());
	}

	@Test
	public void hasSameSizeAs() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		List<String> list = Arrays.asList("Durian", "Guava", "Pitaya");
		System.out.println(Arrays.toString(array));
		System.out.println(list);
		assertThat(array).hasSameSizeAs(list);

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(Arrays.toString(intArray));
		System.out.println(intList);
		assertThat(intArray).hasSameSizeAs(intList);
	}

	@Test
	public void hasSameElementsAs() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		List<String> list = Arrays.asList("Durian", "Guava", "Pitaya");
		System.out.println(Arrays.toString(array));
		System.out.println(list);
		assertThat(array).hasSameElementsAs(list);

		Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5 };
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(Arrays.toString(intArray));
		System.out.println(intList);
		assertThat(intArray).hasSameElementsAs(intList);
	}

	@Test
	public void doesNotHave() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		Condition<String[]> length = new Condition<String[]>(s -> s.length > 3, "length");
		assertThat(array).doesNotHave(length);

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		Condition<int[]> intLength = new Condition<int[]>(i -> i.length > 5, "length");
		assertThat(intArray).doesNotHave(intLength);
	}

	@Test
	public void doesNotHaveDuplicates() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).doesNotHaveDuplicates();

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).doesNotHaveDuplicates();
	}
}
