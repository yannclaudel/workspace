package com.algo.exercice;

public class Fibonacci {

	/**
	 * 
	 * THIS IS NOT A OPTIMAL SOLUTION
	 * 
	 * @param n
	 * @return fibonacci solution
	 */
	public static long calcfibrec(final int n) {
		if (n <= 1) {
			return n;
		}

		return calcfibrec(n - 1) + calcfibrec(n - 2);
	}

	/**
	 * TODO
	 * 
	 * @param n
	 * @return long
	 */
	public static long calcfib(final int n) {
		return 0l;
	}

}