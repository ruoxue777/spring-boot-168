package org.ruoxue.spring_boot_168.test.assertj.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.function.Supplier;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class TestingAssertJArrayTest {

	@Test
	public void are() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		Condition<String> length = new Condition<String>(s -> s.length() > 4, "length");
		assertThat(array).are(length);
	}

	@Test
	public void areAtLeast() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		Condition<String> length = new Condition<String>(s -> s.length() > 5, "length");
		assertThat(array).areAtLeast(1, length);
	}

	@Test
	public void areAtLeastOne() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		Condition<String> length = new Condition<String>(s -> s.length() > 5, "length");
		assertThat(array).areAtLeastOne(length);
	}

	@Test
	public void areAtMost() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		Condition<String> length = new Condition<String>(s -> s.length() > 5, "length");
		assertThat(array).areAtMost(2, length);
	}

	@Test
	public void areExactly() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		Condition<String> length = new Condition<String>(s -> s.length() > 5, "length");
		assertThat(array).areExactly(2, length);
	}

	@Test
	public void areNot() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		Condition<String> length = new Condition<String>(s -> s.length() > 6, "length");
		assertThat(array).areNot(length);
	}

	@Test
	public void as() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		Supplier<String> description = () -> "AS Description";
		assertThat(array).as(description);
	}
}
