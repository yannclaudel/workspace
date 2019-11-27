package com.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.algo.exercice.BinarySearch;

public class BinarySearchTest {

	@ParameterizedTest
	@MethodSource("solution")
	public void testWithMultiArgMethodSource(final int key,final  int[] a ,final int sol) {
		assertEquals(sol, BinarySearch.binarySearch(a, key));
	}
	
	@Test
	public void testHugeArray() {
		final int size = 100_000_000;
		int[] huge = new int[size];
		for (int i = 0; i < huge.length; i++) {
			huge[i]=i;
		}
		final int index = (int)(Math.random()*size);
		final int key = huge[index];
		assertEquals(index, BinarySearch.binarySearch(huge, key));
	}

	@SuppressWarnings("boxing")
	public static Stream<Arguments> solution() {
		return Stream.of(
				Arguments.of(7,new int[]{7,8,9,10},0), 
				Arguments.of(5,new int[]{2,3,5,6},2),
				Arguments.of(12,new int[]{2,4,6,8,10,12,14,16,89},5),
				Arguments.of(300,new int[]{2,4,6,8,10,12,14,16,89},-1));
				}
	
}
