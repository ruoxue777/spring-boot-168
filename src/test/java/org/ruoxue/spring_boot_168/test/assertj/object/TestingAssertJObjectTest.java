package org.ruoxue.spring_boot_168.test.assertj.object;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class TestingAssertJObjectTest {

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

	@Test
	public void isLessThan() {
		Object value = new Fruit("Pomelo", 1, 2);
		System.out.println(value);
		assertThat(value).extracting("type").asInstanceOf(INTEGER).isLessThan(3);
		assertThat(value).extracting("quantity").asInstanceOf(DOUBLE).isLessThan(2d);
	}

	@Test
	public void isLessThanOrEqualTo() {
		Object value = new Fruit("Pomelo", 1, 2);
		System.out.println(value);
		assertThat(value).extracting("type").asInstanceOf(INTEGER).isLessThanOrEqualTo(2).isLessThanOrEqualTo(3);
		assertThat(value).extracting("quantity").asInstanceOf(DOUBLE).isLessThanOrEqualTo(1d).isLessThanOrEqualTo(2d);
	}

	@Test
	public void isGreaterThan() {
		Object value = new Fruit("Pomelo", 1, 2);
		System.out.println(value);
		assertThat(value).extracting("type").asInstanceOf(INTEGER).isGreaterThan(1);
		assertThat(value).extracting("quantity").asInstanceOf(DOUBLE).isGreaterThan(0d);
	}

	@Test
	public void isGreaterThanOrEqualTo() {
		Object value = new Fruit("Pomelo", 1, 2);
		System.out.println(value);
		assertThat(value).extracting("type").asInstanceOf(INTEGER).isGreaterThanOrEqualTo(2).isGreaterThanOrEqualTo(1);
		assertThat(value).extracting("quantity").asInstanceOf(DOUBLE).isGreaterThanOrEqualTo(1d)
				.isGreaterThanOrEqualTo(0d);
	}

	@Test
	public void usingDefaultComparator() {
		Object value = new Fruit("Pomelo", 1, 2);
		System.out.println(value);
		assertThat(value).extracting("type").asInstanceOf(INTEGER).isPositive().isCloseTo(-3, within(5)).isCloseTo(7,
				within(5));
		assertThat(value).extracting("quantity").asInstanceOf(DOUBLE).isPositive().isCloseTo(-4d, within(5d))
				.isCloseTo(-4d, within(6d));
	}

	@Test
	public void usingComparator() {
		Object value = new Fruit("Pomelo", 1, 2);
		System.out.println(value);
		Comparator<Integer> abs = (i1, i2) -> Integer.compare(i1, Math.abs(i2));
		assertThat(value).extracting("type").asInstanceOf(INTEGER).usingComparator(abs).isEqualTo(-2);

		Comparator<Double> doubleAbs = (d1, d2) -> Double.compare(d1, Math.abs(d2));
		assertThat(value).extracting("quantity").asInstanceOf(DOUBLE).usingComparator(doubleAbs).isEqualTo(-1d);
	}

	@Test
	public void usingComparatorWithDescription() {
		Object value = new Fruit("Pomelo", 1, 2);
		System.out.println(value);
		Comparator<Integer> abs = (i1, i2) -> Integer.compare(i1, Math.abs(i2));
		assertThat(value).extracting("type").asInstanceOf(INTEGER).usingComparator(abs, "abs").isEqualTo(-2);

		Comparator<Double> doubleAbs = (d1, d2) -> Double.compare(d1, Math.abs(d2));
		assertThat(value).extracting("quantity").asInstanceOf(DOUBLE).usingComparator(doubleAbs, "doubleAbs")
				.isEqualTo(-1d);
	}
}
