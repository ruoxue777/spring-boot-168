package org.ruoxue.spring_boot_168.test.junit5;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class JUnit5ParameterizedTest {

	@ParameterizedTest
	@ValueSource(ints = { 1, 2, 3 })
	public void numberWorld(int value) {
		System.out.println(value);
		assertTrue(value > 0);
	}

	@ParameterizedTest
	@ValueSource(strings = { "Java", "Groovy", "Kotlin" })
	public void langWorld(String value) {
		System.out.println(value);
		assertTrue(value.length() > 0);
	}

	enum Status {
		A, B, C
	}

	@ParameterizedTest
	@EnumSource(value = Status.class, names = { "A", "B", "C" })
	public void enumWorld(Status status) {
		System.out.println(status);
		assertNotNull(status);
	}

	@ParameterizedTest
	@EnumSource(value = Status.class, mode = Mode.EXCLUDE, names = { "A" })
	public void enumExclueWorld(Status status) {
		System.out.println(status);
		assertNotNull(status);
	}

	static Stream<String> stringProvider() {
		return Stream.of("Java", "Groovy");
	}

	@ParameterizedTest
	@MethodSource("stringProvider")
	public void methodWorld(String value) {
		System.out.println(value);
		assertTrue(value.length() > 0);
	}

	static IntStream intProvider() {
		return IntStream.range(1, 3);
	}

	@ParameterizedTest
	@MethodSource("intProvider")
	public void methodIntWorld(int value) {
		System.out.println(value);
		assertTrue(value > 0);
	}

	@ParameterizedTest
	@CsvSource({ "Java,      4", "Groovy,   6", "Kotlin,    6" })
	public void csvWorld(String value, int length) {
		System.out.println(value + ", " + length);
		assertTrue(value.length() > 0);
		assertTrue(length > 0);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/org/ruoxue/spring_boot_168/test/junit5/csvFileWorld.csv", numLinesToSkip = 1)
	public void csvFileWorld(String value, int length) {
		System.out.println(value + ", " + length);
		assertTrue(value.length() > 0);
		assertTrue(length > 0);
	}

//	public class CustomArgumentsProvider implements ArgumentsProvider {
//
//	    @Override
//	    public Stream<? extends Arguments> 
//			provideArguments(ExtensionContext extensionContext) throws Exception {
//	        return Stream.of("java", "rust", "kotlin").map(Arguments::of);
//	    }
//	}
//	
//    @ParameterizedTest
//    @ArgumentsSource(CustomArgumentsProvider.class)
//    public void argumentWorld(String value) {
//    	System.out.println(value);
//    }

}