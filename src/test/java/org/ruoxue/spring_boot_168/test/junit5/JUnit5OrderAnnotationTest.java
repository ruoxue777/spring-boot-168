package org.ruoxue.spring_boot_168.test.junit5;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnit5OrderAnnotationTest {

	@Test
	public void itWorld6() {
		System.out.println("itWorld6");
	}

	@Order(3)
	@Test
	public void itWorld1() {
		System.out.println("itWorld1");
	}

	@Order(1)
	@Test
	public void itWorld2() {
		System.out.println("itWorld2");
	}

	@Test
	public void itWorld5() {
		System.out.println("itWorld5");
	}

	@Order(2)
	@Test
	public void itWorld3() {
		System.out.println("itWorld3");
	}

	@Test
	public void itWorld4() {
		System.out.println("itWorld4");
	}
}