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
	public void testWithMultiArgMethodSource(final int a,final int b,final int sol) {
		assertEquals(sol, GCD.gcd(a, b));
	}

	@SuppressWarnings("boxing")
	public static Stream<Arguments> solution() {
		return Stream.of(
				Arguments.of(15,20,5), 
				Arguments.of(31,41,1), 
				Arguments.of(121,11,11),
				Arguments.of(78_789,45_612,3),
				Arguments.of(9_562_113,9_755_287,96_587),
				Arguments.of(28_851_538,1_183_019,17_657));
	}
}
