package org.ruoxue.spring_boot_168.test.assertj.map;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class AssertJMapAssertionsTest {

	@Test
	public void containsKeys() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).containsKeys("Grape", "Kiwifruit");

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		assertThat(intMap).containsKeys(1, 2);
	}

	@Test
	public void containsOnlyKeys() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		List<String> keys = Arrays.asList("Lemon", "Grape", "Kiwifruit");
		assertThat(map).containsOnlyKeys(keys);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		List<Integer> intKeys = Arrays.asList(3, 1, 2);
		assertThat(intMap).containsOnlyKeys(intKeys);
	}

	@Test
	public void doesNotContainKeys() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).doesNotContainKeys("Papaya", "Strawberry");

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		assertThat(intMap).doesNotContainKeys(8, 9);
	}

	@Test
	public void containsValues() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).containsValues(18, 19);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		assertThat(intMap).containsValues(18, 19);
	}

	@Test
	public void doesNotContainValue() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).doesNotContainValue(30);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		assertThat(intMap).doesNotContainValue(99);
	}

	@Test
	public void containsEntry() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).containsEntry("Grape", 18);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		assertThat(intMap).containsEntry(1, 18);
	}

	@Test
	public void doesNotContainEntry() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).doesNotContainEntry("Papaya", 28);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		assertThat(intMap).doesNotContainEntry(9, 99);
	}

	@Test
	public void containsOnly() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).containsOnly(entry("Kiwifruit", 19), entry("Lemon", 20), entry("Grape", 18));

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		assertThat(intMap).containsOnly(entry(2, 19), entry(3, 20), entry(1, 18));
	}

	@Test
	public void containsExactly() {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).containsExactly(entry("Grape", 18), entry("Kiwifruit", 19), entry("Lemon", 20));

		Map<Integer, Integer> intMap = new LinkedHashMap<Integer, Integer>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		assertThat(intMap).containsExactly(entry(1, 18), entry(2, 19), entry(3, 20));
	}

	@Test
	public void containsAnyOf() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).containsAnyOf(entry("Papaya", 28), entry("Grape", 18), entry("Strawberry", 38));

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		assertThat(intMap).containsAnyOf(entry(9, 28), entry(1, 18), entry(3, 20));
	}
}
