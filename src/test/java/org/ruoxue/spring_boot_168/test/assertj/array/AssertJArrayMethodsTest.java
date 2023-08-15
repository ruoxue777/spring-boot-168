package org.ruoxue.spring_boot_168.test.assertj.array;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class AssertJArrayMethodsTest {

	@Test
	public void isNull() {
		String[] array = null;
		System.out.println(Arrays.toString(array));
		assertThat(array).isNull();
	}

	@Test
	public void isNotNull() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).isNotNull();
	}

	@Test
	public void isEmpty() {
		String[] array = new String[] {};
		System.out.println(Arrays.toString(array));
		assertThat(array).isEmpty();
	}

	@Test
	public void isNotEmpty() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).isNotEmpty();
	}

	@Test
	public void isInstanceOf() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).isInstanceOf(String[].class);
	}

	@Test
	public void isNotInstanceOf() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).isNotInstanceOf(String.class);
	}

	@Test
	public void isEqualTo() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		String[] array2 = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(array2));
		assertThat(array).isEqualTo(array2);
	}

	@Test
	public void isNotEqualTo() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		String[] array2 = new String[] { "Durian", "Guava" };
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(array2));
		assertThat(array).isNotEqualTo(array2);
	}

	@Test
	public void isSameAs() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		String[] array2 = array;
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(array2));
		assertThat(array).isSameAs(array2);
	}

	@Test
	public void isNotSameAs() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		String[] array2 = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(array2));
		assertThat(array).isNotSameAs(array2);
	}
}
