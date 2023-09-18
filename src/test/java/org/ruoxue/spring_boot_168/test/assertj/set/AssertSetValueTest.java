package org.ruoxue.spring_boot_168.test.assertj.set;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertSetValueTest {

	@NoArgsConstructor
	@Getter
	@Setter
	public static class Fruit {
		private String name;
		private double quantity;
		private int type;
		private List<String> origins = new ArrayList<>();

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
			builder.append("origins", origins);
			return builder.toString();
		}
	}

	@Getter
	@Setter
	public static class SimpleFruit {
		private String name;
		private List<String> origins;

		public SimpleFruit() {
		}

		public String toString() {
			ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
			builder.appendSuper(super.toString());
			builder.append("name", name);
			builder.append("origins", origins);
			return builder.toString();
		}
	}

	@Test
	public void matches() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).matches(l -> l.size() > 2);
	}

	@Test
	public void satisfies() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).satisfies(l -> {
			assertThat(l.get(0).getName().equals("Apple"));
			assertThat(l.get(1)).isNotNull();
		});
	}

	@Test
	public void satisfiesAnyOf() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).satisfiesAnyOf(l -> {
			assertThat(l.get(0).getName().equals("Apple"));
		}, l -> {
			assertThat(l.get(1)).isNull();
		});
	}

	@Test
	public void hasAllNullFieldsOrProperties() {
		SimpleFruit apple = new SimpleFruit();
		SimpleFruit banana = new SimpleFruit();
		SimpleFruit cherry = new SimpleFruit();
		List<SimpleFruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).allSatisfy(e -> {
			assertThat(e).hasAllNullFieldsOrProperties();
		});
	}

	@Test
	public void hasAllNullFieldsOrPropertiesExcept() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		apple.setOrigins(null);
		Fruit banana = new Fruit("Banana", 1, 2);
		banana.setOrigins(null);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		cherry.setOrigins(null);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).allSatisfy(e -> {
			assertThat(e).hasAllNullFieldsOrPropertiesExcept("name", "type", "quantity");
		});
	}

	@Test
	public void hasNoNullFieldsOrProperties() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		Fruit banana = new Fruit("Banana", 1, 2);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).allSatisfy(e -> {
			assertThat(e).hasNoNullFieldsOrProperties();
		});
	}

	@Test
	public void hasNoNullFieldsOrPropertiesExcept() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1);
		apple.setOrigins(null);
		Fruit banana = new Fruit("Banana", 1, 2);
		banana.setOrigins(null);
		Fruit cherry = new Fruit("Cherry", -1, 3);
		cherry.setOrigins(null);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).allSatisfy(e -> {
			assertThat(e).hasNoNullFieldsOrPropertiesExcept("origins");
		});
	}
}
