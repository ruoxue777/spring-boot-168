package org.ruoxue.spring_boot_168.test.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertJJava8FeaturesTest {

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
	public void isPresent() {
		Optional<String> value = Optional.of("AssertJ");
		System.out.println(value);
		assertThat(value).isPresent();

		Optional<Integer> intValue = Optional.of(155);
		System.out.println(intValue);
		assertThat(intValue).isPresent();
	}

	@Test
	public void accepts() {
		Predicate<String> lengthGreaterThan = s -> s.length() > 3;
		System.out.println(lengthGreaterThan);
		assertThat(lengthGreaterThan).accepts("AssertJ", "JUnit");

		Predicate<Integer> greaterThan = i -> i > 10;
		System.out.println(greaterThan);
		assertThat(greaterThan).accepts(155, 151);
	}

	@Test
	public void isBefore() {
		LocalDateTime value = LocalDateTime.of(2023, 10, 31, 5, 6, 7);
		System.out.println(value);
		assertThat(value).isBefore(LocalDateTime.of(2023, 10, 31, 5, 6, 12));
		assertThat(value).isBefore(LocalDateTime.of(2023, 10, 31, 5, 7, 7));
	}

	@Test
	public void flatExtracting() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1, Arrays.asList("Australia"));
		Fruit banana = new Fruit("Banana", 1, 2, Arrays.asList("Canada", "Norway"));
		Fruit cherry = new Fruit("Cherry", -1, 3, Arrays.asList("Poland", "Japan"));
		List<Fruit> list = Arrays.asList(apple, banana, cherry);
		System.out.println(list);
		assertThat(list).flatExtracting("origins").containsOnly("Australia", "Canada", "Norway", "Poland", "Japan");
	}

	@Test
	public void satisfies() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).satisfies(s -> {
			assertThat(s).isNotEmpty();
			assertThat(s).hasSize(11);
		});

		int intValue = 155;
		System.out.println(intValue);
		assertThat(intValue).satisfies(i -> {
			assertThat(i).isNotZero();
			assertThat(i).isLessThan(156);
		});
	}

	@Test
	public void matches() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).matches(s -> s.length() < 12);

		int intValue = 155;
		System.out.println(intValue);
		assertThat(intValue).matches(i -> i < 156);
	}
}
