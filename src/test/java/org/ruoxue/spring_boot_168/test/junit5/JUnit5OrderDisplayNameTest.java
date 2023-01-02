package org.ruoxue.spring_boot_168.test.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class JUnit5OrderDisplayNameTest {

	@DisplayName("itWorld1")
	@Test
	public void itWorldZ() {
		System.out.println("itWorldZ");
	}

	@DisplayName("itWorld2")
	@Test
	public void itWorldA() {
		System.out.println("itWorldA");
	}
	
	@DisplayName("itWorld3")
	@Test
	public void itWorldB() {
		System.out.println("itWorldB");
	}

	@DisplayName("itWorld4")
	@Test
	public void itWorldY() {
		System.out.println("itWorldY");
	}

	@DisplayName("itWorld5")
	@Test
	public void itWorldC() {
		System.out.println("itWorldC");
	}

	@DisplayName("itWorld6")
	@Test
	public void itWorldX() {
		System.out.println("itWorldX");
	}
}