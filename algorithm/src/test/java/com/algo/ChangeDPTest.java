package com.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.algo.exercice.ChangeDP;

public class ChangeDPTest {

	@ParameterizedTest
	@MethodSource("solution")
	void testWithMultiArgMethodSource(int m, int[] coins, int sol) {
		assertEquals(sol, ChangeDP.getChange(m, coins));
	}

	@SuppressWarnings("boxing")
	static Stream<Arguments> solution() {
		return Stream.of(
				Arguments.of(6,new int[]{1,3,4},2), 
				Arguments.of(10,new int[]{1,3,4},3),
				Arguments.of(20,new int[]{1,5,7,8},3),
				Arguments.of(31,new int[]{1,9},7),
				Arguments.of(999,new int[]{1,5,10,20,37},27));
	}
	
}
