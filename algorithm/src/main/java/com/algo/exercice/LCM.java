package com.algo.exercice;

import java.util.*;

public class LCM {

	public static long lcm(int a, int b) {		
		return 0l;
	}

	public static long lcm_naive(int a, int b) {
		for (long l = 1; l <= (long) a * b; ++l)
			if (l % a == 0 && l % b == 0)
				return l;

		return (long) a * b;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		System.out.println("lcm_naive = " + lcm_naive(a, b));
		System.out.println("lcm       = " + lcm(a, b));
		
		scanner.close();
	}
}
