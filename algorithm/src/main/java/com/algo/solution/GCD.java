package com.algo.solution;

public class GCD {
	
	/**
	 * TODO
	 * @param a
	 * @param b
	 * @return gcd 
	 */
	public static int gcd(final int a,final int b) {
		final int c = a % b;

		if (c == 0) {
			return b;
		} else {
			return gcd(b, c);
		}
	}
	/**
	 * Naive solution
	 * @param a
	 * @param b
	 * @return gcd
	 */
	public static int gcd_naive(final int a,final int b) {
		int currentGcd = 1;
		for (int d = 2; d <= a && d <= b; ++d) {
			if (a % d == 0 && b % d == 0) {
				if (d > currentGcd) {
					currentGcd = d;
				}
			}
		}

		return currentGcd;
	}

	
}
