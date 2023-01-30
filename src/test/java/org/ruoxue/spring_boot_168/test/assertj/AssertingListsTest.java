package org.ruoxue.spring_boot_168.test.assertj;

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

public class AssertingListsTest {

	public AssertingListsTest() {

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
	public void extracting() {
		Fruit apple = new Fruit("Apple", 1, 1);
		Fruit banana = new Fruit("Banana", 2, 1);
		Fruit cherry = new Fruit("Cherry", 3, 1);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).extracting(Fruit::getName).containsExactly("Apple", "Banana", "Cherry");
	}

	@Test
	public void extractingTuple() {
		Fruit apple = new Fruit("Apple", 1, 1);
		Fruit banana = new Fruit("Banana", 2, 1);
		Fruit cherry = new Fruit("Cherry", 3, 1);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).extracting("name", "quantity").containsExactly(tuple("Apple", 1d), tuple("Banana", 2d),
				tuple("Cherry", 3d));

		assertThat(list).extracting(e -> e.getName(), Fruit::getQuantity).containsExactly(tuple("Apple", 1d),
				tuple("Banana", 2d), tuple("Cherry", 3d));
	}

	@Test
	public void allMatch() {
		Fruit apple = new Fruit("Apple", 1, 1);
		Fruit banana = new Fruit("Banana", 2, 1);
		Fruit cherry = new Fruit("Cherry", 3, 1);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).allMatch(e -> e.getType() == 1).doesNotContainNull();
	}

	@Test
	public void anyMatch() {
		Fruit apple = new Fruit("Apple", 1, 1);
		Fruit banana = new Fruit("Banana", 2, 1);
		Fruit cherry = new Fruit("Cherry", 3, 1);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).anyMatch(e -> e.getName().equals("Apple")).doesNotContainNull();
	}

	@Test
	public void noneMatch() {
		Fruit apple = new Fruit("Apple", 1, 1);
		Fruit banana = new Fruit("Banana", 2, 1);
		Fruit cherry = new Fruit("Cherry", 3, 1);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).noneMatch(e -> e.getType() == 0).doesNotContainNull();
	}

	@Test
	public void filteredOn() {
		int expectedSize = 3;
		Fruit apple = new Fruit("Apple", 1, 1);
		Fruit banana = new Fruit("Banana", 2, 1);
		Fruit cherry = new Fruit("Cherry", 3, 1);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).filteredOn(Fruit::getType, 1).containsOnly(apple, banana, cherry).hasSize(expectedSize);
	}

	@Test
	public void allSatisfy() {
		Fruit apple = new Fruit("Apple", 1, 1);
		Fruit banana = new Fruit("Banana", 2, 1);
		Fruit cherry = new Fruit("Cherry", 3, 1);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).allSatisfy(e -> {
			assertThat(e.getType()).isEqualTo(1);
			assertThat(e.getName()).isNotNull();
		});
	}

	@Test
	public void anySatisfy() {
		Fruit apple = new Fruit("Apple", 1, 1);
		Fruit banana = new Fruit("Banana", 2, 1);
		Fruit cherry = new Fruit("Cherry", 3, 1);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).anySatisfy(e -> {
			assertThat(e.getType()).isEqualTo(1);
			assertThat(e.getName()).isEqualTo("Banana");
		});
	}

	@Test
	public void noneSatisfy() {
		Fruit apple = new Fruit("Apple", 1, 1);
		Fruit banana = new Fruit("Banana", 2, 1);
		Fruit cherry = new Fruit("Cherry", 3, 1);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).noneSatisfy(e -> assertThat(e.getType()).isEqualTo(0));
	}
}
