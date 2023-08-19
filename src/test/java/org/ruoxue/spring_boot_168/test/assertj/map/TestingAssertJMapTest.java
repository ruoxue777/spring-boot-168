package org.ruoxue.spring_boot_168.test.assertj.map;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class TestingAssertJMapTest {

	@Test
	public void are() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		Condition<String> length = new Condition<String>(s -> s.length() > 4, "length");
		assertThat(map.keySet()).are(length);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		Condition<Integer> intValue = new Condition<Integer>(i -> i > 0, "value");
		assertThat(intMap.values()).are(intValue);
	}

	@Test
	public void areAtLeast() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		Condition<String> length = new Condition<String>(s -> s.length() > 5, "length");
		assertThat(map.keySet()).areAtLeast(1, length);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		Condition<Integer> intValue = new Condition<Integer>(i -> i > 1, "value");
		assertThat(intMap.values()).areAtLeast(2, intValue);
	}

	@Test
	public void areAtLeastOne() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		Condition<String> length = new Condition<String>(s -> s.length() > 5, "length");
		assertThat(map.keySet()).areAtLeastOne(length);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		Condition<Integer> intValue = new Condition<Integer>(i -> i > 4, "value");
		assertThat(intMap.values()).areAtLeastOne(intValue);
	}

	@Test
	public void areAtMost() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		Condition<String> length = new Condition<String>(s -> s.length() > 6, "length");
		assertThat(map.keySet()).areAtMost(1, length);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		Condition<Integer> intValue = new Condition<Integer>(i -> i > 18, "value");
		assertThat(intMap.values()).areAtMost(2, intValue);
	}

	@Test
	public void areExactly() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		Condition<String> length = new Condition<String>(s -> s.length() > 5, "length");
		assertThat(map.keySet()).areExactly(1, length);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		Condition<Integer> intValue = new Condition<Integer>(i -> i > 18, "value");
		assertThat(intMap.values()).areExactly(2, intValue);
	}

	@Test
	public void areNot() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		Condition<String> length = new Condition<String>(s -> s.length() > 10, "length");
		assertThat(map.keySet()).areNot(length);

		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		Condition<Integer> intValue = new Condition<Integer>(i -> i > 20, "value");
		assertThat(intMap.values()).areNot(intValue);
	}

	@Test
	public void as() {
		int expectedSize = 2;
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		String text = "Size expected: [" + expectedSize + "] but was: [" + map.size() + "]";
		try {
			Supplier<String> desc = () -> text;
			assertThat(map).as(desc).hasSize(expectedSize);
		} catch (AssertionError e) {
			e.printStackTrace();
			assertThat(e).hasMessageContaining(text);
		}
	}
}
