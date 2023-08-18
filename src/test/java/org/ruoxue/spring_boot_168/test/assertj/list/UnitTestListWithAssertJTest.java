package org.ruoxue.spring_boot_168.test.assertj.list;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class UnitTestListWithAssertJTest {

	@Test
	public void is() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		assertThat(list).is(null);
	}

	@Test
	public void isNot() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		assertThat(list).isNot(null);
	}

	@Test
	public void isIn() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		assertThat(list).isIn((Iterable) null);
	}

	@Test
	public void isInWithArray() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		assertThat(list).isIn((Object[]) null);
	}

	@Test
	public void isNotIn() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		assertThat(list).isNotIn((Iterable) null);
	}

	@Test
	public void isNotInWithArray() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		assertThat(list).isNotIn((Object[]) null);
	}
}
