package com.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.algo.exercice.LCM;

public class LCMTest {

	@ParameterizedTest
	@MethodSource("solution")
	void testWithMultiArgMethodSource(int a, int b, long sol) {
		assertEquals(sol, LCM.lcm(a, b));
	}

	@SuppressWarnings("boxing")
	static Stream<Arguments> solution() {
		return Stream.of(
				Arguments.of(12,16,48l), 
				Arguments.of(3,5,15l), 
				Arguments.of(121,11,121l),
				Arguments.of(9562113,9755287,965773413l),
				Arguments.of(761457,614573,467970912861l));
	}
}
