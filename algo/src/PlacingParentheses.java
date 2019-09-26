import java.util.Scanner;

class Pair {
	long min = 0;
	long max = 0;

	public Pair(long min, long max) {
		super();
		this.min = min;
		this.max = max;
	}
}

public class PlacingParentheses {

	private static Pair getMinAndMax(int i, int j, long[][] m, long[][] M, char op[]) {
		long min = Integer.MAX_VALUE;
		long max = Integer.MIN_VALUE;

		for (int k = i; k <= j - 1; k++) {
			long a = eval(M[i][k], op[k], M[k + 1][j]);
			if (a < min)
				min = a;
			if (a > max)
				max = a;
			long b = eval(M[i][k], op[k], m[k + 1][j]);
			if (b < min)
				min = b;
			if (b > max)
				max = b;
			long c = eval(m[i][k], op[k], M[k + 1][j]);
			if (c < min)
				min = c;
			if (c > max)
				max = c;
			long d = eval(m[i][k], op[k], m[k + 1][j]);
			if (d < min)
				min = d;
			if (d > max)
				max = d;
		}
		return new Pair(min, max);
	}

	private static long eval(long a, char op, long b) {
		if (op == '+') {
			return a + b;
		} else if (op == '-') {
			return a - b;
		} else if (op == '*') {
			return a * b;
		} else {
			assert false;
			return 0;
		}
	}

	private static long getMaximValue(String exp) {

		int n = 1 + (exp.length() - 1) / 2;
		int d[] = new int[n];
		char op[] = new char[n - 1];
		for (int i = 0; i < exp.length(); i++) {
			if (i % 2 == 0) {
				d[i / 2] = Character.getNumericValue(exp.charAt(i));
			} else {
				op[(i - 1) / 2] = exp.charAt(i);
			}

		}
		long[][] m = new long[n][n];
		long[][] M = new long[n][n];
		for (int i = 0; i < n; i++) {
			m[i][i] = d[i];
			M[i][i] = d[i];
		}
		for (int s = 1; s <= n - 1; s++) {
			for (int i = 0; i < n - s; i++) {
				int j = i + s;
				Pair minMax = getMinAndMax(i, j, m, M, op);
				m[i][j] = minMax.min;
				M[i][j] = minMax.max;
			}
		}
/*
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("[" + m[i][j] + "," + M[i][j] + "]\t");
			}
			System.out.println("");
		}*/
		return M[0][n - 1];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String exp = scanner.next();
		System.out.println(getMaximValue(exp));
	}
}
