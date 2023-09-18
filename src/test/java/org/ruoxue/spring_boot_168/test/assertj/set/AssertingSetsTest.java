package org.ruoxue.spring_boot_168.test.assertj.set;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertingSetsTest {

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
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).filteredOn(Fruit::getName, "Banana").hasSize(expectedSize);
		assertThat(list).filteredOn(Fruit::getType, 2).hasSize(expectedSize);
	}

	@Test
	public void filteredOnWithPredicate() {
		int expectedSize = 2;
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).filteredOn(e -> e.getName().length() > 5).hasSize(expectedSize);
		assertThat(list).filteredOn(e -> e.getQuantity() > 0).hasSize(expectedSize);
	}

	@Test
	public void filteredOnWithFieldName() {
		int expectedSize = 1;
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).filteredOn("name", "Banana").hasSize(expectedSize);
		assertThat(list).filteredOn("type", 2).hasSize(expectedSize);
	}

	@Test
	public void filteredOnWithFilterOperator() {
		int expectedSize = 1;
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).filteredOn("name", in("Banana", "Cherry")).filteredOn(Fruit::getType, 2).hasSize(expectedSize);
		assertThat(list).filteredOn("type", notIn(1, 2)).filteredOn(e -> e.getQuantity() < 0).hasSize(expectedSize);
	}

	@Test
	public void filteredOnWithCondition() {
		int expectedSize = 2;
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		Condition<Fruit> length = new Condition<Fruit>(o -> o.name.length() > 5, "length");
		assertThat(list).filteredOn(length).hasSize(expectedSize);

		Condition<Fruit> quantity = new Condition<Fruit>(o -> o.quantity > 0, "quantity");
		assertThat(list).filteredOn(quantity).hasSize(expectedSize);
	}

	@Test
	public void filteredOnAssertions() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).filteredOnAssertions(e -> {
			double result = 1 / 0;
		});
	}

	@Test
	public void filteredOnNull() {
		int expectedSize = 1;
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit(null, 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).filteredOnNull("name").hasSize(expectedSize);
	}
}
