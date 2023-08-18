package org.ruoxue.spring_boot_168.test.assertj.map;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class AssertJMapMethodsTest {

	@Test
	public void isNull() {
		Map<String, Integer> map = null;
		System.out.println(map);
		assertThat(map).isNull();

		Map<Integer, Integer> intMap = null;
		System.out.println(intMap);
		assertThat(intMap).isNull();
	}

	@Test
	public void isNotNull() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).isNotNull();

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		assertThat(intMap).isNotNull();
	}

	@Test
	public void isEmpty() {
		Map<String, Integer> map = new HashMap<>();
		System.out.println(map);
		assertThat(map).isEmpty();

		Map<Integer, Integer> intMap = new HashMap<>();
		System.out.println(intMap);
		assertThat(intMap).isEmpty();
	}

	@Test
	public void isNotEmpty() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).isNotEmpty();

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		assertThat(intMap).isNotEmpty();
	}

	@Test
	public void isNullOrEmpty() {
		Map<String, Integer> map = null;
		System.out.println(map);
		map = new HashMap<>();
		System.out.println(map);
		assertThat(map).isNullOrEmpty();

		Map<Integer, Integer> intMap = null;
		System.out.println(intMap);
		intMap = new HashMap<>();
		System.out.println(intMap);
		assertThat(intMap).isNullOrEmpty();
	}

	@Test
	public void isEqualTo() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		Map<String, Integer> map2 = new HashMap<>(map);
		System.out.println(map);
		System.out.println(map2);
		assertThat(map).isEqualTo(map2);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		Map<Integer, Integer> intMap2 = new HashMap<>(intMap);
		System.out.println(intMap);
		System.out.println(intMap2);
		assertThat(intMap).isEqualTo(intMap2);
	}

	@Test
	public void isNotEqualTo() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		Map<String, Integer> map2 = new HashMap<>();
		System.out.println(map);
		System.out.println(map2);
		assertThat(map).isNotEqualTo(map2);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		Map<Integer, Integer> intMap2 = new HashMap<>();
		System.out.println(intMap);
		System.out.println(intMap2);
		assertThat(intMap).isNotEqualTo(intMap2);
	}

	@Test
	public void isSameAs() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		Map<String, Integer> map2 = map;
		System.out.println(map);
		System.out.println(map2);
		assertThat(map).isSameAs(map2);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		Map<Integer, Integer> intMap2 = intMap;
		System.out.println(intMap);
		System.out.println(intMap2);
		assertThat(intMap).isSameAs(intMap2);
	}

	@Test
	public void isNotSameAs() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		Map<String, Integer> map2 = new HashMap<>(map);
		System.out.println(map);
		System.out.println(map2);
		assertThat(map).isNotSameAs(map2);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		Map<Integer, Integer> intMap2 = new HashMap<>(intMap);
		System.out.println(intMap);
		System.out.println(intMap2);
		assertThat(intMap).isNotSameAs(intMap2);
	}
}
