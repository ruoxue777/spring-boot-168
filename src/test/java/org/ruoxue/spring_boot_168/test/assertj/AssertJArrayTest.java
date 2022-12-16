package org.ruoxue.spring_boot_168.test.assertj;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertJArrayTest {

	@NoArgsConstructor
	@Getter
	@Setter
	@Builder
	public static class Drink {
		private String name;
		private double quantity;

		public Drink(String name, double quantity) {
			this.name = name;
			this.quantity = quantity;
		}
	}

	@Test
	public void hasSize() {
		int expectedSize = 3;
		String[] array = new String[] { "coffee", "juice", "tea" };

		assertThat(array).hasSize(expectedSize);
	}

	@Test
	public void contains() {
		String[] array = new String[] { "coffee", "juice", "tea" };

		assertThat(array).contains("juice", "coffee");
	}

	@Test
	public void doesNotContain() {
		String[] array = new String[] { "coffee", "juice", "tea" };

		assertThat(array).doesNotContain("duck");
	}

	@Test
	public void containsOnly() {
		String[] array = new String[] { "coffee", "juice", "tea" };

		assertThat(array).containsOnly("juice", "tea", "coffee");
	}

	@Test
	public void containsExactly() {
		String[] array = new String[] { "coffee", "juice", "tea" };

		assertThat(array).containsExactly("coffee", "juice", "tea");
	}

	@Test
	public void containsAnyOf() {
		String[] array = new String[] { "coffee", "juice", "tea" };

		assertThat(array).containsAnyOf("duck", "juice", "egg");
	}

	@Test
	public void extracting() {
		Drink coffee = new Drink("coffee", 4);
		Drink juice = new Drink("juice", 5);
		Drink tea = new Drink("tea", 6);
		Drink[] array = new Drink[] { coffee, juice, tea };

		assertThat(array).extracting("name", "quantity")
		.containsExactly(
				tuple("coffee", 4d), 
				tuple("juice", 5d),
				tuple("tea", 6d));

		assertThat(array)
		.extracting(e -> e.getName(), e -> e.getQuantity())
		.containsExactly(
				tuple("coffee", 4d),
				tuple("juice", 5d), 
				tuple("tea", 6d));
	}

	@Test
	public void anyMatch() {
		Drink coffee = new Drink("coffee", 4);
		Drink juice = new Drink("juice", 5);
		Drink tea = new Drink("tea", 6);
		Drink[] array = new Drink[] { coffee, juice, tea };

		assertThat(array)
		.anyMatch(e -> e.getName().equals("coffee"))
		.doesNotContainNull();
	}

	@Test
	public void filteredOn() {
		int expectedSize = 1;
		Drink coffee = new Drink("coffee", 4);
		Drink juice = new Drink("juice", 5);
		Drink tea = new Drink("tea", 6);
		Drink[] array = new Drink[] { coffee, juice, tea };

		assertThat(array)
		.filteredOn(e -> e.getName().equals("juice") && e.getQuantity() == 5)
		.hasSize(expectedSize);
	}
	
	@Test
	public void isEqualTo() {
		Drink coffee = new Drink("coffee", 4);
		Drink juice = new Drink("juice", 5);
		Drink tea = new Drink("tea", 6);
		Drink[] array = new Drink[] { coffee, juice, tea };
		Drink[] array2 = new Drink[] { coffee, juice, tea };

		assertThat(array)
		.isEqualTo(array2);
	}	
}
