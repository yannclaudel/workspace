package com.algo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.algo.exercice.CoveringSegments;
import com.algo.solution.Segment;

public class CoveringSegmentsTest {
	@ParameterizedTest
	@MethodSource("solution")
	void testWithMultiArgMethodSource(Segment[] segments ,int[] sol) {
		assertArrayEquals(sol, CoveringSegments.optimalPoints(segments));
	}

	static Stream<Arguments> solution() {
		return Stream.of(
				Arguments.of(new Segment[] {new Segment(0, 1),new Segment(1, 2)},new int[]{1}),
				Arguments.of(new Segment[] {new Segment(0, 2),new Segment(1, 2),new Segment(3, 5),new Segment(4, 6)},new int[]{2,5}),
				Arguments.of(new Segment[] {new Segment(1, 3),new Segment(9, 10),new Segment(2, 4),new Segment(10, 11),new Segment(8, 10),new Segment(5, 7)},new int[]{3,7,10})
				);
				}
}
