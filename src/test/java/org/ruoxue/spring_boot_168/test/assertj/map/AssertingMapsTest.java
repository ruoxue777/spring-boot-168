package org.ruoxue.spring_boot_168.test.assertj.map;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertingMapsTest {

	public AssertingMapsTest() {

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
	public void extractingByKey() {
		Fruit grape = new Fruit("Grape", 18, 3);
		Fruit kiwifruit = new Fruit("Kiwifruit", 19, 3);
		Fruit lemon = new Fruit("Lemon", 20, 3);
		Map<String, Fruit> map = new LinkedHashMap<String, Fruit>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		assertThat(map).allSatisfy((k, v) -> {
			assertThat(v.getType()).isEqualTo(3);
			assertThat(v.getName()).isNotNull();
		});
	}

	@Test
	public void extractingByKeys() {
		Fruit grape = new Fruit("Grape", 18, 3);
		Fruit kiwifruit = new Fruit("Kiwifruit", 19, 3);
		Fruit lemon = new Fruit("Lemon", 20, 3);
		Map<String, Fruit> map = new LinkedHashMap<String, Fruit>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		assertThat(map).anySatisfy((k, v) -> {
			assertThat(v.getType()).isEqualTo(3);
			assertThat(v.getName()).isEqualTo("Grape");
		});
	}

	@Test
	public void extractingFromEntries() {
		Fruit grape = new Fruit("Grape", 18, 3);
		Fruit kiwifruit = new Fruit("Kiwifruit", 19, 3);
		Fruit lemon = new Fruit("Lemon", 20, 3);
		Map<String, Fruit> map = new LinkedHashMap<String, Fruit>();
		map.put(grape.getName(), grape);
		map.put(kiwifruit.getName(), kiwifruit);
		map.put(lemon.getName(), lemon);
		System.out.println(map);
		assertThat(map).noneSatisfy((k, v) -> {
			assertThat(v.getType()).isEqualTo(1);
		});
	}
	
	@Test
	public void usingDefaultComparator() {
		
	}
	
	@Test
	public void usingComparator() {
		
	}
	
	@Test
	public void usingRecursiveComparison() {
		
	}
}
