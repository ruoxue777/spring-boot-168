package org.ruoxue.spring_boot_168.test.assertj;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class IntroductionAssertJTest {

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
	public void booleanAssertions() {
		String value = "AssertJ";
		System.out.println(value);
		assertThat(value.startsWith("A")).isTrue();

		String value2 = "";
		System.out.println(value2);
		assertThat(value2.isEmpty()).isTrue();
	}

	@Test
	public void characterAssertions() {
		char value = 'A';
		System.out.println(value);
		assertThat(value).isNotEqualTo('a').inUnicode().isLessThanOrEqualTo('b').isUpperCase();

		char value2 = '1';
		System.out.println(value2);
		assertThat(value2).isEqualTo('1').isIn('1', '5').isGreaterThan('/');
	}

	@Test
	public void numberAssertions() {
		int value = 155;
		System.out.println(value);
		assertThat(value).isPositive().isGreaterThan(150).isCloseTo(150, within(5));

		double doubleValue = 151.2d;
		System.out.println(doubleValue);
		assertThat(doubleValue).isNotZero().isLessThan(152d);
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
	public void iterableAssertions() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).isNotEmpty().contains("Banana", "Apple").doesNotContainNull().containsSequence("Banana",
				"Cherry");
	}

	@Test
	public void mapAssertions() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).isNotNull().containsKey("Kiwifruit").doesNotContainEntry("Apple", 19);
	}
}
