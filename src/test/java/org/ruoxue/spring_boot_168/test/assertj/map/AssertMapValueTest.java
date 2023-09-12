package org.ruoxue.spring_boot_168.test.assertj.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertMapValueTest {

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
	public void hasAllNullFieldsOrProperties() {
		SimpleFruit grape = new SimpleFruit();
		SimpleFruit kiwifruit = new SimpleFruit();
		SimpleFruit lemon = new SimpleFruit();
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
			assertThat(v).hasAllNullFieldsOrPropertiesExcept("name", "type", "quantity");
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
