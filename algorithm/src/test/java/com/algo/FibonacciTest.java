package com.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.algo.exercice.Fibonacci;

public class FibonacciTest {

	@ParameterizedTest
	@MethodSource("solution")
	void testWithMultiArgMethodSource(int n, int sol) {
		assertEquals(sol, Fibonacci.calcfib(n));
	}

	@SuppressWarnings("boxing")
	static Stream<Arguments> solution() {
	    return Stream.of(
	        Arguments.of(10, 55),
	        Arguments.of(11, 89),
	        Arguments.of(45,1134903170)
	    );
	}
}
