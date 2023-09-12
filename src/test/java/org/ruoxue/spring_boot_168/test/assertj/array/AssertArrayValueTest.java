package org.ruoxue.spring_boot_168.test.assertj.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;
import org.ruoxue.spring_boot_168.test.assertj.array.AssertingArraysWithExamplesTest.Fruit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertArrayValueTest {

	@NoArgsConstructor
	@Getter
	@Setter
	public static class Fruit {
		private String name;
		private double quantity;
		private int type;
		private List<String> origins = new ArrayList<>();

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
			builder.append("origins", origins);
			return builder.toString();
		}
	}

	@Getter
	@Setter
	public static class SimpleFruit {
		private String name;
		private List<String> origins;

		public SimpleFruit() {
		}

		public String toString() {
			ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
			builder.appendSuper(super.toString());
			builder.append("name", name);
			builder.append("origins", origins);
			return builder.toString();
		}
	}

	@Test
	public void matches() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 2);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 2);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).matches(o -> o != null);

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
	public void hasAllNullFieldsOrProperties() {
		SimpleFruit grape = new SimpleFruit("Grape");
		grape.setName(null);
		grape.setOrigins(null);
		SimpleFruit kiwifruit = new SimpleFruit("Kiwifruit");
		kiwifruit.setName(null);
		kiwifruit.setOrigins(null);
		SimpleFruit lemon = new SimpleFruit("Lemon");
		lemon.setName(null);
		lemon.setOrigins(null);
		Map<String, SimpleFruit> map = new HashMap<>();
		map.put("Grape", grape);
		map.put("Kiwifruit", kiwifruit);
		map.put("Lemon", lemon);
		System.out.println(map);
		assertThat(map).allSatisfy((k, v) -> {
			assertThat(v).hasAllNullFieldsOrProperties();
		});
	}

	@Test
	public void hasAllNullFieldsOrPropertiesExcept() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		grape.setName(null);
		grape.setOrigins(null);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		kiwifruit.setName(null);
		kiwifruit.setOrigins(null);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		lemon.setName(null);
		lemon.setOrigins(null);
		Map<String, Fruit> map = new HashMap<>();
		map.put("Grape", grape);
		map.put("Kiwifruit", kiwifruit);
		map.put("Lemon", lemon);
		System.out.println(map);
		assertThat(map).allSatisfy((k, v) -> {
			assertThat(v).hasAllNullFieldsOrPropertiesExcept("type", "quantity");
		});
	}

	@Test
	public void hasNoNullFieldsOrProperties() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new HashMap<>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		assertThat(map).allSatisfy((k, v) -> {
			assertThat(v).hasNoNullFieldsOrProperties();
		});
	}

	@Test
	public void hasNoNullFieldsOrPropertiesExcept() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		grape.setOrigins(null);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		kiwifruit.setOrigins(null);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		lemon.setOrigins(null);
		Map<String, Fruit> map = new HashMap<>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		assertThat(map).allSatisfy((k, v) -> {
			assertThat(v).hasNoNullFieldsOrPropertiesExcept("origins");
		});
	}
}
