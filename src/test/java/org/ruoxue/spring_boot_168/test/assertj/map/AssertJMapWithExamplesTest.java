package org.ruoxue.spring_boot_168.test.assertj.map;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class AssertJMapWithExamplesTest {

	@Test
	public void has() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		Condition<Map<?, ?>> size = new Condition<Map<?, ?>>(s -> s.size() > 2, "size");
		assertThat(map).has(size);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		Condition<Map<?, ?>> intSize = new Condition<Map<?, ?>>(i -> i.size() > 2, "size");
		assertThat(intMap).has(intSize);
	}

	@Test
	public void hasSize() {
		int expectedSize = 3;
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).hasSize(expectedSize);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		assertThat(intMap).hasSize(expectedSize);
	}

	@Test
	public void hasSizeBetween() {
		int expectedSize = 3;
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).hasSizeBetween(1, expectedSize);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		assertThat(intMap).hasSizeBetween(1, expectedSize);
	}

	@Test
	public void hasSizeGreaterThan() {
		int expectedSize = 2;
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).hasSizeGreaterThan(expectedSize);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		assertThat(intMap).hasSizeGreaterThan(expectedSize);
	}

	@Test
	public void hasSizeLessThan() {
		int expectedSize = 4;
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).hasSizeLessThan(expectedSize);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		assertThat(intMap).hasSizeLessThan(expectedSize);
	}

	@Test
	public void hasToString() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).hasToString(map.toString());

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		assertThat(intMap).hasToString(intMap.toString());
	}

	@Test
	public void hasSameSizeAs() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		Map<String, Integer> map2 = new HashMap<>();
		map2.put("Grape", 18);
		map2.put("Kiwifruit", 19);
		map2.put("Lemon", 20);
		System.out.println(map);
		System.out.println(map2);
		assertThat(map).hasSameSizeAs(map2);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		Map<Integer, Integer> intMap2 = new HashMap<>();
		intMap2.put(1, 18);
		intMap2.put(2, 19);
		intMap2.put(3, 20);
		System.out.println(intMap);
		System.out.println(intMap2);
		assertThat(intMap).hasSameSizeAs(intMap2);
	}

	@Test
	public void doesNotHave() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		Condition<Map<?, ?>> size = new Condition<Map<?, ?>>(s -> s.size() > 3, "size");
		assertThat(map).doesNotHave(size);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		Condition<Map<?, ?>> intSize = new Condition<Map<?, ?>>(i -> i.size() > 3, "size");
		assertThat(intMap).doesNotHave(intSize);
	}
}
