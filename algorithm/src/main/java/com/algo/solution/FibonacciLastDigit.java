package com.algo.solution;

public class FibonacciLastDigit {
	
	public static int getFibonacciLastDigit(final int n) {
		if (n <= 1) {
			return n;
		}

		int previous = 0;
		int current = 1;
		int tmp = -1;
		for (long i = 0; i < n - 1; ++i) {
			tmp = previous;
			previous = current % 10;
			current = (tmp + current) % 10;
		}

		return current;
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
