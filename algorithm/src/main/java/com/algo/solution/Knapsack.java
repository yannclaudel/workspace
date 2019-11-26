package com.algo.solution;

public class Knapsack {
	
	public static int optimalValue(int W, int[] w, int[] v) {
		int[][] value = new int[W + 1][w.length + 1];
		for (int i = 0; i < W + 1; i++) {
			value[i][0] = 0;
		}
		for (int i = 0; i < w.length + 1; i++) {
			value[0][i] = 0;
		}
		for (int i = 1; i < w.length + 1; i++) {
			for (int ww = 1; ww < W + 1; ww++) {
				value[ww][i] = value[ww][i - 1];
				int val = 0;
				if (w[i-1] <= ww)
					val = value[ww - w[i-1]][i - 1] + v[i-1];
				if (value[ww][i] < val)
					value[ww][i] = val;
			}
		}
		return value[W][w.length];
	}

	
	
}
