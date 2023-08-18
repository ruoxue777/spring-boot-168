package org.ruoxue.spring_boot_168.test.assertj.array;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestingJavaArrayTest {

	@Test
	public void is() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		assertThat(array).is(null);
	}

	@Test
	public void isNot() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		assertThat(array).isNot(null);
	}

	@Test
	public void isIn() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		assertThat(array).isIn((Iterable) null);
	}

	@Test
	public void isInWithArray() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		assertThat(array).isIn((Object[]) null);
	}

	@Test
	public void isNotIn() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		assertThat(array).isNotIn((Iterable) null);
	}

	@Test
	public void isNotInWithArray() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		assertThat(array).isNotIn((Object[]) null);
	}
}
