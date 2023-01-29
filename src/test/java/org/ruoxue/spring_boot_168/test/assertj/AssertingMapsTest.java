package org.ruoxue.spring_boot_168.test.assertj;

import static org.assertj.core.api.Assertions.*;

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
	public void extracting() {
		Person amy = new Person("Amy", 18, 3);
		Person betty = new Person("Betty", 19, 3);
		Person clare = new Person("Clare", 20, 3);
		Map<String, Person> map = new LinkedHashMap<String, Person>();
		map.put(amy.getName(), amy);
		map.put(betty.getName(), betty);
		map.put(clare.getName(), clare);
		System.out.println(map);
		assertThat(map).extracting("Amy", "Betty", "Clare").contains(amy, betty);
	}

	@Test
	public void allSatisfy() {
		Person amy = new Person("Amy", 18, 3);
		Person betty = new Person("Betty", 19, 3);
		Person clare = new Person("Clare", 20, 3);
		Map<String, Person> map = new LinkedHashMap<String, Person>();
		map.put(amy.getName(), amy);
		map.put(betty.getName(), betty);
		map.put(clare.getName(), clare);
		System.out.println(map);
		assertThat(map).allSatisfy((k, v) -> {
			assertThat(v.getType()).isEqualTo(3);
			assertThat(v.getName()).isNotNull();
		});
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
		System.out.println(map);
		assertThat(map).anySatisfy((k, v) -> {
			assertThat(v.getType()).isEqualTo(3);
			assertThat(v.getName()).isEqualTo("Amy");
		});
	}

	@Test
	public void noneSatisfy() {
		Person amy = new Person("Amy", 18, 3);
		Person betty = new Person("Betty", 19, 3);
		Person clare = new Person("Clare", 20, 3);
		Map<String, Person> map = new LinkedHashMap<String, Person>();
		map.put(amy.getName(), amy);
		map.put(betty.getName(), betty);
		map.put(clare.getName(), clare);
		System.out.println(map);
		assertThat(map).noneSatisfy((k, v) -> {
			assertThat(v.getType()).isEqualTo(1);
		});
	}

}
