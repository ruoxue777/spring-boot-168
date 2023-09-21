package org.ruoxue.spring_boot_168.test.assertj.object;

import static org.assertj.core.api.Assertions.*;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertJObjectAssertionsTest {

	@NoArgsConstructor
	@Getter
	@Setter
	public static class Fruit {
		private String name;
		private double quantity;
		private int type;

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
			return builder.toString();
		}
	}

	@Test
	public void contains() {
		Object value = new Fruit("Litchi 101", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).contains("Litchi", "101");
		assertThat(value).extracting("name").asInstanceOf(STRING).contains("chi", "1");
	}

	@Test
	public void doesNotContain() {
		Object value = new Fruit("Litchi 101", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).doesNotContain("Pomelo", "99");
		assertThat(value).extracting("name").asInstanceOf(STRING).doesNotContain("elo", "9");
	}

	@Test
	public void containsOnlyOnce() {
		Object value = new Fruit("Litchi 101", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).containsOnlyOnce("chi");
		assertThat(value).extracting("name").asInstanceOf(STRING).containsOnlyOnce("01");
	}

	@Test
	public void containsOnlyWhitespaces() {
		Object value = new Fruit(" ", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).containsOnlyWhitespaces();
		value = new Fruit("   ", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).containsOnlyWhitespaces();
	}

	@Test
	public void doesNotContainOnlyWhitespaces() {
		Object value = new Fruit("Litchi 101", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).doesNotContainOnlyWhitespaces();
		value = new Fruit("Litchi ", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).doesNotContainOnlyWhitespaces();
	}

	@Test
	public void containsOnlyDigits() {
		Object value = new Fruit("101", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).containsOnlyDigits();
		value = new Fruit("1", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).containsOnlyDigits();
	}

	@Test
	public void containsWhitespaces() {
		Object value = new Fruit("Litchi 101", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).containsWhitespaces();
		value = new Fruit(" ", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).containsWhitespaces();
	}

	@Test
	public void doesNotContainAnyWhitespaces() {
		Object value = new Fruit("Litchi101", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).doesNotContainAnyWhitespaces();
		value = new Fruit("Litchi", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).doesNotContainAnyWhitespaces();
	}
}
