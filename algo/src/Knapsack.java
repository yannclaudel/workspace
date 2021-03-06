import java.util.*;

public class Knapsack {
	static int optimalWeightOLD(int W, int[] w) {
		// write you code here
		int result = 0;
		for (int i = 0; i < w.length; i++) {
			if (result + w[i] <= W) {
				result += w[i];
			}
		}
		return result;
	}

	static int optimalWeight(int W, int[] w) {
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
					val = value[ww - w[i-1]][i - 1] + w[i-1];
				if (value[ww][i] < val)
					value[ww][i] = val;
			}
		}
		return value[W][w.length];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int W, n;
		W = scanner.nextInt();
		n = scanner.nextInt();
		int[] w = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = scanner.nextInt();
		}
		System.out.println(optimalWeight(W, w));
	}
}
