package org.ruoxue.spring_boot_168.test.assertj.object;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.STRING;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UnitTestAssertJObjectWithExamplesTest {

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
	public void containsAnyOf() {
		Object value = new Fruit("Litchi 101", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).containsAnyOf("Litchi", "Pomelo");
		assertThat(value).extracting("name").asInstanceOf(STRING).containsAnyOf("101", "99");
	}

	@Test
	public void containsIgnoringCase() {
		Object value = new Fruit("Litchi 101", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).containsIgnoringCase("litchi");
		assertThat(value).extracting("name").asInstanceOf(STRING).containsIgnoringCase("CHI");
	}

	@Test
	public void doesNotContainIgnoringCase() {
		Object value = new Fruit("Litchi 101", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).doesNotContainIgnoringCase("pomelo");
		assertThat(value).extracting("name").asInstanceOf(STRING).doesNotContainIgnoringCase("ELO");
	}

	@Test
	public void containsIgnoringWhitespaces() {
		Object value = new Fruit("Litchi 101", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).containsIgnoringWhitespaces("Litchi ");
		assertThat(value).extracting("name").asInstanceOf(STRING).containsIgnoringWhitespaces(" 101");
	}

	@Test
	public void containsIgnoringNewLines() {
		Object value = new Fruit("Litc\nhi 1\n01\n", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).containsIgnoringNewLines("Litchi", "101");
		assertThat(value).extracting("name").asInstanceOf(STRING).containsIgnoringNewLines("chi", "101");
	}

	@Test
	public void containsPattern() {
		Object value = new Fruit("Litchi 101", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).containsPattern("Li.c");
		assertThat(value).extracting("name").asInstanceOf(STRING).containsPattern("1\\d1");
	}

	@Test
	public void doesNotContainPattern() {
		Object value = new Fruit("Litchi 101", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).doesNotContainPattern("Li.x");
		assertThat(value).extracting("name").asInstanceOf(STRING).doesNotContainPattern("1\\d9");
	}

	@Test
	public void containsSequence() {
		Object value = new Fruit("Litchi 101 Pomelo 99", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).containsSequence("Litchi", " ", "101");
		assertThat(value).extracting("name").asInstanceOf(STRING).containsSequence(Arrays.asList("Litchi", " ", "101"));
		assertThat(value).extracting("name").asInstanceOf(STRING).containsSequence("Pomelo", " ", "99");
	}

	@Test
	public void containsSubsequence() {
		Object value = new Fruit("Litchi 101 Pomelo 99", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).containsSubsequence("Litchi", "Pomelo");
		assertThat(value).extracting("name").asInstanceOf(STRING)
				.containsSubsequence(Arrays.asList("Litchi", "Pomelo"));
		assertThat(value).extracting("name").asInstanceOf(STRING).containsSubsequence("101", " ", "99");
	}
}
