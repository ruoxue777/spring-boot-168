package org.ruoxue.spring_boot_168.test.assertj.map;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertingMapsMethodsTest {

	@NoArgsConstructor
	@Getter
	@Setter
	@Builder
	public static class Fruit {
		private String name;
		private double quantity;
		private int type;
		private List<String> origins = new ArrayList<>();

		public Fruit(String name, double quantity, int type, List<String> origins) {
			this.name = name;
			this.quantity = quantity;
			this.type = type;
			this.origins = origins;
		}

		public Fruit(String name, double quantity, int type) {
			this(name, quantity, type, new ArrayList<>());
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

	@Test
	public void extracting() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new HashMap<>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		assertThat(map).extracting(m -> m.get("Grape"), m -> m.get("Kiwifruit")).contains(grape, kiwifruit);
		assertThat(map).extracting(m -> m.get("Papaya")).isNull();
	}

	@Test
	public void extractingWithKey() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1, Arrays.asList("Australia"));
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2, Arrays.asList("Canada", "Norway"));
		Fruit lemon = new Fruit("Lemon", -1, 3, Arrays.asList("Poland", "Japan"));
		Map<String, Fruit> map = new HashMap<>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		assertThat(map).extracting("Grape", "Kiwifruit").containsOnly(grape, kiwifruit);
		assertThat(map).extracting("Lemon").extracting("name").isEqualTo("Lemon");
	}

	@Test
	public void extractingByKey() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new LinkedHashMap<String, Fruit>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		assertThat(map).extractingByKey("Grape").extracting(Fruit::getType).isEqualTo(1);
		assertThat(map).extractingByKey("Papaya").isNull();
	}

	@Test
	public void extractingByKeys() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new LinkedHashMap<String, Fruit>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		assertThat(map).extractingByKeys("Grape", "Kiwifruit").containsOnly(grape, kiwifruit);
		assertThat(map).extractingByKeys("Papaya", "Lemon").contains(lemon);
	}

	@Test
	public void extractingFromEntries() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new LinkedHashMap<String, Fruit>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		Function<Map.Entry<String, Fruit>, Object> value = e -> e.getValue();
		assertThat(map).extractingFromEntries(value).containsOnly(grape, kiwifruit, lemon);
		Function<Map.Entry<String, Fruit>, Object> type = e -> e.getValue().getType();
		assertThat(map).extractingFromEntries(type).containsOnly(1, 2, 3);
	}

	@Test
	public void flatExtracting() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1, Arrays.asList("Australia"));
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2, Arrays.asList("Canada", "Norway"));
		Fruit lemon = new Fruit("Lemon", -1, 3, Arrays.asList("Poland", "Japan"));
		Map<String, Fruit> map = new HashMap<>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		assertThat(map).flatExtracting("Grape", "Kiwifruit").containsOnly(grape, kiwifruit);
	}
}
