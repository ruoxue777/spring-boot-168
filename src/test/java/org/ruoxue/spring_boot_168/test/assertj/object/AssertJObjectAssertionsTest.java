package org.ruoxue.spring_boot_168.test.assertj.object;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
	public void contains() {
		Object value = new Fruit("Litchi", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).matches(null, null);
		assertThat(value).contains("rtJ", "5");
	}

	@Test
	public void doesNotContain() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).doesNotContain("JUnit", "151");
		assertThat(value).doesNotContain("nit", "51");
	}

	@Test
	public void containsOnlyOnce() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).containsOnlyOnce("rtJ");
		assertThat(value).containsOnlyOnce("55");
	}

	@Test
	public void containsOnlyWhitespaces() {
		Object value = " ";
		System.out.println(value);
		assertThat(value).containsOnlyWhitespaces();
		value = "   ";
		System.out.println(value);
		assertThat(value).containsOnlyWhitespaces();
	}

	@Test
	public void doesNotContainOnlyWhitespaces() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).doesNotContainOnlyWhitespaces();
		value = "AssertJ ";
		System.out.println(value);
		assertThat(value).doesNotContainOnlyWhitespaces();
	}

	@Test
	public void containsOnlyDigits() {
		Object value = "155";
		System.out.println(value);
		assertThat(value).containsOnlyDigits();
		value = "5";
		System.out.println(value);
		assertThat(value).containsOnlyDigits();
	}

	@Test
	public void containsWhitespaces() {
		Object value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).containsWhitespaces();
		value = " ";
		System.out.println(value);
		assertThat(value).containsWhitespaces();
	}

	@Test
	public void doesNotContainAnyWhitespaces() {
		Object value = "AssertJ155";
		System.out.println(value);
		assertThat(value).doesNotContainAnyWhitespaces();
		value = "AssertJ";
		System.out.println(value);
		assertThat(value).doesNotContainAnyWhitespaces();
	}
}
