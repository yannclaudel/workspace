package com.algo.exercice;

public class FibonacciLastDigit {
	
	public static int getFibonacciLastDigit(final int n) {		
		return 0;
	}
	/**
	 * naive solution
	 * @param n
	 * @return
	 */
	public static int getFibonacciLastDigitNaive(final int n) {
		if (n <= 1) {
			return n;
		}

		int previous = 0;
		int current = 1;
		int tmp = -1;
		for (long i = 0; i < n - 1; ++i) {
			tmp = previous;
			previous = current;
			current = tmp + current;
		}

		return current % 10;
	}

}
