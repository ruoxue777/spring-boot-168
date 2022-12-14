package org.ruoxue.spring_boot_168.test.junit5;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class JUnit5OrderMethodNameTest {

	@Test
	public void helloWorldZ() {
		System.out.println("helloWorldZ");
	}

	@Test
	public void helloWorldA() {
		System.out.println("helloWorldA");
	}

	@Test
	public void helloWorldB() {
		System.out.println("helloWorldB");
	}

	@Test
	public void helloWorldY() {
		System.out.println("helloWorldY");
	}

	@Test
	public void helloWorldC() {
		System.out.println("helloWorldC");
	}

	@Test
	public void helloWorldX() {
		System.out.println("helloWorldX");
	}
}