package org.ruoxue.spring_boot_168.test.assertj;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;
import org.ruoxue.spring_boot_168.test.assertj.AssertJJava8FeaturesTest.Fruit;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertJIntroductionTest {

	@NoArgsConstructor
	@Getter
	@Setter
	@Builder
	public static class Fruit {
		private String name;
		private double quantity;
		private int type;
		private List<String> origins = new ArrayList<>();

		public Fruit(String name, double quantity, int type, List<String> origins) {
			this.name = name;
			this.quantity = quantity;
			this.type = type;
			this.origins = origins;
		}

		public Fruit(String name, double quantity, int type) {
			this(name, quantity, type, new ArrayList<>());
		}

		public String toString() {
			ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
			builder.appendSuper(super.toString());
			builder.append("name", name);
			builder.append("quantity", quantity);
			builder.append("type", type);
			builder.append("origins", origins);
			return builder.toString();
		}
	}

	@Test
	public void objectAssertions() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1, Arrays.asList("Australia"));
		Fruit cloneApple = new Fruit("Apple", Double.MAX_VALUE, 1, Arrays.asList("Australia"));
		System.out.println(apple);
		System.out.println(cloneApple);

		assertThatCode(() -> {
			assertThat(apple).isEqualTo(cloneApple);
		}).isInstanceOf(AssertionError.class);

		assertThat(apple).usingRecursiveComparison().isEqualTo(cloneApple);
	}

	@Test
	public void booleanAssertions() {
		String value = "";
		System.out.println(value);
		assertThat(value.isEmpty()).isTrue();

		String value2 = "";
		System.out.println(value2);
		assertThat(value2.isEmpty()).isTrue();
	}

	@Test
	public void iterableAssertions() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).isNotEmpty().contains("Banana", "Apple").doesNotContainNull().containsSequence("Banana",
				"Cherry");
	}

	@Test
	public void characterAssertions() {

	}

	@Test
	public void classAssertions() {

	}

	@Test
	public void fileAssertions() {

	}

	@Test
	public void numberAssertions() {

	}

	@Test
	public void inputStreamAssertions() {

	}

	@Test
	public void mapAssertions() {

	}

	@Test
	public void throwableAssertions() {

	}

	@Test
	public void describingAssertions() {

	}

//	@Test
//	public void flatExtracting() {
//		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1, Arrays.asList("Australia"));
//		Fruit banana = new Fruit("Banana", 1, 2, Arrays.asList("Canada", "Norway"));
//		Fruit cherry = new Fruit("Cherry", -1, 3, Arrays.asList("Poland", "Japan"));
//		List<Fruit> list = Arrays.asList(apple, banana, cherry);
//		System.out.println(list);
//		assertThat(list).flatExtracting("origins").containsOnly("Australia", "Canada", "Norway", "Poland", "Japan");
//	}
//
//	@Test
//	public void satisfies() {
//		String value = "AssertJ 155";
//		System.out.println(value);
//		assertThat(value).satisfies(s -> {
//			assertThat(s).isNotEmpty();
//			assertThat(s).hasSize(11);
//		});
//
//		int intValue = 155;
//		System.out.println(intValue);
//		assertThat(intValue).satisfies(i -> {
//			assertThat(i).isNotZero();
//			assertThat(i).isLessThan(156);
//		});
//	}
//
//	@Test
//	public void matches() {
//		String value = "AssertJ 155";
//		System.out.println(value);
//		assertThat(value).matches(s -> s.length() < 12);
//
//		int intValue = 155;
//		System.out.println(intValue);
//		assertThat(intValue).matches(i -> i < 156);
//	}
}
