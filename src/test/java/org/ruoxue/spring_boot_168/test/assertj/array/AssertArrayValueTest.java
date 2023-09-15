package org.ruoxue.spring_boot_168.test.assertj.array;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertArrayValueTest {

	@NoArgsConstructor
	@Getter
	@Setter
	public static class Fruit {
		private String name;
		private double quantity;
		private int type;
		private List<String> origins = new ArrayList<>();

		public Fruit(String name, double quantity, int type) {
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
			builder.append("origins", origins);
			return builder.toString();
		}
	}

	@Getter
	@Setter
	public static class SimpleFruit {
		private String name;
		private List<String> origins;

		public SimpleFruit() {
		}

		public String toString() {
			ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
			builder.appendSuper(super.toString());
			builder.append("name", name);
			builder.append("origins", origins);
			return builder.toString();
		}
	}

	@Test
	public void matches() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).matches(a -> a.length > 2);
	}

	@Test
	public void satisfies() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).satisfies(a -> {
			assertThat(a[0].getName().equals("Durian"));
			assertThat(a[1]).isNotNull();
		});
	}

	@Test
	public void satisfiesAnyOf() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).satisfiesAnyOf(a -> {
			assertThat(a[0].getName().equals("Durian"));
		}, a -> {
			assertThat(a[1]).isNull();
		});
	}

	@Test
	public void hasAllNullFieldsOrProperties() {
		SimpleFruit durian = new SimpleFruit();
		SimpleFruit guava = new SimpleFruit();
		SimpleFruit pitaya = new SimpleFruit();
		SimpleFruit[] array = new SimpleFruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).allSatisfy(e -> {
			assertThat(e).hasAllNullFieldsOrProperties();
		});
	}

	@Test
	public void hasAllNullFieldsOrPropertiesExcept() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		durian.setOrigins(null);
		Fruit guava = new Fruit("Guava", 1, 2);
		guava.setOrigins(null);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		pitaya.setOrigins(null);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).allSatisfy(e -> {
			assertThat(e).hasAllNullFieldsOrPropertiesExcept("name", "type", "quantity");
		});
	}

	@Test
	public void hasNoNullFieldsOrProperties() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		Fruit guava = new Fruit("Guava", 1, 2);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).allSatisfy(e -> {
			assertThat(e).hasNoNullFieldsOrProperties();
		});
	}

	@Test
	public void hasNoNullFieldsOrPropertiesExcept() {
		Fruit durian = new Fruit("Durian", Double.MAX_VALUE, 1);
		durian.setOrigins(null);
		Fruit guava = new Fruit("Guava", 1, 2);
		guava.setOrigins(null);
		Fruit pitaya = new Fruit("Pitaya", -1, 3);
		pitaya.setOrigins(null);
		Fruit[] array = new Fruit[] { durian, guava, pitaya };
		System.out.println(Arrays.deepToString(array));
		assertThat(array).allSatisfy(e -> {
			assertThat(e).hasNoNullFieldsOrPropertiesExcept("origins");
		});
	}
}
