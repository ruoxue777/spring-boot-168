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

public class AssertJListTest {

	public AssertJListTest() {

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
	public void hasSize() {
		int expectedSize = 3;
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).hasSize(expectedSize);
	}

	@Test
	public void contains() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).contains("Banana", "Apple");
	}

	@Test
	public void doesNotContain() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).doesNotContain("Grape");
	}

	@Test
	public void containsOnly() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).containsOnly("Banana", "Cherry", "Apple");
	}

	@Test
	public void containsExactly() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).containsExactly("Apple", "Banana", "Cherry");
	}

	@Test
	public void containsAnyOf() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).containsAnyOf("Grape", "Banana", "Kiwifruit");
	}

	@Test
	public void containsAtIndex() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).contains("Apple", atIndex(0)).contains("Banana", atIndex(1)).contains("Cherry", atIndex(2));
	}

	@Test
	public void isEqualTo() {
		Fruit apple = new Fruit("Apple", 1, 1);
		Fruit banana = new Fruit("Banana", 2, 1);
		Fruit cherry = new Fruit("Cherry", 3, 1);
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		List<Fruit> list2 = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).isEqualTo(list2);
	}
}
