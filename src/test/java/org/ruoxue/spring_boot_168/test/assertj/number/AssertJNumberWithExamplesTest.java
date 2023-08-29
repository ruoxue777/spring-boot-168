package org.ruoxue.spring_boot_168.test.assertj.number;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class AssertJNumberWithExamplesTest {

	@Test
	public void has() {
		int value = 0;
		System.out.println(value);
		assertThat(value).has(null);

		double doubleValue = 0d;
		System.out.println(doubleValue);
		assertThat(doubleValue).has(null);
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
	public void hasSameClassAs() {
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
	public void returns() {
		int value = 0;
		System.out.println(value);
		assertThat(value).returns(null, null);

		double doubleValue = 0d;
		System.out.println(doubleValue);
		assertThat(doubleValue).returns(null, null);
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
	public void doesNotHaveSameClassAs() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).doesNotHaveDuplicates();

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).doesNotHaveDuplicates();
	}

	@Test
	public void doesNotReturn() {
		int value = 0;
		System.out.println(value);
		assertThat(value).doesNotReturn(null, null);

		double doubleValue = 0d;
		System.out.println(doubleValue);
		assertThat(doubleValue).doesNotReturn(null, null);
	}
}
