package org.ruoxue.spring_boot_168.test.assertj.clazz;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertingClassesTest {

	@NoArgsConstructor
	@Getter
	@Setter
	@Builder
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
	public void matches() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).matches(s -> s.length() < 12);

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).matches(s -> s.length() < 8);
	}

	@Test
	public void matchesWithDescription() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).matches(s -> s.length() < 12, "length");

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).matches(s -> s.length() < 8, "length");
	}

	@Test
	public void matchesThrowError() {
		assertThatCode(() -> {
			String value = "AssertJ 155";
			System.out.println(value);
			assertThat(value).matches(s -> s.length() > 12, "length");
		}).isInstanceOf(AssertionError.class);

		assertThatCode(() -> {
			String value = "AssertJ";
			System.out.println(value);
			assertThat(value).matches(s -> s.length() > 8, "length");
		}).isInstanceOf(AssertionError.class);
	}

	@Test
	public void satisfies() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).satisfies(s -> {
			assertThat(s).isNotNull();
			assertThat(s).hasSize(11);
		});

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).satisfies(s -> {
			assertThat(s).isNotEmpty();
		}, s -> {
			assertThat(s).hasSize(7);
		});
	}

	@Test
	public void satisfiesAnyOf() {
		String value = "AssertJ 155";
		System.out.println(value);
		assertThat(value).satisfiesAnyOf(s -> {
			assertThat(s).isNotNull();
			assertThat(s).hasSize(11);
		});

		value = "AssertJ";
		System.out.println(value);
		assertThat(value).satisfiesAnyOf(s -> {
			assertThat(s).isNotEmpty();
		}, s -> {
			assertThat(s).hasSize(99);
		});
	}

	@Test
	public void satisfiesThrowError() {
		assertThatCode(() -> {
			String value = "AssertJ 155";
			System.out.println(value);
			assertThat(value).satisfies(s -> {
				assertThat(s).isNotNull();
				assertThat(s).hasSize(12);
			});
		}).isInstanceOf(AssertionError.class);

		assertThatCode(() -> {
			String value = "AssertJ";
			System.out.println(value);
			assertThat(value).satisfies(s -> {
				assertThat(s).isNotEmpty();
			}, s -> {
				assertThat(s).hasSize(8);
			});
		}).isInstanceOf(AssertionError.class);
	}}
