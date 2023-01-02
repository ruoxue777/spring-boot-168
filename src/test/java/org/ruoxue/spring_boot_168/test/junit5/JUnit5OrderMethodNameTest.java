package org.ruoxue.spring_boot_168.test.junit5;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class JUnit5OrderMethodNameTest {

	@Test
	public void itWorldZ() {
		System.out.println("itWorldZ");
	}

	@Test
	public void itWorldA() {
		System.out.println("itWorldA");
	}

	@Test
	public void itWorldB() {
		System.out.println("itWorldB");
	}

	@Test
	public void itWorldY() {
		System.out.println("itWorldY");
	}

	@Test
	public void itWorldC() {
		System.out.println("itWorldC");
	}

	@Test
	public void itWorldX() {
		System.out.println("itWorldX");
	}
}