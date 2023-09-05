package org.ruoxue.spring_boot_168.test.assertj.optional;

import static org.assertj.core.api.Assertions.*;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

import com.google.common.base.Optional;

public class AssertJOptionalAssertionsTest {

	@Test
	public void aaa() {
		Optional<String> value = Optional.of("AssertJ 155");
		System.out.println(value);
	}
}
