package org.ruoxue.spring_boot_168.test.assertj;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class GettingStartedAssertJTest {

	@NoArgsConstructor
	@Getter
	@Setter
	@Builder
	public static class Fruit {
		private String name;
		private double quantity;
		private int type;
		private List<String> origins = new ArrayList<>();

		public Fruit(String name, double quantity, int type, List<String> origins) {
			this.name = name;
			this.quantity = quantity;
			this.type = type;
			this.origins = origins;
		}

		public Fruit(String name, double quantity, int type) {
			this(name, quantity, type, new ArrayList<>());
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
	public void objectAssertions() {
		Fruit apple = new Fruit("Apple", Double.MAX_VALUE, 1, Arrays.asList("Australia"));
		Fruit apple2 = new Fruit("Apple", Double.MAX_VALUE, 1, Arrays.asList("Australia"));
		System.out.println(apple);
		System.out.println(apple2);

		assertThatCode(() -> {
			assertThat(apple).isEqualTo(apple2);
		}).isInstanceOf(AssertionError.class);

		assertThat(apple).usingRecursiveComparison().isEqualTo(apple2);
	}

	@Test
	public void classAssertions() {

	}

	@Test
	public void fileAssertions() {

	}

	@Test
	public void inputStreamAssertions() {

	}

	@Test
	public void throwableAssertions() {

	}

	@Test
	public void describingAssertions() {
		Fruit banana = new Fruit("Banana", 1, 3);
		try {
			assertThat(banana.getType()).as("%s's type should be equal to 2", banana.getName()).isEqualTo(2);
		} catch (AssertionError e) {
			e.printStackTrace();
			assertThat(e).hasMessageContaining("type");
		}
		
		String[] array = new String[] { "Durian", "Guava", "Pitaya" };
		String text = "Length expected: [" + 3 + "] but was: [" + array.length + "]";
		try {
			Supplier<String> desc = () -> text;
			assertThat(array).as(desc).hasSize(2);
		} catch (AssertionError e) {
			e.printStackTrace();
			assertThat(e).hasMessageContaining(text);
		}
	}
}
