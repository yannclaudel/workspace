package com.algo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.algo.exercice.QuickSorting;

public class QuickSortingTest {

	
	@ParameterizedTest
	@MethodSource("solution")
	void testWithMultiArgMethodSource(int[] a) {
		int[] copiedArray = Arrays.copyOf(a, a.length);
		Arrays.sort(copiedArray);
		QuickSorting.randomizedQuickSort(a, 0, a.length-1);
		assertArrayEquals(copiedArray, a);
	}
	
	@Test
	void testHugeArray() {
		int size = 1000000;
		int[] huge = new int[size];
		for (int i = 0; i < huge.length; i++) {
			huge[i]=(int)(Math.random()*size);
		}
		int[] copiedArray = Arrays.copyOf(huge, huge.length);
		Arrays.sort(copiedArray);
		QuickSorting.randomizedQuickSort(huge, 0, huge.length-1);
		assertArrayEquals(copiedArray, huge);
	}
	

	static Stream<Arguments> solution() {
		return Stream.of(
				Arguments.of(new int[]{7,8,9,1,5,6,9,7}), 
				Arguments.of(new int[]{14,16,89,-9,2,6,89,66,101,0}));
				}
	
}
