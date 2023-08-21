package org.ruoxue.spring_boot_168.test.assertj.array;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertingArraysMethodsTest {

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
	public void extracting() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		List<Fruit> list = Arrays.asList(durian, guava, pitaya);
		System.out.println(list);
		assertThat(list).extracting(e -> e.getName()).contains("Durian", "Guava", "Pitaya");
		assertThat(list).extracting(e -> e.getType()).containsOnly(1, 2, 3);
	}

	@Test
	public void extractingWithFieldName() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		List<Fruit> list = Arrays.asList(durian, guava, pitaya);
		System.out.println(list);
		assertThat(list).extracting("name").contains("Durian", "Guava", "Pitaya");
		assertThat(list).extracting("type").containsOnly(1, 2, 3);
	}

	@Test
	public void extractingWithThrowingExtractor() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		List<Fruit> list = Arrays.asList(durian, guava, pitaya);
		System.out.println(list);
		assertThat(list).extracting(Fruit::getName).contains("Durian", "Guava", "Pitaya");
		assertThat(list).extracting(Fruit::getType).containsOnly(1, 2, 3);
	}

	@Test
	public void extractingTuple() {
		Fruit durian = new Fruit("Durian", 4, 2);
		Fruit guava = new Fruit("Guava", 5, 2);
		Fruit pitaya = new Fruit("Pitaya", 6, 2);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).extracting("name", "quantity").contains(tuple("Durian", 4d), tuple("Guava", 5d),
				tuple("Pitaya", 6d));
		assertThat(array).extracting(e -> e.getName(), Fruit::getQuantity).contains(tuple("Durian", 4d),
				tuple("Guava", 5d), tuple("Pitaya", 6d));
	}
	
	@Test
	public void extractingResultOf() {
		
	}
}
