package com.algo.exercice;

public class GCD {
	
	/**
	 * TODO
	 * @param a
	 * @param b
	 * @return gcd
	 */
	public static int gcd(int a, int b) {		
			return 1;
	}
	/**
	 * Naive solution
	 * @param a
	 * @param b
	 * @return gcd
	 */
	public static int gcd_naive(int a, int b) {
		int current_gcd = 1;
		for (int d = 2; d <= a && d <= b; ++d) {
			if (a % d == 0 && b % d == 0) {
				if (d > current_gcd) {
					current_gcd = d;
				}
			}
		}

		return current_gcd;
	}

	
}
