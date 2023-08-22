package org.ruoxue.spring_boot_168.test.assertj.map;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertingMapsWithExamplesTest {

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
	public void allSatisfy() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 2);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 2);
		Map<String, Fruit> map = new HashMap<String, Fruit>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		assertThat(map).allSatisfy((k, v) -> {
			assertThat(v.getType()).isEqualTo(2);
			assertThat(v.getName()).isNotNull();
		});
	}

	@Test
	public void anySatisfy() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new HashMap<String, Fruit>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		assertThat(map).anySatisfy((k, v) -> {
			assertThat(v.getType()).isEqualTo(2);
			assertThat(v.getName()).isEqualTo("Kiwifruit");
		});
	}

	@Test
	public void noneSatisfy() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new HashMap<String, Fruit>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		assertThat(map).noneSatisfy((k, v) -> {
			assertThat(v.getType()).isEqualTo(0);
			assertThat(v.getName().length()).isLessThan(5);
		});
	}

	@Test
	public void hasEntrySatisfying() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new HashMap<String, Fruit>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		Condition<Map.Entry<String, Fruit>> lengthQuantity = new Condition<>(
				e -> e.getKey().length() > 6 && e.getValue().getQuantity() > 0, "length quantity");
		assertThat(map).hasEntrySatisfying(lengthQuantity);
	}

	@Test
	public void hasKeySatisfying() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new HashMap<String, Fruit>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		Condition<String> length = new Condition<String>(s -> s.length() > 6, "length");
		assertThat(map).hasKeySatisfying(length);
	}

	@Test
	public void hasValueSatisfying() {
		Fruit grape = new Fruit("Grape", Double.MAX_VALUE, 1);
		Fruit kiwifruit = new Fruit("Kiwifruit", 1, 2);
		Fruit lemon = new Fruit("Lemon", -1, 3);
		Map<String, Fruit> map = new HashMap<String, Fruit>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		Condition<Fruit> quantity = new Condition<Fruit>(o -> o.quantity > 0, "quantity");
		assertThat(map).hasValueSatisfying(quantity);
	}
}
