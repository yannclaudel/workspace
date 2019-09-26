import java.util.*;
import java.io.*;

public class Partition3 {

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
				if (w[i - 1] <= ww)
					val = value[ww - w[i - 1]][i - 1] + w[i - 1];
				if (value[ww][i] < val)
					value[ww][i] = val;
			}
		}
		return value[W][w.length];
	}
	
	static int[] optimalSol(int W, int[] w) {
		int[] sol = new int[w.length];
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
				if (w[i - 1] <= ww)
					val = value[ww - w[i - 1]][i - 1] + w[i - 1];
				if (value[ww][i] < val)
					value[ww][i] = val;
			}
		}
		int index = W;
		for (int i = w.length; i > 0; i--) {
			if (value[index][i] - w[i-1] == value[index-i+1][i-1]) {
				sol[i-1]=1;
				index=index-w[i-1];
			}else sol[i-1]=0;
		}
		return sol;
	}

	private static int partition3(int[] A) {
		int W = 0;
		for (int i = 0; i < A.length; i++) {
			W += A[i];
		}
		if (W % 3 != 0)
			return 0;
		W = W / 3;
		System.out.println("W = "+W);
		int [] sol = optimalSol(W,A);
		for (int i = 0; i < sol.length; i++) {
			System.out.print(sol[i]+"\t");
		}
		
		return 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}
		System.out.println(partition3(A));
	}
}
