package org.ruoxue.spring_boot_168.test.assertj.clazz;

import static org.assertj.core.api.Assertions.*;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UnitTestAssertJClassWithExamplesTest {

	@NoArgsConstructor
	@Getter
	@Setter
	static class SuperFruit {
		private String id;

		public String toString() {
			ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
			builder.appendSuper(super.toString());
			builder.append("id", id);
			return builder.toString();
		}
	}

	@NoArgsConstructor
	@Getter
	@Setter
	protected class Fruit extends SuperFruit {
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
	public void isAssignableFrom() {
		Class<?> clazz = CharSequence.class;
		System.out.println(clazz);
		assertThat(clazz).isAssignableFrom(String.class);

		Class<?> clazz2 = Number.class;
		System.out.println(clazz2);
		assertThat(clazz2).isAssignableFrom(Integer.class);
	}

	@Test
	public void isPackagePrivate() {
		Class<?> clazz = SuperFruit.class;
		System.out.println(clazz);
		assertThat(clazz).isPackagePrivate();
	}

	@Test
	public void isProtected() {
		Class<?> clazz = Fruit.class;
		System.out.println(clazz);
		assertThat(clazz).isProtected();
	}

	@Test
	public void isPublic() {
		Class<?> clazz = String.class;
		System.out.println(clazz);
		assertThat(clazz).isPublic();

		Class<?> clazz2 = Integer.class;
		System.out.println(clazz2);
		assertThat(clazz2).isPublic();
	}

	@Test
	public void isStatic() {
		Class<?> clazz = SuperFruit.class;
		System.out.println(clazz);
		assertThat(clazz).isStatic();
	}

	@Test
	public void isNotStatic() {
		Class<?> clazz = Fruit.class;
		System.out.println(clazz);
		assertThat(clazz).isNotStatic();
	}
}
