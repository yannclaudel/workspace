package com.algo.exercice;
import java.util.Scanner;

public class ChangeDP {
	/**
	 * TODO
	 * @param m
	 * @param coins
	 * @return minimum of coins used
	 */
	
	public static int getChange(int m,int[] coins) {		
		return-1;
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
