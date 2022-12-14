package org.ruoxue.spring_boot_168.test.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class JUnit5OrderDisplayNameTest {

	@DisplayName("helloWorld1")
	@Test
	public void helloWorldZ() {
		System.out.println("helloWorldZ");
	}

	@DisplayName("helloWorld2")
	@Test
	public void helloWorldA() {
		System.out.println("helloWorldA");
	}
	
	@DisplayName("helloWorld3")
	@Test
	public void helloWorldB() {
		System.out.println("helloWorldB");
	}

	@DisplayName("helloWorld4")
	@Test
	public void helloWorldY() {
		System.out.println("helloWorldY");
	}

	@DisplayName("helloWorld5")
	@Test
	public void helloWorldC() {
		System.out.println("helloWorldC");
	}

	@DisplayName("helloWorld6")
	@Test
	public void helloWorldX() {
		System.out.println("helloWorldX");
	}
}