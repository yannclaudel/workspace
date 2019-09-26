package com.algo.solution;

import java.util.*;

public class FibonacciLastDigit {
	
	public static int getFibonacciLastDigit(int n) {
		if (n <= 1)
			return n;

		int previous = 0;
		int current = 1;

		for (long i = 0; i < n - 1; ++i) {
			int tmp_previous = previous;
			previous = current % 10;
			current = (tmp_previous + current) % 10;
		}

		return current;
	}
	/**
	 * naive solution
	 * @param n
	 * @return
	 */
	public static int getFibonacciLastDigitNaive(int n) {
		if (n <= 1)
			return n;

		int previous = 0;
		int current = 1;

		for (long i = 0; i < n - 1; ++i) {
			int tmp_previous = previous;
			previous = current;
			current = tmp_previous + current;
		}

		return current % 10;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println("getFibonacciLastDigitNaive = "+getFibonacciLastDigitNaive(n));
		System.out.println("getFibonacciLastDigit      = "+getFibonacciLastDigit(n));
		scanner.close();
	}
}
