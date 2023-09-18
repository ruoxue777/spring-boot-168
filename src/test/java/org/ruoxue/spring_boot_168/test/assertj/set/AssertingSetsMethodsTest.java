package org.ruoxue.spring_boot_168.test.assertj.set;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertingSetsMethodsTest {

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
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).extracting(e -> e.getName()).contains("Apple", "Banana");
		assertThat(list).extracting(e -> e.getType()).containsOnly(1, 2, 3);
	}

	@Test
	public void extractingWithFieldName() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).extracting("name").containsAll(Arrays.asList("Apple", "Banana"));
		assertThat(list).extracting("type").containsExactly(1, 2, 3);
	}

	@Test
	public void extractingWithMethodReference() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).extracting(Fruit::getName).containsExactlyInAnyOrder("Cherry", "Apple", "Banana");
		assertThat(list).extracting(Fruit::getType).containsAnyOf(1, 2);
	}

	@Test
	public void extractingTuple() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).extracting("name", "quantity").containsSequence(tuple("Banana", 1d), tuple("Cherry", -1d));
		assertThat(list).extracting(e -> e.getName(), Fruit::getQuantity)
				.containsSubsequence(tuple("Apple", Double.MAX_VALUE), tuple("Cherry", -1d));
	}

	@Test
	public void extractingResultOf() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).extractingResultOf("getName").doesNotContainNull();
		assertThat(list).extractingResultOf("getQuantity", Double.class).hasSize(3);
	}

	@Test
	public void flatExtracting() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1, Arrays.asList("Australia"));
		Fruit banana = new Fruit("Banana", 1, 2, Arrays.asList("Canada", "Norway"));
		Fruit cherry = new Fruit("Cherry", -1, 3, Arrays.asList("Poland", "Japan"));
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).flatExtracting("origins").containsOnly("Australia", "Canada", "Norway", "Poland", "Japan");
	}

	@Test
	public void flatExtractingWithMethodReference() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1, Arrays.asList("Australia"));
		Fruit banana = new Fruit("Banana", 1, 2, Arrays.asList("Canada", "Norway"));
		Fruit cherry = new Fruit("Cherry", -1, 3, Arrays.asList("Poland", "Japan"));
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).flatExtracting(Fruit::getOrigins).containsOnly("Australia", "Canada", "Norway", "Poland",
				"Japan");
	}
}
