package org.ruoxue.spring_boot_168.test.assertj.map;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class UnitTestAssertJMapWithExamplesTest {

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
	public void containsAllEntriesOf() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		Map<String, Integer> map2 = new HashMap<>();
		map2.put("Grape", 18);
		map2.put("Kiwifruit", 19);
		System.out.println(map);
		System.out.println(map2);
		assertThat(map).containsAllEntriesOf(map2);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		Map<Integer, Integer> intMap2 = new HashMap<>();
		intMap2.put(1, 18);
		intMap2.put(2, 19);
		System.out.println(intMap);
		System.out.println(intMap2);
		assertThat(intMap).containsAllEntriesOf(intMap2);
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
	public void containsExactlyEntriesOf() {
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
		assertThat(map).containsExactlyEntriesOf(map2);

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
		assertThat(intMap).containsExactlyEntriesOf(intMap2);
	}
	
	@Test
	public void containsExactlyInAnyOrderEntriesOf() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		Map<String, Integer> map2 = new LinkedHashMap<>();
		map2.put("Lemon", 20);
		map2.put("Kiwifruit", 19);
		map2.put("Grape", 18);
		System.out.println(map);
		System.out.println(map2);
		assertThat(map).containsExactlyInAnyOrderEntriesOf(map2);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		Map<Integer, Integer> intMap2 = new LinkedHashMap<>();
		intMap2.put(3, 20);
		intMap2.put(2, 19);
		intMap2.put(1, 18);
		System.out.println(intMap);
		System.out.println(intMap2);
		assertThat(intMap).containsExactlyInAnyOrderEntriesOf(intMap2);
	}
}
