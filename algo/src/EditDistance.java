import java.util.*;

class EditDistance {

	private static int getMin(int a, int b, int c) {
		if (a <= b && a <= c)
			return a;
		else if (b <= a && b <= c)
			return b;
		else
			return c;
	}

	public static int EditDistance(String s, String t) {
		int n = s.length();
		int m = t.length();
		int[][] d = new int[n + 1][m + 1];

		for (int i = 0; i < n + 1; i++) {
			d[i][0] = i;
		}
		for (int i = 0; i < m + 1; i++) {
			d[0][i] = i;
		}
		for (int j = 1; j < m + 1; j++) {
			for (int i = 1; i < n + 1; i++) {
				int insertion = d[i][j - 1] + 1;
				int deletion = d[i - 1][j] + 1;
				int match = d[i - 1][j - 1];
				int mismatch = d[i - 1][j - 1] + 1;
				if (s.charAt(i - 1) == t.charAt(j - 1)) {
					d[i][j] = getMin(insertion, deletion, match);
				} else {
					d[i][j] = getMin(insertion, deletion, mismatch);
				}
			}
		}
		for (int j = 1; j < m + 1; j++) {
			for (int i = 1; i < n + 1; i++) {
				System.out.print(d[i][j]+"\t");
			}
			System.out.println();
		}
		return d[n][m];
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		String s = scan.next();
		String t = scan.next();

		System.out.println(EditDistance(s, t));
	}

}
