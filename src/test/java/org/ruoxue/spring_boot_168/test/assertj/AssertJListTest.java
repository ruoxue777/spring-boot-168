package org.ruoxue.spring_boot_168.test.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.ruoxue.spring_boot_168.test.assertj.AssertJArrayTest.Food;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertJListTest {
	@NoArgsConstructor
	@Getter
	@Setter
	@Builder
	public static class Food {
		private String name;
		private double quantity;

		public Food(String name, double quantity) {
			this.name = name;
			this.quantity = quantity;
		}
	}

	@Test
	public void hasSize() {
		int expectedSize = 3;
		Food beef = new Food("beef", 1);
		Food chicken = new Food("chicken", 2);
		Food pork = new Food("pork", 3);
		List<Food> list = Arrays.asList(beef, chicken, pork);
		
		assertThat(list)
		.hasSize(expectedSize);
	}

	@Test
	public void contains() {
		Food beef = new Food("beef", 1);
		Food chicken = new Food("chicken", 2);
		Food pork = new Food("pork", 3);
		List<Food> list = Arrays.asList(beef, chicken, pork);
		
		assertThat(list)
		.contains(chicken);
	}
	
	@Test
	public void containsOnly() {
		Food beef = new Food("beef", 1);
		Food chicken = new Food("chicken", 2);
		Food pork = new Food("pork", 3);
		List<Food> list = Arrays.asList(beef, chicken, pork);
		
		assertThat(list)
		.containsOnly(chicken, pork ,beef);
	}
	
	@Test
	public void containsExactly() {
		Food beef = new Food("beef", 1);
		Food chicken = new Food("chicken", 2);
		Food pork = new Food("pork", 3);
		List<Food> list = Arrays.asList(beef, chicken, pork);
		
		assertThat(list)
		.containsExactly(beef, chicken, pork);
	}	
}
