package org.ruoxue.spring_boot_168.test.assertj.number;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

public class AssertJNumberAssertionsTest {

	@Test
	public void isCloseTo() {
		Integer value = 155;
		assertThat(value).isCloseTo(new Integer(150), Offset.offset(5));
		assertThat(value).isCloseTo(new Integer(160), Offset.offset(5));
	}

	@Test
	public void doesNotContain() {
		String[] value = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(value));
		assertThat(value).doesNotContain("Mango");

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).doesNotContain(9);
	}

	@Test
	public void containsOnly() {
		String[] value = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(value));
		assertThat(value).containsOnly("Guava", "Pitaya", "Durian");

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).containsOnly(5, 4, 1, 2, 3);
	}

	@Test
	public void containsOnlyOnce() {
		String[] value = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(value));
		assertThat(value).containsOnlyOnce("Guava");

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).containsOnlyOnce(3);
	}

	@Test
	public void containsOnlyNulls() {
		String[] value = new String[] { null, null, null };
		System.out.println(Arrays.toString(value));
		assertThat(value).containsOnlyNulls();

		Integer[] intArray = new Integer[] { null, null, null, null, null };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).containsOnlyNulls();
	}

	@Test
	public void containsAll() {
		String[] value = new String[] { "Durian", "Guava", "Pitaya" };
		List<String> list = Arrays.asList("Durian", "Guava");
		System.out.println(Arrays.toString(value));
		System.out.println(list);
		assertThat(value).containsAll(list);

		Integer[] intArray = new Integer[] { 1, 2, 3, 4, 5 };
		List<Integer> intList = Arrays.asList(1, 2, 3);
		System.out.println(Arrays.toString(intArray));
		System.out.println(intList);
		assertThat(intArray).containsAll(intList);
	}

	@Test
	public void containsExactly() {
		String[] value = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(value));
		assertThat(value).containsExactly("Durian", "Guava", "Pitaya");

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).containsOnly(1, 2, 3, 4, 5);
	}

	@Test
	public void containsExactlyInAnyOrder() {
		String[] value = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(value));
		assertThat(value).containsExactlyInAnyOrder("Guava", "Pitaya", "Durian");

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).containsExactlyInAnyOrder(5, 4, 1, 2, 3);
	}
}
