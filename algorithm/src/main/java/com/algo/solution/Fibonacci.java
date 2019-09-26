package com.algo.solution;
import java.util.Scanner;

public class Fibonacci {

	/**
	 * 
	 * THIS IS NOT A OPTIMAL SOLUTION
	 * 
	 * @param n
	 * @return fibonacci solution
	 */
	public static long calc_fib_rec(int n) {
		if (n <= 1)
			return n;

		return calc_fib_rec(n - 1) + calc_fib_rec(n - 2);
	}

	/**
	 * 
	 * @param n
	 * @return long
	 */
	public static long calc_fib(int n) {
		if (n <= 1)
			return n;

		long a = 0;
		long b = 1;
		long fibo = 0;

		for (int i = 2; i <= n; i++) {
			fibo = a + b;
			a = b;
			b = fibo;
		}

		return fibo;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(calc_fib(n));
		in.close();
	}
}
