package com.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.algo.exercice.GCD;

public class GCDTest {
	@ParameterizedTest
	@MethodSource("solution")
	void testWithMultiArgMethodSource(int a, int b, int sol) {
		assertEquals(sol, GCD.gcd(a, b));
	}

	@SuppressWarnings("boxing")
	static Stream<Arguments> solution() {
		return Stream.of(
				Arguments.of(15,20,5), 
				Arguments.of(31,41,1), 
				Arguments.of(121,11,11),
				Arguments.of(78789,45612,3),
				Arguments.of(9562113,9755287,96587),
				Arguments.of(28851538,1183019,17657));
	}
}
