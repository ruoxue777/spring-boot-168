package org.ruoxue.spring_boot_168.test.assertj.array;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;
import org.ruoxue.spring_boot_168.test.assertj.array.AssertingArraysMethodsTest.Fruit;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertingArraysWithExamplesTest {

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
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 2);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 2);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).allMatch(e -> e.getType() == 2).isNotEmpty();
	}

	@Test
	public void anyMatch() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).anyMatch(e -> e.getName().equals("Durian")).isNotEmpty();
	}

	@Test
	public void noneMatch() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).noneMatch(e -> e.getType() == 0).isNotEmpty();
	}

	@Test
	public void allSatisfy() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 2);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 2);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).allSatisfy(e -> {
			assertThat(e.getType()).isEqualTo(2);
			assertThat(e.getName().length()).isGreaterThan(4);
		});
	}

	@Test
	public void anySatisfy() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).anySatisfy(e -> {
			assertThat(e.getType()).isEqualTo(2);
			assertThat(e.getName()).isEqualTo("Guava");
		});
	}

	@Test
	public void noneSatisfy() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).noneSatisfy(e -> {
			assertThat(e.getType()).isEqualTo(0);
			assertThat(e.getName().length()).isLessThan(5);
		});
	}
}
