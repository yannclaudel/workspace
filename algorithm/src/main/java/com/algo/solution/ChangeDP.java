package com.algo.solution;
import java.util.Scanner;

public class ChangeDP {
	/**
	 * TODO
	 * @param m
	 * @param coins
	 * @return minimum of coins used
	 */
	public static int getChange(int m,int[] coins) {
		
		int[] minnumcoins = new int[m + 1];
		minnumcoins[0] = 0;

		for (int i = 1; i < minnumcoins.length; i++) {
			minnumcoins[i] = Integer.MAX_VALUE;
			for (int c : coins) {
				if (i >= c) {
					if (minnumcoins[i - c] + 1 < minnumcoins[i])
						minnumcoins[i] = minnumcoins[i - c] + 1;
				}				
			}			
		}
		if (minnumcoins[m]==Integer.MAX_VALUE || minnumcoins[m]<0)
			return -1;
		return minnumcoins[m];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }
		System.out.println(getChange(m,coins));
		scanner.close();

	}
}
