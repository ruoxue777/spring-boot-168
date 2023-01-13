package org.ruoxue.spring_boot_168.test.assertj;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

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
	}

	@Test
	public void hasSize() {
		int expectedSize = 3;
		List<String> list = Arrays.asList("beef", "chicken", "pork");

		assertThat(list).hasSize(expectedSize);
	}

	@Test
	public void contains() {
		List<String> list = Arrays.asList("beef", "chicken", "pork");

		assertThat(list).contains("chicken", "beef");
	}

	@Test
	public void doesNotContain() {
		List<String> list = Arrays.asList("beef", "chicken", "pork");

		assertThat(list).doesNotContain("duck");
	}

	@Test
	public void containsOnly() {
		List<String> list = Arrays.asList("beef", "chicken", "pork");

		assertThat(list).containsOnly("chicken", "pork", "beef");
	}

	@Test
	public void containsExactly() {
		List<String> list = Arrays.asList("beef", "chicken", "pork");

		assertThat(list).containsExactly("beef", "chicken", "pork");
	}

	@Test
	public void containsAnyOf() {
		List<String> list = Arrays.asList("beef", "chicken", "pork");

		assertThat(list).containsAnyOf("duck", "chicken", "egg");
	}

	@Test
	public void containsAtIndex() {
		List<String> list = Arrays.asList("beef", "chicken", "pork");

		assertThat(list).contains("beef", atIndex(0)).contains("chicken", atIndex(1)).contains("pork", atIndex(2));
	}

	@Test
	public void extracting() {
		Food beef = new Food("beef", 1, 1);
		Food chicken = new Food("chicken", 2, 1);
		Food pork = new Food("pork", 3, 1);
		List<Food> list = Arrays.asList(beef, chicken, pork);

		assertThat(list).extracting(Food::getName).containsExactly("beef", "chicken", "pork");
	}

	@Test
	public void extractingTuple() {
		Food beef = new Food("beef", 1, 1);
		Food chicken = new Food("chicken", 2, 1);
		Food pork = new Food("pork", 3, 1);
		List<Food> list = Arrays.asList(beef, chicken, pork);

		assertThat(list).extracting("name", "quantity").containsExactly(tuple("beef", 1d), tuple("chicken", 2d),
				tuple("pork", 3d));

		assertThat(list).extracting(e -> e.getName(), Food::getQuantity).containsExactly(tuple("beef", 1d),
				tuple("chicken", 2d), tuple("pork", 3d));
	}

	@Test
	public void anyMatch() {
		Food beef = new Food("beef", 1, 1);
		Food chicken = new Food("chicken", 2, 1);
		Food pork = new Food("pork", 3, 1);
		List<Food> list = Arrays.asList(beef, chicken, pork);

		assertThat(list).allMatch(e -> e.getType() == 1).anyMatch(e -> e.getName().equals("beef"))
				.noneMatch(e -> e.getType() == 0).doesNotContainNull();
	}

	@Test
	public void filteredOn() {
		int expectedSize = 3;
		Food beef = new Food("beef", 1, 1);
		Food chicken = new Food("chicken", 2, 1);
		Food pork = new Food("pork", 3, 1);
		List<Food> list = Arrays.asList(beef, chicken, pork);

		assertThat(list).filteredOn(Food::getType, 1).containsOnly(beef, chicken, pork).hasSize(expectedSize);
	}

	@Test
	public void anySatisfy() {
		Food beef = new Food("beef", 1, 1);
		Food chicken = new Food("chicken", 2, 1);
		Food pork = new Food("pork", 3, 1);
		List<Food> list = Arrays.asList(beef, chicken, pork);

		assertThat(list).allSatisfy(e -> {
			assertThat(e.getType()).isEqualTo(1);
			assertThat(e.getName()).isNotNull();
		});

		assertThat(list).anySatisfy(e -> {
			assertThat(e.getType()).isEqualTo(1);
			assertThat(e.getName()).isEqualTo("chicken");
		});

		assertThat(list).noneSatisfy(e -> assertThat(e.getType()).isEqualTo(0));
	}

	@Test
	public void isEqualTo() {
		Food beef = new Food("beef", 1, 1);
		Food chicken = new Food("chicken", 2, 1);
		Food pork = new Food("pork", 3, 1);
		List<Food> list = Arrays.asList(beef, chicken, pork);
		List<Food> list2 = Arrays.asList(beef, chicken, pork);

		assertThat(list).isEqualTo(list2);
	}
}
