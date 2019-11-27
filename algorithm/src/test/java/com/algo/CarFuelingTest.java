package com.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.algo.exercice.CarFueling;

public class CarFuelingTest {

	@ParameterizedTest
	@MethodSource("solution")
	public void testWithMultiArgMethodSource(final int dist,final  int tank,final int[] stops ,final int sol) {
		assertEquals(sol, CarFueling.computeMinRefills(dist, tank, stops));
	}

	@SuppressWarnings("boxing")
	public static Stream<Arguments> solution() {
		return Stream.of(
				Arguments.of(950,40,new int[]{200,375,550,750},-1), 
				Arguments.of(950,400,new int[]{200,375,550,750},2),
				Arguments.of(1655,300,new int[]{100,375,450,600,650,800,950,1200,1355},6));
				}
}
