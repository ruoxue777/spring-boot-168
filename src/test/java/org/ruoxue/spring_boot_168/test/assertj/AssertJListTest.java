package org.ruoxue.spring_boot_168.test.assertj;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

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
		List<String> list = Arrays.asList("beef", "chicken", "pork");
		
		assertThat(list)
		.hasSize(expectedSize);
	}

	@Test
	public void contains() {
		List<String> list = Arrays.asList("beef", "chicken", "pork");
	
		assertThat(list)
		.contains("chicken", "beef");
	}
	
	@Test
	public void doesNotContain() {
		List<String> list = Arrays.asList("beef", "chicken", "pork");
	
		assertThat(list)
		.doesNotContain("duck");
	}	
	
	@Test
	public void containsOnly() {
		List<String> list = Arrays.asList("beef", "chicken", "pork");
		
		assertThat(list)
		.containsOnly("chicken", "pork" ,"beef");
	}
	
	@Test
	public void containsExactly() {
		List<String> list = Arrays.asList("beef", "chicken", "pork");
		
		assertThat(list)
		.containsExactly("beef", "chicken", "pork");
	}	
	
	@Test
	public void containsAnyOf() {
		List<String> list = Arrays.asList("beef", "chicken", "pork");
		
		assertThat(list)
		.containsAnyOf("duck", "chicken", "egg");
	}	
	
	@Test
	public void extracting() {
		Food beef = new Food("beef", 1);
		Food chicken = new Food("chicken", 2);
		Food pork = new Food("pork", 3);
		List<Food> list = Arrays.asList(beef, chicken, pork);
		
		assertThat(list)
		.extracting("name","quantity")
		.containsExactly(
				tuple("beef",1d), 
				tuple("chicken",2d), 
				tuple("pork",3d)
				);
		
		assertThat(list)
		.extracting(e -> e.getName(), e -> e.getQuantity())
		.containsExactly(
				tuple("beef",1d), 
				tuple("chicken",2d), 
				tuple("pork",3d)
				);
	}		
	
	@Test
	public void anyMatch() {
		Food beef = new Food("beef", 1);
		Food chicken = new Food("chicken", 2);
		Food pork = new Food("pork", 3);
		List<Food> list = Arrays.asList(beef, chicken, pork);
		
		assertThat(list)
		.anyMatch(e -> e.getName().equals("beef"))
		.doesNotContainNull();
	}	
	
	@Test
	public void filteredOn() {
		int expectedSize = 1;
		Food beef = new Food("beef", 1);
		Food chicken = new Food("chicken", 2);
		Food pork = new Food("pork", 3);
		List<Food> list = Arrays.asList(beef, chicken, pork);
		
		assertThat(list)
		.filteredOn(e -> e.getName().equals("chicken") && e.getQuantity() == 2)
		.hasSize(expectedSize);
	}	
	
	@Test
	public void isEqualTo() {
		Food beef = new Food("beef", 1);
		Food chicken = new Food("chicken", 2);
		Food pork = new Food("pork", 3);
		List<Food> list = Arrays.asList(beef, chicken, pork);
		List<Food> list2 = Arrays.asList(beef, chicken, pork);
		
		assertThat(list)
		.isEqualTo(list2);
	}	
}
