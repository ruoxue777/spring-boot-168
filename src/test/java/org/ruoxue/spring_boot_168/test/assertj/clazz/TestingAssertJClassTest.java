package org.ruoxue.spring_boot_168.test.assertj.clazz;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class TestingAssertJClassTest {

	@NoArgsConstructor
	@Getter
	@Setter
	@Builder
	public static class Fruit {
		public String name;
		public double quantity;
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

		private void toFormat() {

		}
	}

	@Test
	public void hasDeclaredFields() {
		Class<?> clazz = String.class;
		System.out.println(clazz);
		assertThat(clazz).hasDeclaredFields("value");

		Class<?> clazz2 = Fruit.class;
		System.out.println(clazz2);
		assertThat(clazz2).hasDeclaredFields("name", "quantity");
	}

	@Test
	public void hasDeclaredMethods() {
		Class<?> clazz = String.class;
		System.out.println(clazz);
		assertThat(clazz).hasDeclaredMethods("concat","nonSyncContentEquals");

		Class<?> clazz2 = Fruit.class;
		System.out.println(clazz2);
		assertThat(clazz2).hasDeclaredMethods("getName", "toFormat");
	}

	@Test
	public void hasPublicFields() {
		Class<?> clazz = String.class;
		System.out.println(clazz);
		assertThat(clazz).hasPublicFields("CASE_INSENSITIVE_ORDER");

		Class<?> clazz2 = Fruit.class;
		System.out.println(clazz2);
		assertThat(clazz2).hasPublicFields("name");
	}

	@Test
	public void hasPublicMethods() {
		Class<?> clazz = String.class;
		System.out.println(clazz);
		assertThat(clazz).hasPublicMethods("concat");

		Class<?> clazz2 = Fruit.class;
		System.out.println(clazz2);
		assertThat(clazz2).hasPublicMethods("getName");
	}

	@Test
	public void hasOnlyDeclaredFields() {
		Class<?> clazz = String.class;
		System.out.println(clazz);
		assertThat(clazz).hasOnlyDeclaredFields("value", "hash", "serialVersionUID", "serialPersistentFields",
				"CASE_INSENSITIVE_ORDER").hasOnlyDeclaredFields("hash", "value", "serialVersionUID",
						"serialPersistentFields", "CASE_INSENSITIVE_ORDER");

		Class<?> clazz2 = Fruit.class;
		System.out.println(clazz2);
		assertThat(clazz2).hasOnlyDeclaredFields("name", "quantity", "type").hasOnlyDeclaredFields("quantity", "name",
				"type");
	}

	@Test
	public void hasOnlyPublicFields() {
		Class<?> clazz = String.class;
		System.out.println(clazz);
		assertThat(clazz).hasOnlyPublicFields("CASE_INSENSITIVE_ORDER");

		Class<?> clazz2 = Fruit.class;
		System.out.println(clazz2);
		assertThat(clazz2).hasOnlyPublicFields("name", "quantity").hasOnlyPublicFields("quantity", "name");
	}
}
