package com.algo.exercice;

import java.util.Scanner;

public class CarFueling {

	/**
	 * TODO
	 * 
	 * @param dist
	 * @param tank
	 * @param stops
	 * @return minCountRefill
	 */
	public static int computeMinRefills(int dist, int tank, int[] stops) {
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dist = scanner.nextInt();
		int tank = scanner.nextInt();
		int n = scanner.nextInt();
		int stops[] = new int[n];
		for (int i = 0; i < n; i++) {
			stops[i] = scanner.nextInt();
		}

		System.out.println(computeMinRefills(dist, tank, stops));

		scanner.close();
	}
}
