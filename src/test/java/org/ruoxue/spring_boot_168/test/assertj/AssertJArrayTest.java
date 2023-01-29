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
	public void hasSize() {
		int expectedSize = 3;
		String[] array = new String[] { "coffee", "juice", "tea" };
		System.out.println(Arrays.toString(array));
		assertThat(array).hasSize(expectedSize);
	}

	@Test
	public void contains() {
		String[] array = new String[] { "coffee", "juice", "tea" };
		System.out.println(Arrays.toString(array));
		assertThat(array).contains("juice", "coffee");
	}

	@Test
	public void doesNotContain() {
		String[] array = new String[] { "coffee", "juice", "tea" };
		System.out.println(Arrays.toString(array));
		assertThat(array).doesNotContain("duck");
	}

	@Test
	public void containsOnly() {
		String[] array = new String[] { "coffee", "juice", "tea" };
		System.out.println(Arrays.toString(array));
		assertThat(array).containsOnly("juice", "tea", "coffee");
	}

	@Test
	public void containsExactly() {
		String[] array = new String[] { "coffee", "juice", "tea" };
		System.out.println(Arrays.toString(array));
		assertThat(array).containsExactly("coffee", "juice", "tea");
	}

	@Test
	public void containsAnyOf() {
		String[] array = new String[] { "coffee", "juice", "tea" };
		System.out.println(Arrays.toString(array));
		assertThat(array).containsAnyOf("duck", "juice", "egg");
	}

	@Test
	public void containsAtIndex() {
		String[] array = new String[] { "coffee", "juice", "tea" };
		System.out.println(Arrays.toString(array));
		assertThat(array).contains("coffee", atIndex(0)).contains("juice", atIndex(1)).contains("tea", atIndex(2));
	}

	@Test
	public void isEqualTo() {
		Drink coffee = new Drink("coffee", 4, 2);
		Drink juice = new Drink("juice", 5, 2);
		Drink tea = new Drink("tea", 6, 2);
		Drink[] array = new Drink[] { coffee, juice, tea };
		Drink[] array2 = new Drink[] { coffee, juice, tea };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).isEqualTo(array2);
	}
}
