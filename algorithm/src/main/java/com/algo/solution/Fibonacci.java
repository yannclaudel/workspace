package com.algo.solution;

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
	 * 
	 * @param n
	 * @return long
	 */
	public static long calcfib(final int n) {
		long fibo = 0;
		if (n <= 1) {
			fibo = n;
		} else {

			long a = 0;
			long b = 1;

			for (int i = 2; i <= n; i++) {
				fibo = a + b;
				a = b;
				b = fibo;
			}
		}
		return fibo;
	}

}
