package com.algo.exercice;

import java.util.Scanner;

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
	static int linearSearch(int[] a, int x) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		System.out.print(binarySearch(a, k));
		scanner.close();
	}

}
