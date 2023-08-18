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
	public void isNotIn() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		assertThat(map).isNotIn((Iterable) null);
	}

	@Test
	public void isInstanceOf() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).isInstanceOf(Map.class);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		assertThat(intMap).isInstanceOf(Map.class);
	}

	@Test
	public void isNotInstanceOf() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).isNotInstanceOf(String.class);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		assertThat(intMap).isNotInstanceOf(Integer.class);
	}
}
