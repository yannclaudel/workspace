package com.algo.solution;

public class BinarySearch {

	public static int binarySearch(final int[] a, final int key) {
		int min = 0;
		int max = a.length - 1;
		int rtn = -1;
		if (a[max] < key || key < a[min]) {
			rtn = -1;
		} else {
			int mid;
			while (min <= max) {
				mid = min + (max - min) / 2;
				if (key == a[mid]) {
					rtn = mid;
					break;
				} else if (key < a[mid]) {
					max = mid - 1;
				} else {
					min = mid + 1;
				}
			}
		}
		return rtn;
	}

	/**
	 * Linear solution
	 */
	static int linearSearch(final int[] a, final int x) {
		int rtn = -1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				rtn = i;
				break;
			}
		}
		return rtn;
	}
}
