package org.ruoxue.spring_boot_168.test.assertj;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertJMapTest {

	public AssertJMapTest() {

	}

	@NoArgsConstructor
	@Getter
	@Setter
	@Builder
	public static class Fruit {
		private String name;
		private double quantity;
		private int type;

		public Fruit(String name, double quantity, int type) {
			this.name = name;
			this.quantity = quantity;
			this.type = type;
		}

		public String toString() {
			ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
			builder.appendSuper(super.toString());
			builder.append("name", name);
			builder.append("quantity", quantity);
			builder.append("type", type);
			return builder.toString();
		}
	}
	
	@Test
	public void hasSize() {
		int expectedSize = 3;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).hasSize(expectedSize);
	}

	@Test
	public void containsKeys() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).containsKeys("Grape", "Kiwifruit");
	}

	@Test
	public void doesNotContainKeys() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).doesNotContainKeys("Papaya", "Strawberry");
	}

	@Test
	public void containsValues() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).containsValues(18, 19);
	}

	@Test
	public void doesNotContainValue() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).doesNotContainValue(30);
	}

	@Test
	public void containsEntry() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).containsEntry("Grape", 18);
	}

	@Test
	public void doesNotContainEntry() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).doesNotContainEntry("Papaya", 28);
	}

	@Test
	public void containsOnly() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).containsOnly(entry("Kiwifruit", 19), entry("Lemon", 20), entry("Grape", 18));
	}

	@Test
	public void containsExactly() {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).containsExactly(entry("Grape", 18), entry("Kiwifruit", 19), entry("Lemon", 20));
	}

	@Test
	public void containsAnyOf() {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).containsAnyOf(entry("Papaya", 28), entry("Grape", 18), entry("Strawberry", 38));
	}

	@Test
	public void isEqualTo() {
		Fruit amy = new Fruit("Grape", 18, 3);
		Fruit betty = new Fruit("Kiwifruit", 19, 3);
		Fruit clare = new Fruit("Lemon", 20, 3);
		Map<String, Fruit> map = new LinkedHashMap<String, Fruit>();
		map.put(amy.getName(), amy);
		map.put(betty.getName(), betty);
		map.put(clare.getName(), clare);
		Map<String, Fruit> map2 = new LinkedHashMap<String, Fruit>();
		map2.put(amy.getName(), amy);
		map2.put(betty.getName(), betty);
		map2.put(clare.getName(), clare);
		System.out.println(map);
		assertThat(map).isEqualTo(map2);
	}
}
