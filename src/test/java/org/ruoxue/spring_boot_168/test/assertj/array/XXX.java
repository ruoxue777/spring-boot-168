package org.ruoxue.spring_boot_168.test.assertj.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.ruoxue.spring_boot_168.test.assertj.array.AssertingArraysWithExamplesTest.Fruit;

public class XXX {
	
	@Test
	public void hasNoNullFieldsOrProperties() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 2);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 2);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).allSatisfy(e -> {
			assertThat(e).hasAllNullFieldsOrPropertiesExcept("");
		});
	}

}
