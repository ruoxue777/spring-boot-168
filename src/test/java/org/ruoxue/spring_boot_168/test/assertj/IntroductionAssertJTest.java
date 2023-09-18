package org.ruoxue.spring_boot_168.test.assertj;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.assertj.core.api.Condition;
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
	public void stringAssertions() {
		String value = "AssertJ 155";
		System.out.println(value);
		Condition<String> length = new Condition<String>(s -> s.length() > 10, "length");
		assertThat(value).matches(s -> s.length() < 12).is(length);

		String value2 = "AssertJ";
		System.out.println(value2);
		Condition<String> length2 = new Condition<String>(s -> s.length() > 6, "length");
		assertThat(value2).matches(s -> s.length() < 8).is(length2);
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
	public void arayAssertions() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 2);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 2);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).allMatch(e -> e.getName().length() > 4).contains(durian, guava, pitaya);
		assertThat(array).allMatch(e -> e.getType() == 2).hasSize(3);

		int[] intArray = new int[] { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(intArray));
		assertThat(intArray).isNotNull().containsAnyOf(1, 9).containsSequence(3, 4);
	}

	@Test
	public void listAssertions() {
		List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
		System.out.println(list);
		assertThat(list).isNotNull().doesNotContainNull().contains("Banana", "Apple").containsSequence("Banana",
				"Cherry");

		List<Integer> intList = Stream.of(6, 7, 8, 9, 10).collect(Collectors.toList());
		System.out.println(intList);
		Condition<Integer> intValue = new Condition<Integer>(i -> i > 0, "value");
		assertThat(intList).isNotEmpty().are(intValue);
	}

	@Test
	public void mapAssertions() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Grape", 18);
		map.put("Kiwifruit", 19);
		map.put("Lemon", 20);
		System.out.println(map);
		assertThat(map).isNotNull().containsKey("Kiwifruit").containsAnyOf(entry("Lemon", 20));
		
		Map<Integer, Integer> intMap = new HashMap<>();
		intMap.put(1, 18);
		intMap.put(2, 19);
		intMap.put(3, 20);
		System.out.println(intMap);
		assertThat(intMap).isNotEmpty().containsEntry(1, 18);
	}
}
