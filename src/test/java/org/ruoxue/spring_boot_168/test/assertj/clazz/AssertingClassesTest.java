package org.ruoxue.spring_boot_168.test.assertj.clazz;

import static org.assertj.core.api.Assertions.*;

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
		Class<?> clazz = CharSequence.class;
		System.out.println(clazz);
		assertThat(clazz).matches(c -> c.isInterface());

		Class<?> clazz2 = int.class;
		System.out.println(clazz2);
		assertThat(clazz2).matches(c -> c.isPrimitive());
	}

	@Test
	public void matchesWithDescription() {
		Class<?> clazz = CharSequence.class;
		System.out.println(clazz);
		assertThat(clazz).matches(c -> c.isInterface(), "interface");

		Class<?> clazz2 = int.class;
		System.out.println(clazz2);
		assertThat(clazz2).matches(c -> c.isPrimitive(), "primitive");
	}

	@Test
	public void matchesThrowError() {
		assertThatCode(() -> {
			Class<?> clazz = CharSequence.class;
			System.out.println(clazz);
			assertThat(clazz).matches(c -> c.isPrimitive(), "primitive");
		}).isInstanceOf(AssertionError.class);

		assertThatCode(() -> {
			Class<?> clazz = int.class;
			System.out.println(clazz);
			assertThat(clazz).matches(c -> c.isInterface(), "interface");
		}).isInstanceOf(AssertionError.class);
	}

	@Test
	public void satisfies() {
		Class<?> clazz = CharSequence.class;
		System.out.println(clazz);
		assertThat(clazz).satisfies(c -> {
			assertThat(c).isInterface();
			assertThat(c).isPublic();
		});

		clazz = int.class;
		System.out.println(clazz);
		assertThat(clazz).satisfies(c -> {
			assertThat(c).isAbstract();
		}, c -> {
			assertThat(c).isFinal();
		});
	}

	@Test
	public void satisfiesAnyOf() {
		Class<?> clazz = CharSequence.class;
		System.out.println(clazz);
		assertThat(clazz).satisfiesAnyOf(c -> {
			assertThat(c).isInterface();
			assertThat(c).isPublic();
		});

		clazz = int.class;
		System.out.println(clazz);
		assertThat(clazz).satisfiesAnyOf(c -> {
			assertThat(c).isAbstract();
		}, c -> {
			assertThat(c).isAnnotation();
		});
	}

	@Test
	public void satisfiesThrowError() {
		assertThatCode(() -> {
			Class<?> clazz = CharSequence.class;
			System.out.println(clazz);
			assertThat(clazz).satisfies(c -> {
				assertThat(c).isInterface();
				assertThat(c).isProtected();
			});
		}).isInstanceOf(AssertionError.class);

		assertThatCode(() -> {
			Class<?>clazz = int.class;
			System.out.println(clazz);
			assertThat(clazz).satisfies(c -> {
				assertThat(c).isAbstract();
			}, c -> {
				assertThat(c).isAnnotation();
			});
		}).isInstanceOf(AssertionError.class);
	}
}
