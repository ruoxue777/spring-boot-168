package org.ruoxue.spring_boot_168.test.assertj.object;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.STRING;

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
	// L=76, l=108
	public void isLessThan() {
		Object value = new Fruit("Litchi 101", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).isLessThan("li").isLessThan("mi");
		assertThat(value).extracting("name").asInstanceOf(STRING).isLessThan("lI").isLessThan("Lj");
	}

	@Test
	// L=76, l=108
	public void isLessThanOrEqualTo() {
		Object value = new Fruit("Litchi 101", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).isLessThanOrEqualTo("Litchi 101")
				.isLessThanOrEqualTo("ms");
		assertThat(value).extracting("name").asInstanceOf(STRING).isLessThanOrEqualTo("litchi 101")
				.isLessThanOrEqualTo("Lj");
	}

	@Test
	// L=76, l=108
	public void isGreaterThan() {
		Object value = new Fruit("litchi 101", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).isGreaterThan("As").isGreaterThan("Bs");
		assertThat(value).extracting("name").asInstanceOf(STRING).isGreaterThan("aS").isGreaterThan("aT");
	}

	@Test
	// L=76, l=108
	public void isGreaterThanOrEqualTo() {
		Object value = new Fruit("litchi 101", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).extracting("name").asInstanceOf(STRING).isGreaterThanOrEqualTo("Litchi 101")
				.isGreaterThanOrEqualTo("Mj");
		assertThat(value).extracting("name").asInstanceOf(STRING).isGreaterThanOrEqualTo("litchi 101")
				.isGreaterThanOrEqualTo("lJ");
	}

	@Test
	public void usingDefaultComparator() {
		Object value = new Fruit("Litchi 101", Double.MAX_VALUE, 1);
		System.out.println(value);
		assertThat(value).usingDefaultComparator().extracting("name").asInstanceOf(STRING).contains("Litchi", "101")
				.doesNotContain("chix");
		value = new Fruit("Litchi 101", Double.MAX_VALUE, 1);
		assertThat(value).usingDefaultComparator().extracting("name").asInstanceOf(STRING).startsWith("Lit")
				.endsWith("101");
	}

	@Test
	public void usingComparator() {
		Object value = new Fruit("Litchi 101", Double.MAX_VALUE, 1);
		System.out.println(value);
		Comparator<String> ignoreCase = (s1, s2) -> s1.toLowerCase().compareTo(s2.toLowerCase());
		assertThat(value).extracting("name").asInstanceOf(STRING).usingComparator(ignoreCase).contains("LITCHI", "101")
				.doesNotContain("CHIX");
		value = new Fruit("Litchi", Double.MAX_VALUE, 1);
		assertThat(value).extracting("name").asInstanceOf(STRING).usingComparator(ignoreCase).startsWith("LIT")
				.endsWith("chi");
	}

	@Test
	public void usingComparatorWithDescription() {
		Object value = new Fruit("Litchi 101", Double.MAX_VALUE, 1);
		System.out.println(value);
		Comparator<String> ignoreCase = (s1, s2) -> s1.toLowerCase().compareTo(s2.toLowerCase());
		assertThat(value).extracting("name").asInstanceOf(STRING).usingComparator(ignoreCase, "ignoreCase")
				.contains("LITCHI", "101").doesNotContain("CHIX");
		value = new Fruit("Litchi", Double.MAX_VALUE, 1);
		assertThat(value).extracting("name").asInstanceOf(STRING).usingComparator(ignoreCase, "ignoreCase")
				.startsWith("LIT").endsWith("chi");
	}
}
