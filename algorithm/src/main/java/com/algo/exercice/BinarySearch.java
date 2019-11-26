package com.algo.exercice;

public class BinarySearch {

	/**
	 * TODO : try an iterative solution
	 */
	public static int binarySearch(int[] a, int key) {
		return -1;
	}

	/**
	 * Linear solution
	 */
	static int linearSearch(final int[] a,final int x) {
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
