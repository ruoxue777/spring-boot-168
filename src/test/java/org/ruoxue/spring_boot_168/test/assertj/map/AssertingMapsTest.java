package org.ruoxue.spring_boot_168.test.assertj.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertingMapsTest {

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
	public void usingDefaultComparator() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new HashMap<>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);

	}

	@Test
	public void usingComparator() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new HashMap<>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		Map<String, Fruit> map2 = new HashMap();
		map2.put(grape.getName(), grape);
		map2.put(kiwifruit.getName(), kiwifruit);
		System.out.println(map);
		Comparator<Map<String, Fruit>> comparator = (m1, m2) -> Integer.compare(m1.size(), m2.size());
		assertThat(map).usingComparator(comparator);
	}

	@Test
	public void usingElementComparator() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new HashMap<>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
	}

	@Test
	public void usingRecursiveComparison() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new HashMap<>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
	}
}
