package com.datastructure;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.datastructure.exercice.MaxHeap;

public class MaxHeapTest {
	@Test
	public void testMaxHeap() {

		final MaxHeap maxHeap = new MaxHeap();
		maxHeap.insert(42);
		maxHeap.insert(29);
		maxHeap.insert(18);
		maxHeap.insert(14);
		maxHeap.insert(7);
		maxHeap.insert(18);
		maxHeap.insert(12);
		maxHeap.insert(11);
		int[] test = maxHeap.getHeap().stream().mapToInt(i -> i).toArray();
		assertArrayEquals(test, new int[] { 42, 29, 18, 14, 7, 18, 12, 11 },"Array Equals to { 42, 29, 18, 14, 7, 18, 12, 11 }");

		maxHeap.insert(30);
		test = maxHeap.getHeap().stream().mapToInt(i -> i).toArray();
		assertArrayEquals(test, new int[] { 42, 30, 18, 29, 7, 18, 12, 11, 14 },"Array Equals to { 42, 30, 18, 29, 7, 18, 12, 11, 14 }");

		maxHeap.extractMax();
		test = maxHeap.getHeap().stream().mapToInt(i -> i).toArray();
		assertArrayEquals(test, new int[] { 30, 29, 18, 14, 7, 18, 12, 11 },"Array Equals to { 30, 29, 18, 14, 7, 18, 12, 11 }");

		maxHeap.insert(50);
		test = maxHeap.getHeap().stream().mapToInt(i -> i).toArray();
		assertArrayEquals(test, new int[] { 50, 30, 18, 29, 7, 18, 12, 11, 14 },"Array Equals to { 50, 30, 18, 29, 7, 18, 12, 11, 14 }");

		maxHeap.changePriority(2, new Integer(17));
		test = maxHeap.getHeap().stream().mapToInt(i -> i).toArray();
		assertArrayEquals(test, new int[] { 50, 30, 18, 29, 7, 17, 12, 11, 14 },"Array Equals to { 50, 30, 18, 29, 7, 17, 12, 11, 14 }");

	}

}
