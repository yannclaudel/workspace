package com.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.algo.exercice.Knapsack;

public class KnapsackTest {
	@ParameterizedTest
	@MethodSource("solution")
	void testWithMultiArgMethodSource(int W, int[] w, int[] v,int sol) {
		assertEquals(sol, Knapsack.optimalValue(W, w, v));
	}

	@SuppressWarnings("boxing")
	static Stream<Arguments> solution() {
		return Stream.of(				
				Arguments.of(10,new int[]{6,3,4,2},new int[]{30,14,16,9},46),
				Arguments.of(50,new int[]{10,20,30},new int[]{60,100,120},220),
				Arguments.of(67,new int[]{23,26,20,18,32,27,29,26,30,27},new int[]{505,352,458,220,354,414,498,545,473,543},1270));
	}
}
