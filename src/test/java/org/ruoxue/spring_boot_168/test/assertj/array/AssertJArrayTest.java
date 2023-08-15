package org.ruoxue.spring_boot_168.test.assertj.array;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class AssertJArrayTest {

	@Test
	public void contains() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).contains("Guava", "Durian");
	}

	@Test
	public void doesNotContain() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).doesNotContain("Mango");
	}

	@Test
	public void containsOnly() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).containsOnly("Guava", "Pitaya", "Durian");
	}

	@Test
	public void containsExactly() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).containsExactly("Durian", "Guava", "Pitaya");
	}

	@Test
	public void containsAnyOf() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).containsAnyOf("Durian", "Guava", "Mango");
	}

	@Test
	public void containsAtIndex() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).contains("Durian", atIndex(0)).contains("Guava", atIndex(1)).contains("Pitaya", atIndex(2));
	}

	@Test
	public void containsNull() {
		String[] array = new String[] { "Durian", "Guava", null };
		System.out.println(Arrays.toString(array));
		assertThat(array).containsNull();
	}

	@Test
	public void doesNotContainNull() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).doesNotContainNull();
	}
}
