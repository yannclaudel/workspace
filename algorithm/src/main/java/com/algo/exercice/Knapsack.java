package com.algo.exercice;

import java.util.*;

public class Knapsack {

	public static int optimalValue(int W, int[] w, int[] v) {
		return -1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int W, n;
		W = scanner.nextInt();
		n = scanner.nextInt();
		int[] w = new int[n];
		int[] v = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = scanner.nextInt();
		}
		for (int i = 0; i < n; i++) {
			v[i] = scanner.nextInt();
		}
		System.out.println(optimalValue(W, w, v));
		scanner.close();
	}
}
