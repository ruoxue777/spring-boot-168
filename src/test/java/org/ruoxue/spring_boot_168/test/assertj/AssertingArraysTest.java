package org.ruoxue.spring_boot_168.test.assertj;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertingArraysTest {

	public AssertingArraysTest() {

	}

	@NoArgsConstructor
	@Getter
	@Setter
	@Builder
	public static class Drink {
		private String name;
		private double quantity;
		private int type;

		public Drink(String name, double quantity, int type) {
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
		Drink coffee = new Drink("coffee", 4, 2);
		Drink juice = new Drink("juice", 5, 2);
		Drink tea = new Drink("tea", 6, 2);
		Drink[] array = new Drink[] { coffee, juice, tea };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).extracting(Drink::getName).containsExactly("coffee", "juice", "tea");
	}

	@Test
	public void extractingTuple() {
		Drink coffee = new Drink("coffee", 4, 2);
		Drink juice = new Drink("juice", 5, 2);
		Drink tea = new Drink("tea", 6, 2);
		Drink[] array = new Drink[] { coffee, juice, tea };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).extracting("name", "quantity").containsExactly(tuple("coffee", 4d), tuple("juice", 5d),
				tuple("tea", 6d));
		assertThat(array).extracting(e -> e.getName(), Drink::getQuantity).containsExactly(tuple("coffee", 4d),
				tuple("juice", 5d), tuple("tea", 6d));
	}

	@Test
	public void allMatch() {
		Drink coffee = new Drink("coffee", 4, 2);
		Drink juice = new Drink("juice", 5, 2);
		Drink tea = new Drink("tea", 6, 2);
		Drink[] array = new Drink[] { coffee, juice, tea };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).allMatch(e -> e.getType() == 2).doesNotContainNull();
	}

	@Test
	public void anyMatch() {
		Drink coffee = new Drink("coffee", 4, 2);
		Drink juice = new Drink("juice", 5, 2);
		Drink tea = new Drink("tea", 6, 2);
		Drink[] array = new Drink[] { coffee, juice, tea };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).anyMatch(e -> e.getName().equals("coffee")).doesNotContainNull();
	}

	@Test
	public void noneMatch() {
		Drink coffee = new Drink("coffee", 4, 2);
		Drink juice = new Drink("juice", 5, 2);
		Drink tea = new Drink("tea", 6, 2);
		Drink[] array = new Drink[] { coffee, juice, tea };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).noneMatch(e -> e.getType() == 0).doesNotContainNull();
	}

	@Test
	public void filteredOn() {
		int expectedSize = 3;
		Drink coffee = new Drink("coffee", 4, 2);
		Drink juice = new Drink("juice", 5, 2);
		Drink tea = new Drink("tea", 6, 2);
		Drink[] array = new Drink[] { coffee, juice, tea };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).filteredOn(Drink::getType, 2).containsOnly(coffee, juice, tea).hasSize(expectedSize);
	}

	@Test
	public void allSatisfy() {
		Drink coffee = new Drink("coffee", 4, 2);
		Drink juice = new Drink("juice", 5, 2);
		Drink tea = new Drink("tea", 6, 2);
		Drink[] array = new Drink[] { coffee, juice, tea };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).allSatisfy(e -> {
			assertThat(e.getType()).isEqualTo(2);
			assertThat(e.getName()).isNotNull();
		});
	}

	@Test
	public void anySatisfy() {
		Drink coffee = new Drink("coffee", 4, 2);
		Drink juice = new Drink("juice", 5, 2);
		Drink tea = new Drink("tea", 6, 2);
		Drink[] array = new Drink[] { coffee, juice, tea };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).anySatisfy(e -> {
			assertThat(e.getType()).isEqualTo(2);
			assertThat(e.getName()).isEqualTo("juice");
		});
	}

	@Test
	public void noneSatisfy() {
		Drink coffee = new Drink("coffee", 4, 2);
		Drink juice = new Drink("juice", 5, 2);
		Drink tea = new Drink("tea", 6, 2);
		Drink[] array = new Drink[] { coffee, juice, tea };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).noneSatisfy(e -> assertThat(e.getType()).isEqualTo(0));
	}
}
