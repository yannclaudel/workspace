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
	public void testWithMultiArgMethodSource(final int a,final  int b,final  long sol) {
		assertEquals(sol, LCM.lcm(a, b));
	}

	@SuppressWarnings("boxing")
	public static Stream<Arguments> solution() {
		return Stream.of(
				Arguments.of(12,16,48l), 
				Arguments.of(3,5,15l), 
				Arguments.of(121,11,121l),
				Arguments.of(9_562_113,9_755_287,965_773_413l),
				Arguments.of(761_457,614_573,467_970_912_861l));
	}
}
