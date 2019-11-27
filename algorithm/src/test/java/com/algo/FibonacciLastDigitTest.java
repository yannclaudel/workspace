package com.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.algo.exercice.FibonacciLastDigit;

public class FibonacciLastDigitTest {

	@ParameterizedTest
	@MethodSource("solution")
	public void testWithMultiArgMethodSource(int n, int sol) {
		assertEquals(sol, FibonacciLastDigit.getFibonacciLastDigit(n));
	}

	@SuppressWarnings("boxing")
	public static Stream<Arguments> solution() {
		return Stream.of(
				Arguments.of(10, 5), 
				Arguments.of(11, 9), 
				Arguments.of(45, 0), 
				Arguments.of(299, 1),
				Arguments.of(331, 9));
	}
}
