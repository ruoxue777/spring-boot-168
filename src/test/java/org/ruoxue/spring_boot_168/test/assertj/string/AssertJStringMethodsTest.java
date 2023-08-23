package org.ruoxue.spring_boot_168.test.assertj.string;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class AssertJStringMethodsTest {

	@Test
	public void isNull() {
		String[] array = null;
		System.out.println(Arrays.toString(array));
		assertThat(array).isNull();

		int[] intArray = null;
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).isNull();
	}

	@Test
	public void isNotNull() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).isNotNull();

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).isNotNull();
	}

	@Test
	public void isEmpty() {
		String[] array = new String[] {};
		System.out.println(Arrays.toString(array));
		assertThat(array).isEmpty();

		int[] intArray = new int[] {};
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).isEmpty();
	}

	@Test
	public void isNotEmpty() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).isNotEmpty();

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).isNotEmpty();
	}

	@Test
	public void isNullOrEmpty() {
		String[] array = null;
		System.out.println(Arrays.toString(array));
		assertThat(array).isNullOrEmpty();
		array = new String[] {};
		System.out.println(Arrays.toString(array));
		assertThat(array).isNullOrEmpty();

		int[] intArray = null;
		System.out.println(Arrays.toString(intArray));
		intArray = new int[] {};
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).isNullOrEmpty();
	}

	@Test
	public void isEqualTo() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		String[] array2 = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(array2));
		assertThat(array).isEqualTo(array2);

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		int[] intArray2 = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		System.out.println(Arrays.toString(intArray2));
		assertThat(intArray).isEqualTo(intArray2);
	}

	@Test
	public void isNotEqualTo() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		String[] array2 = new String[] { "Durian", "Guava" };
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(array2));
		assertThat(array).isNotEqualTo(array2);

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		int[] intArray2 = new int[] { 1, 2, 3 };
		System.out.println(Arrays.toString(intArray));
		System.out.println(Arrays.toString(intArray2));
		assertThat(intArray).isNotEqualTo(intArray2);
	}

	@Test
	public void isSameAs() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		String[] array2 = array;
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(array2));
		assertThat(array).isSameAs(array2);

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		int[] intArray2 = intArray;
		System.out.println(Arrays.toString(intArray));
		System.out.println(Arrays.toString(intArray2));
		assertThat(intArray).isSameAs(intArray2);
	}

	@Test
	public void isNotSameAs() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		String[] array2 = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(array2));
		assertThat(array).isNotSameAs(array2);

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		int[] intArray2 = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		System.out.println(Arrays.toString(intArray2));
		assertThat(intArray).isNotSameAs(intArray2);
	}
}
