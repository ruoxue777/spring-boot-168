package org.ruoxue.spring_boot_168.test.assertj.map;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertingMapsMethodsTest {

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
	public void extracting() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).extracting(e -> e.getName()).contains("Durian", "Guava");
		assertThat(array).extracting(e -> e.getType()).containsOnly(1, 2, 3);
	}

	@Test
	public void extractingWithFieldName() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).extracting("name").containsAll(Arrays.asList("Durian", "Guava"));
		assertThat(array).extracting("type").containsExactly(1, 2, 3);
	}

	@Test
	public void extractingWithMethodReference() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).extracting(Fruit::getName).containsExactlyInAnyOrder("Pitaya", "Durian", "Guava");
		assertThat(array).extracting(Fruit::getType).containsAnyOf(1, 2);
	}

	@Test
	public void extractingTuple() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).extracting("name", "quantity").containsSequence(tuple("Guava", 1d), tuple("Pitaya", -1d));
		assertThat(array).extracting(e -> e.getName(), Fruit::getQuantity)
				.containsSubsequence(tuple("Durian", Double.MAX_VALUE), tuple("Pitaya", -1d));
	}

	@Test
	public void extractingResultOf() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).extractingResultOf("getName").doesNotContainNull();
		assertThat(array).extractingResultOf("getQuantity", Double.class).hasSize(3);
	}

	@Test
	public void flatExtracting() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1, Arrays.asList("France"));
		Fruit guava = new Fruit("Guava", 1, 2, Arrays.asList("Greece", "Germany"));
		Fruit pitaya = new Fruit("Pitaya", -1, 3, Arrays.asList("India", "Iceland"));
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).flatExtracting("origins").containsOnly("France", "Greece", "Germany", "India", "Iceland");
	}

	@Test
	public void flatExtractingWithMethodReference() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1, Arrays.asList("France"));
		Fruit guava = new Fruit("Guava", 1, 2, Arrays.asList("Greece", "Germany"));
		Fruit pitaya = new Fruit("Pitaya", -1, 3, Arrays.asList("India", "Iceland"));
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).flatExtracting(Fruit::getOrigins).containsOnly("France", "Greece", "Germany", "India",
				"Iceland");
	}
}
