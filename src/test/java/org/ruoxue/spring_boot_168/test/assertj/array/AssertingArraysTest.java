package org.ruoxue.spring_boot_168.test.assertj.array;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertingArraysTest {

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
	public void filteredOn() {
		int expectedSize = 1;
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).filteredOn(Fruit::getName, "Guava").hasSize(expectedSize);
		assertThat(array).filteredOn(Fruit::getType, 2).hasSize(expectedSize);
	}

	@Test
	public void filteredOnWithPredicate() {
		int expectedSize = 2;
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).filteredOn(e -> e.getName().length() > 5).hasSize(expectedSize);
		assertThat(array).filteredOn(e -> e.getQuantity() > 0).hasSize(expectedSize);
	}

	@Test
	public void filteredOnWithFieldName() {
		int expectedSize = 1;
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).filteredOn("name", "Guava").hasSize(expectedSize);
		assertThat(array).filteredOn("type", 2).hasSize(expectedSize);
	}

	@Test
	public void filteredOnWithFilterOperator() {
		int expectedSize = 1;
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).filteredOn("name", in("Guava", "Pitaya")).filteredOn(Fruit::getType, 2).hasSize(expectedSize);
		assertThat(array).filteredOn("type", notIn(1, 2)).filteredOn(e -> e.getQuantity() < 0).hasSize(expectedSize);
	}

	@Test
	public void filteredOnWithCondition() {
		int expectedSize = 2;
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		Condition<Fruit> length = new Condition<Fruit>(o -> o.name.length() > 5, "length");
		assertThat(array).filteredOn(length).hasSize(expectedSize);

		Condition<Fruit> quantity = new Condition<Fruit>(o -> o.quantity > 0, "quantity");
		assertThat(array).filteredOn(quantity).hasSize(expectedSize);
	}

	@Test
	public void filteredOnAssertions() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit(null, 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		assertThat(array).filteredOnAssertions(e -> {
			double result = 1 / 0;
		});
	}

	@Test
	public void filteredOnNull() {
		int expectedSize = 1;
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit(null, 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).filteredOnNull("name").hasSize(expectedSize);
	}
}
