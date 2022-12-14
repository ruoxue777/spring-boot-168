package org.ruoxue.spring_boot_168.test.junit5;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnit5OrderAnnotationTest {

	@Test
	public void helloWorld6() {
		System.out.println("helloWorld6");
	}

	@Order(3)
	@Test
	public void helloWorld1() {
		System.out.println("helloWorld1");
	}

	@Order(1)
	@Test
	public void helloWorld2() {
		System.out.println("helloWorld2");
	}

	@Test
	public void helloWorld5() {
		System.out.println("helloWorld5");
	}

	@Order(2)
	@Test
	public void helloWorld3() {
		System.out.println("helloWorld3");
	}

	@Test
	public void helloWorld4() {
		System.out.println("helloWorld4");
	}
}