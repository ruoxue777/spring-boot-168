package org.ruoxue.spring_boot_168.test.assertj.map;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class UnitTestMapWithAssertJTest {

	@Test
	public void is() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		assertThat(map).is(null);
	}

	@Test
	public void isNot() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		assertThat(map).isNot(null);
	}

	@Test
	public void isIn() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		assertThat(map).isIn((Iterable) null);
	}

	@Test
	public void isInWithArray() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		assertThat(map).isIn((Object[]) null);
	}

	@Test
	public void isNotIn() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		assertThat(map).isNotIn((Iterable) null);
	}

	@Test
	public void isNotInWithArray() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		assertThat(map).isNotIn((Object[]) null);
	}
}
