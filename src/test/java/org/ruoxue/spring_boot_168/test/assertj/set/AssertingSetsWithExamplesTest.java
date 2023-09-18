package org.ruoxue.spring_boot_168.test.assertj.set;

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

public class AssertingSetsWithExamplesTest {

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
	public void allMatch() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 2);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 2);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).allMatch(e -> e.getName().length() > 4).contains(apple, banana, cherry);
		assertThat(list).allMatch(e -> e.getType() == 2).hasSize(3);
	}

	@Test
	public void anyMatch() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).anyMatch(e -> e.getName().equals("Apple")).contains(apple);
		assertThat(list).anyMatch(e -> e.getType() > 2).hasSize(3);
	}

	@Test
	public void noneMatch() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).noneMatch(e -> e.getName().length() > 7).contains(apple, banana, cherry);
		assertThat(list).noneMatch(e -> e.getType() == 0).hasSize(3);
	}

	@Test
	public void allSatisfy() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 2);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 2);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).allSatisfy(e -> {
			assertThat(e.getType()).isEqualTo(2);
			assertThat(e.getName().length()).isGreaterThan(4);
		});
	}

	@Test
	public void anySatisfy() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).anySatisfy(e -> {
			assertThat(e.getType()).isEqualTo(2);
			assertThat(e.getName()).isEqualTo("Banana");
		});
	}

	@Test
	public void noneSatisfy() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).noneSatisfy(e -> {
			assertThat(e.getType()).isEqualTo(0);
			assertThat(e.getName().length()).isLessThan(5);
		});
	}
}
