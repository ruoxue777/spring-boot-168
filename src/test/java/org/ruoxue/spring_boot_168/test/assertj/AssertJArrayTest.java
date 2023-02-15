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

public class AssertJArrayTest {

	public AssertJArrayTest() {

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
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).hasSize(expectedSize);
	}

	@Test
	public void contains() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).contains("Guava", "Durian");
	}

	@Test
	public void doesNotContain() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).doesNotContain("Mango");
	}

	@Test
	public void containsOnly() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).containsOnly("Guava", "Pitaya", "Durian");
	}

	@Test
	public void containsExactly() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).containsExactly("Durian", "Guava", "Pitaya");
	}

	@Test
	public void containsAnyOf() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).containsAnyOf("Durian", "Guava", "Mango");
	}

	@Test
	public void containsAtIndex() {
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		System.out.println(Arrays.toString(array));
		assertThat(array).contains("Durian", atIndex(0)).contains("Guava", atIndex(1)).contains("Pitaya", atIndex(2));
	}

	@Test
	public void isEqualTo() {
		Fruit durian = new Fruit("Durian", 4, 2);
		Fruit guava = new Fruit("Guava", 5, 2);
		Fruit pitaya = new Fruit("Pitaya", 6, 2);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		Fruit[] array2 = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).isEqualTo(array2);
	}
}
