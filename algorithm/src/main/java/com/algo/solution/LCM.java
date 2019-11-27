package com.algo.solution;

public class LCM {

	public static long lcm(int a, int b) {
		int gcd = GCD.gcd(a,b);
		return (long) (a / gcd) * ( b / gcd ) * gcd;
	}

	public static long lcm_naive(int a, int b) {
		for (long l = 1; l <= (long) a * b; ++l)
			if (l % a == 0 && l % b == 0) {
				return l;
			}

		return (long) a * b;
	}


}
