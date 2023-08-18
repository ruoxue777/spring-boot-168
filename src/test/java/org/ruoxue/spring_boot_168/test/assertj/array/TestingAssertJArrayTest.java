package org.ruoxue.spring_boot_168.test.assertj.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.function.Supplier;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class TestingAssertJArrayTest {

	@Test
	public void are() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		Condition<String> length = new Condition<String>(s -> s.length() > 4, "length");
		assertThat(array).are(length);

		Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		Condition<Integer> intValue = new Condition<Integer>(i -> i > 0, "value");
		assertThat(intArray).are(intValue);
	}

	@Test
	public void areAtLeast() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		Condition<String> length = new Condition<String>(s -> s.length() > 5, "length");
		assertThat(array).areAtLeast(2, length);

		Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		Condition<Integer> intValue = new Condition<Integer>(i -> i > 1, "value");
		assertThat(intArray).areAtLeast(2, intValue);
	}

	@Test
	public void areAtLeastOne() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		Condition<String> length = new Condition<String>(s -> s.length() > 5, "length");
		assertThat(array).areAtLeastOne(length);

		Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		Condition<Integer> intValue = new Condition<Integer>(i -> i > 4, "value");
		assertThat(intArray).areAtLeastOne(intValue);
	}

	@Test
	public void areAtMost() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		Condition<String> length = new Condition<String>(s -> s.length() > 5, "length");
		assertThat(array).areAtMost(2, length);

		Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		Condition<Integer> intValue = new Condition<Integer>(i -> i > 3, "value");
		assertThat(intArray).areAtMost(2, intValue);
	}

	@Test
	public void areExactly() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		Condition<String> length = new Condition<String>(s -> s.length() > 5, "length");
		assertThat(array).areExactly(2, length);

		Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		Condition<Integer> intValue = new Condition<Integer>(i -> i > 3, "value");
		assertThat(intArray).areExactly(2, intValue);
	}

	@Test
	public void areNot() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		Condition<String> length = new Condition<String>(s -> s.length() > 6, "length");
		assertThat(array).areNot(length);

		Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		Condition<Integer> intValue = new Condition<Integer>(i -> i > 6, "value");
		assertThat(intArray).areNot(intValue);
	}

	@Test
	public void as() {
		int expectedSize = 2;
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		String text = "Length expected: [" + expectedSize + "] but was: [" + array.length + "]";
		try {
			Supplier<String> desc = () -> text;
			assertThat(array).as(desc).hasSize(expectedSize);
		} catch (AssertionError e) {
			e.printStackTrace();
			assertThat(e).hasMessageContaining(text);
		}
	}
}
