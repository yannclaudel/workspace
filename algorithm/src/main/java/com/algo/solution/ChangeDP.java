package com.algo.solution;

public class ChangeDP {
	/**
	 * TODO
	 * 
	 * @param m
	 * @param coins
	 * @return minimum of coins used
	 */
	public static int getChange(final int m, final int[] coins) {

		int[] minnumcoins = new int[m + 1];
		minnumcoins[0] = 0;

		for (int i = 1; i < minnumcoins.length; i++) {
			minnumcoins[i] = Integer.MAX_VALUE;
			for (final int c : coins) {
				if (i >= c) {
					if (minnumcoins[i - c] + 1 < minnumcoins[i]) {
						minnumcoins[i] = minnumcoins[i - c] + 1;
					}
				}
			}
		}
		if (minnumcoins[m] == Integer.MAX_VALUE || minnumcoins[m] < 0) {
			minnumcoins[m] = -1;
		}
		return minnumcoins[m];

	}

}
