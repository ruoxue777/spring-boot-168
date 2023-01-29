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
	public static class Food {
		private String name;
		private double quantity;
		private int type;

		public Food(String name, double quantity, int type) {
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
		List<String> list = Arrays.asList("beef", "chicken", "pork");
		System.out.println(list);
		assertThat(list).hasSize(expectedSize);
	}

	@Test
	public void contains() {
		List<String> list = Arrays.asList("beef", "chicken", "pork");
		System.out.println(list);
		assertThat(list).contains("chicken", "beef");
	}

	@Test
	public void doesNotContain() {
		List<String> list = Arrays.asList("beef", "chicken", "pork");
		System.out.println(list);
		assertThat(list).doesNotContain("duck");
	}

	@Test
	public void containsOnly() {
		List<String> list = Arrays.asList("beef", "chicken", "pork");
		System.out.println(list);
		assertThat(list).containsOnly("chicken", "pork", "beef");
	}

	@Test
	public void containsExactly() {
		List<String> list = Arrays.asList("beef", "chicken", "pork");
		System.out.println(list);
		assertThat(list).containsExactly("beef", "chicken", "pork");
	}

	@Test
	public void containsAnyOf() {
		List<String> list = Arrays.asList("beef", "chicken", "pork");
		System.out.println(list);
		assertThat(list).containsAnyOf("duck", "chicken", "egg");
	}

	@Test
	public void containsAtIndex() {
		List<String> list = Arrays.asList("beef", "chicken", "pork");
		System.out.println(list);
		assertThat(list).contains("beef", atIndex(0)).contains("chicken", atIndex(1)).contains("pork", atIndex(2));
	}

	@Test
	public void isEqualTo() {
		Food beef = new Food("beef", 1, 1);
		Food chicken = new Food("chicken", 2, 1);
		Food pork = new Food("pork", 3, 1);
		List<Food> list = Arrays.asList(beef, chicken, pork);
		List<Food> list2 = Arrays.asList(beef, chicken, pork);
		System.out.println(list);
		assertThat(list).isEqualTo(list2);
	}
}
