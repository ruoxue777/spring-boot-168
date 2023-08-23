package org.ruoxue.spring_boot_168.test.assertj.string;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class AssertJStringMethodsTest {

	@Test
	public void isNull() {
		String value = null;
		System.out.println(value);
		assertThat(value).isNull();
	}

	@Test
	public void isNotNull() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).isNotNull();
	}

	@Test
	public void isEmpty() {
		String[] value = new String[] {};
		System.out.println(Arrays.toString(value));
		assertThat(value).isEmpty();

		int[] intArray = new int[] {};
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).isEmpty();
	}

	@Test
	public void isNotEmpty() {
		String[] value = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(value));
		assertThat(value).isNotEmpty();

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).isNotEmpty();
	}

	@Test
	public void isNullOrEmpty() {
		String[] value = null;
		System.out.println(Arrays.toString(value));
		assertThat(value).isNullOrEmpty();
		value = new String[] {};
		System.out.println(Arrays.toString(value));
		assertThat(value).isNullOrEmpty();

		int[] intArray = null;
		System.out.println(Arrays.toString(intArray));
		intArray = new int[] {};
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).isNullOrEmpty();
	}

	@Test
	public void isEqualTo() {
		String[] value = new String[] { "Durian", "Guava", "Pitaya" };
		String[] value2 = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(value));
		System.out.println(Arrays.toString(value2));
		assertThat(value).isEqualTo(value2);

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		int[] intArray2 = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		System.out.println(Arrays.toString(intArray2));
		assertThat(intArray).isEqualTo(intArray2);
	}

	@Test
	public void isNotEqualTo() {
		String[] value = new String[] { "Durian", "Guava", "Pitaya" };
		String[] value2 = new String[] { "Durian", "Guava" };
		System.out.println(Arrays.toString(value));
		System.out.println(Arrays.toString(value2));
		assertThat(value).isNotEqualTo(value2);

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		int[] intArray2 = new int[] { 1, 2, 3 };
		System.out.println(Arrays.toString(intArray));
		System.out.println(Arrays.toString(intArray2));
		assertThat(intArray).isNotEqualTo(intArray2);
	}

	@Test
	public void isSameAs() {
		String[] value = new String[] { "Durian", "Guava", "Pitaya" };
		String[] value2 = value;
		System.out.println(Arrays.toString(value));
		System.out.println(Arrays.toString(value2));
		assertThat(value).isSameAs(value2);

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		int[] intArray2 = intArray;
		System.out.println(Arrays.toString(intArray));
		System.out.println(Arrays.toString(intArray2));
		assertThat(intArray).isSameAs(intArray2);
	}

	@Test
	public void isNotSameAs() {
		String[] value = new String[] { "Durian", "Guava", "Pitaya" };
		String[] value2 = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(value));
		System.out.println(Arrays.toString(value2));
		assertThat(value).isNotSameAs(value2);

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		int[] intArray2 = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		System.out.println(Arrays.toString(intArray2));
		assertThat(intArray).isNotSameAs(intArray2);
	}
}
