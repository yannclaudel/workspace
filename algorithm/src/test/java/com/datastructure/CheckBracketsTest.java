package com.datastructure;

import java.text.ParseException;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.datastructure.exercice.CheckBrackets;

public class CheckBracketsTest {

	@ParameterizedTest
	@MethodSource("solutionNok")
	void testWithMultiArgMethodSourceNok(String text) {
		Assertions.assertThrows(ParseException.class, () -> {
			CheckBrackets.checkBracket(text);
		  });
	}

	@ParameterizedTest
	@MethodSource("solutionOk")
	void testWithMultiArgMethodSourceOk(String text) {
		Assertions.assertDoesNotThrow(() -> {CheckBrackets.checkBracket(text);});
	}
	
	static Stream<Arguments> solutionOk() {
		return Stream.of(
				Arguments.of("{{e}}(e)(e(([e])e))"), 
				Arguments.of("()"),
				Arguments.of("[][][][][][][][][[[]]]((()))"));
	}	

	
	static Stream<Arguments> solutionNok() {
		return Stream.of(
				Arguments.of("{{e}}(e))(e(([e])e))"), 
				Arguments.of("("),
				Arguments.of("[][][][][][][][][[[]]]((()))]"));
	}	
}
