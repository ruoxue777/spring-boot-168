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
	public void extracting() {
		Food beef = new Food("beef", 1, 1);
		Food chicken = new Food("chicken", 2, 1);
		Food pork = new Food("pork", 3, 1);
		List<Food> list = Arrays.asList(beef, chicken, pork);
		System.out.println(list);
		assertThat(list).extracting(Food::getName).containsExactly("beef", "chicken", "pork");
	}

	@Test
	public void extractingTuple() {
		Food beef = new Food("beef", 1, 1);
		Food chicken = new Food("chicken", 2, 1);
		Food pork = new Food("pork", 3, 1);
		List<Food> list = Arrays.asList(beef, chicken, pork);
		System.out.println(list);
		assertThat(list).extracting("name", "quantity").containsExactly(tuple("beef", 1d), tuple("chicken", 2d),
				tuple("pork", 3d));

		assertThat(list).extracting(e -> e.getName(), Food::getQuantity).containsExactly(tuple("beef", 1d),
				tuple("chicken", 2d), tuple("pork", 3d));
	}

	@Test
	public void allMatch() {
		Food beef = new Food("beef", 1, 1);
		Food chicken = new Food("chicken", 2, 1);
		Food pork = new Food("pork", 3, 1);
		List<Food> list = Arrays.asList(beef, chicken, pork);
		System.out.println(list);
		assertThat(list).allMatch(e -> e.getType() == 1).doesNotContainNull();
	}

	@Test
	public void anyMatch() {
		Food beef = new Food("beef", 1, 1);
		Food chicken = new Food("chicken", 2, 1);
		Food pork = new Food("pork", 3, 1);
		List<Food> list = Arrays.asList(beef, chicken, pork);
		System.out.println(list);
		assertThat(list).anyMatch(e -> e.getName().equals("beef")).doesNotContainNull();
	}

	@Test
	public void noneMatch() {
		Food beef = new Food("beef", 1, 1);
		Food chicken = new Food("chicken", 2, 1);
		Food pork = new Food("pork", 3, 1);
		List<Food> list = Arrays.asList(beef, chicken, pork);
		System.out.println(list);
		assertThat(list).noneMatch(e -> e.getType() == 0).doesNotContainNull();
	}

	@Test
	public void filteredOn() {
		int expectedSize = 3;
		Food beef = new Food("beef", 1, 1);
		Food chicken = new Food("chicken", 2, 1);
		Food pork = new Food("pork", 3, 1);
		List<Food> list = Arrays.asList(beef, chicken, pork);
		System.out.println(list);
		assertThat(list).filteredOn(Food::getType, 1).containsOnly(beef, chicken, pork).hasSize(expectedSize);
	}

	@Test
	public void allSatisfy() {
		Food beef = new Food("beef", 1, 1);
		Food chicken = new Food("chicken", 2, 1);
		Food pork = new Food("pork", 3, 1);
		List<Food> list = Arrays.asList(beef, chicken, pork);
		System.out.println(list);
		assertThat(list).allSatisfy(e -> {
			assertThat(e.getType()).isEqualTo(1);
			assertThat(e.getName()).isNotNull();
		});
	}

	@Test
	public void anySatisfy() {
		Food beef = new Food("beef", 1, 1);
		Food chicken = new Food("chicken", 2, 1);
		Food pork = new Food("pork", 3, 1);
		List<Food> list = Arrays.asList(beef, chicken, pork);
		System.out.println(list);
		assertThat(list).anySatisfy(e -> {
			assertThat(e.getType()).isEqualTo(1);
			assertThat(e.getName()).isEqualTo("chicken");
		});
	}

	@Test
	public void noneSatisfy() {
		Food beef = new Food("beef", 1, 1);
		Food chicken = new Food("chicken", 2, 1);
		Food pork = new Food("pork", 3, 1);
		List<Food> list = Arrays.asList(beef, chicken, pork);
		System.out.println(list);
		assertThat(list).noneSatisfy(e -> assertThat(e.getType()).isEqualTo(0));
	}
}
