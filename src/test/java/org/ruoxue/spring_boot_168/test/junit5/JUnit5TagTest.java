package org.ruoxue.spring_boot_168.test.junit5;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class JUnit5TagTest {

	@Tag("develop")
	@Test
	public void develop() {
		System.out.println("develop");
	}

	@Tag("prod")
	@Test
	public void prod() {
		System.out.println("prod");
	}
}