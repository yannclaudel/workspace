package com.algo.exercice;

import java.util.*;

public class FibonacciLastDigit {
	
	public static int getFibonacciLastDigit(int n) {		
		return 0;
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
