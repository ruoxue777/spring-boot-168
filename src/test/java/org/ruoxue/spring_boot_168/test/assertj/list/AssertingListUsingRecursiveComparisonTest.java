package org.ruoxue.spring_boot_168.test.assertj.list;

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

public class AssertingListUsingRecursiveComparisonTest {

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
	public void usingRecursiveComparison() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);

		Fruit apple2 = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana2 = new Fruit("Banana", 1, 2);
		Fruit cherry2 = new Fruit("Cherry", -1, 3);
		List<Fruit> list2 = Arrays.asList(apple2, banana2, cherry2);
		System.out.println(list2);

		assertThatCode(() -> {
			assertThat(list).isEqualTo(list2);
		}).isInstanceOf(AssertionError.class);

		assertThat(list).usingRecursiveComparison().isEqualTo(list2);
	}
}
