package org.ruoxue.spring_boot_168.test.assertj;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AssertingMapsTest {

	public AssertingMapsTest() {

	}

	@NoArgsConstructor
	@Getter
	@Setter
	@Builder
	public static class Person {
		private String name;
		private int age;
		private int type;

		public Person(String name, int age, int type) {
			this.name = name;
			this.age = age;
			this.type = type;
		}

		public String toString() {
			ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
			builder.appendSuper(super.toString());
			builder.append("name", name);
			builder.append("age", age);
			builder.append("type", type);
			return builder.toString();
		}
	}

	@Test
	public void hasSize() {
		int expectedSize = 3;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Amy", 18);
		map.put("Betty", 19);
		map.put("Clare", 20);

		assertThat(map).hasSize(expectedSize);
	}

	@Test
	public void containsKeys() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Amy", 18);
		map.put("Betty", 19);
		map.put("Clare", 20);

		assertThat(map).containsKeys("Amy", "Betty");
	}

	@Test
	public void doesNotContainKeys() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Amy", 18);
		map.put("Betty", 19);
		map.put("Clare", 20);

		assertThat(map).doesNotContainKeys("Dora", "Eva");
	}

	@Test
	public void containsValues() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Amy", 18);
		map.put("Betty", 19);
		map.put("Clare", 20);

		assertThat(map).containsValues(18, 19);
	}

	@Test
	public void doesNotContainValue() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Amy", 18);
		map.put("Betty", 19);
		map.put("Clare", 20);

		assertThat(map).doesNotContainValue(30);
	}

	@Test
	public void containsEntry() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Amy", 18);
		map.put("Betty", 19);
		map.put("Clare", 20);

		assertThat(map).containsEntry("Amy", 18);
	}

	@Test
	public void doesNotContainEntry() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Amy", 18);
		map.put("Betty", 19);
		map.put("Clare", 20);

		assertThat(map).doesNotContainEntry("Dora", 28);
	}

	@Test
	public void containsOnly() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Amy", 18);
		map.put("Betty", 19);
		map.put("Clare", 20);

		assertThat(map).containsOnly(entry("Betty", 19), entry("Clare", 20), entry("Amy", 18));
	}

	@Test
	public void containsExactly() {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("Amy", 18);
		map.put("Betty", 19);
		map.put("Clare", 20);

		assertThat(map).containsExactly(entry("Amy", 18), entry("Betty", 19), entry("Clare", 20));
	}

	@Test
	public void containsAnyOf() {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("Amy", 18);
		map.put("Betty", 19);
		map.put("Clare", 20);

		assertThat(map).containsAnyOf(entry("Dora", 28), entry("Amy", 18), entry("Eva", 38));
	}

	@Test
	public void extracting() {
		Person amy = new Person("Amy", 18, 3);
		Person betty = new Person("Betty", 19, 3);
		Person clare = new Person("Clare", 20, 3);
		Map<String, Person> map = new LinkedHashMap<String, Person>();
		map.put(amy.getName(), amy);
		map.put(betty.getName(), betty);
		map.put(clare.getName(), clare);

		assertThat(map).extracting("Amy", "Betty", "Clare").contains(amy, betty);

	}

	@Test
	public void anySatisfy() {
		Person amy = new Person("Amy", 18, 3);
		Person betty = new Person("Betty", 19, 3);
		Person clare = new Person("Clare", 20, 3);
		Map<String, Person> map = new LinkedHashMap<String, Person>();
		map.put(amy.getName(), amy);
		map.put(betty.getName(), betty);
		map.put(clare.getName(), clare);

		assertThat(map).allSatisfy((k, v) -> {
			assertThat(v.getType()).isEqualTo(3);
			assertThat(v.getName()).isNotNull();
		});

		assertThat(map).anySatisfy((k, v) -> {
			assertThat(v.getType()).isEqualTo(3);
			assertThat(v.getName()).isEqualTo("Amy");
		});

		assertThat(map).noneSatisfy((k, v) -> {
			assertThat(v.getType()).isEqualTo(1);
		});
	}

	@Test
	public void isEqualTo() {
		Person amy = new Person("Amy", 18, 3);
		Person betty = new Person("Betty", 19, 3);
		Person clare = new Person("Clare", 20, 3);
		Map<String, Person> map = new LinkedHashMap<String, Person>();
		map.put(amy.getName(), amy);
		map.put(betty.getName(), betty);
		map.put(clare.getName(), clare);

		Map<String, Person> map2 = new LinkedHashMap<String, Person>();
		map2.put(amy.getName(), amy);
		map2.put(betty.getName(), betty);
		map2.put(clare.getName(), clare);

		assertThat(map).isEqualTo(map2);
	}
}
