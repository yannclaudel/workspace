package com.algo.solution;

import java.util.Scanner;

public class BinarySearch {

	
	public static int binarySearch(int[] a, int key) {
		int min = 0, max = a.length - 1;
		int rtn = -1;
		if (a[max] < key || key < a[min])
			return -1;
		while (min <= max) {
			int mid = min + (max - min) / 2;
			if (key == a[mid]) {
				rtn=mid;
				break;
			}
			else if (key < a[mid])
				max = mid - 1;
			else
				min = mid + 1;
		}
		return rtn;
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
