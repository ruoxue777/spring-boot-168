package org.ruoxue.spring_boot_168.test.assertj.map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.assertj.core.api.Condition;
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
	public void matches() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new HashMap<>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		assertThat(map).matches(m -> m.get("Kiwifruit") != null);

		Predicate<Map<String, Fruit>> keyQuantity = m -> m.entrySet().stream()
				.anyMatch((Map.Entry<String, Fruit> e) -> "Kiwifruit".equals(e.getKey())
						&& Double.compare(e.getValue().getQuantity(), 1d) == 0);
		assertThat(map).matches(keyQuantity, "keyQuantity");
	}

	@Test
	public void satisfies() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new HashMap<>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		Condition<Map<String, Fruit>> size = new Condition<Map<String, Fruit>>(m -> m.size() > 2, "size");
		assertThat(map).satisfies(size);

		Predicate<Map<String, Fruit>> predcate = m -> m.entrySet().stream()
				.anyMatch((Map.Entry<String, Fruit> e) -> "Kiwifruit".equals(e.getKey())
						&& Double.doubleToLongBits(e.getValue().getQuantity()) == Double.doubleToLongBits(1d));
		Condition<Map<String, Fruit>> keyQuantity = new Condition<Map<String, Fruit>>(predcate, "keyQuantity");
		assertThat(map).satisfies(keyQuantity);
	}

	@Test
	public void satisfiesAnyOf() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new HashMap<>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		assertThat(map).satisfiesAnyOf(m -> {
			assertThat(m.get("Kiwifruit")).isNotNull();
		});
	}

	@Test
	public void hasFieldOrProperty() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new HashMap<>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		assertThat(map).hasFieldOrProperty("Kiwifruit");

	}

	@Test
	public void hasFieldOrPropertyWithValue() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new HashMap<>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		assertThat(map).hasFieldOrPropertyWithValue("Kiwifruit", kiwifruit);
	}

	@Test
	public void hasAllNullFieldsOrPropertiesExcept() {
		Map<String, Fruit> map = new HashMap<>();
		System.out.println(map);
		assertThat(map).hasAllNullFieldsOrPropertiesExcept("size", "modCount", "threshold", "loadFactor", "entrySet");
	}

	@Test
	public void hasNoNullFieldsOrPropertiesExcept() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new HashMap<>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		assertThat(map).hasNoNullFieldsOrPropertiesExcept("keySet", "values");
	}
}
