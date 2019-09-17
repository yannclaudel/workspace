import java.util.*;
import java.io.*;

public class MajorityElement {
	
	
	private static boolean DEBUG = false;
	/*
	 * private static int getMajorityElement(int[] a, int left, int right) { if
	 * (left == right) { return -1; } if (left + 1 == right) { return a[left]; }
	 * //write your code here return -1; }
	 */
	public static int getMajorityElementBulk(int[] a, int left, int right) {
		int count=0;
		for (int i = 0; i < a.length; i++) {
			count=0;
			for (int j = 0; j < a.length; j++) {
				if (a[j]==a[i]) count++;
			}
			if (2*count>right) {
				return a[i];
			}
		}
		return -1;
	}
	public static int getMajorityElement(int[] a, int left, int right) {
		if (DEBUG) System.out.println("start\t" + left + "\t" + right);

		int rtn = -1;
		int mid = (right - left) / 2;
		
		if (left == right) {
			if (DEBUG)	System.out.println(
					">>> left=" + left + "\tmid=" + mid + "\tright=" + right + "\tb=" + "NA" + "\tc=" + "NA" + "\t return = -1");

			return -1;
		}
		if (left + 1 == right) {
			if (DEBUG) System.out.println(
					">>> left=" + left + "\tmid=" + mid + "\tright=" + right + "\tb=" + "NA" + "\tc=" + "NA" + "\t return = "+a[left]);
			return a[left];
		}

		
		if (left-right == 2) {
			if (a[left]==a[left+1]) {
				if (DEBUG) System.out.println(
						">>> left=" + left + "\tmid=" + mid + "\tright=" + right + "\tb=" + "NA" + "\tc=" + "NA" + "\t return = "+a[left]);
				return a[left];
			}
			else {
				if (DEBUG) System.out.println(
						">>> left=" + left + "\tmid=" + mid + "\tright=" + right + "\tb=" + "NA" + "\tc=" + "NA" + "\t return = -1");
				return -1;
			}
		}
		
		int b = getMajorityElement(a, left, left + mid);
		// System.out.println("\tb = getMajorityElement(a,left,left+mid) >>>
		// "+left+"\t"+(left+mid)+"\t"+b );
		int c = getMajorityElement(a, left + mid, right);
		// System.out.println("\tc = getMajorityElement(a,left+mid,right) >>>
		// "+(left+mid)+"\t"+right+"\t"+c );

		if (b == -1 && c == -1)
			rtn = -1;
		else if (b == c)
			rtn = b;
		else {
			int count_c = 0;
			for (int i = left; i < right; i++) {
				if (a[i] == c)
					count_c++;
			}
			if (DEBUG) System.out.println("count_c="+count_c);
			if (2*count_c > right-left)
				rtn = c;
			else {
				int count_b = 0;
				for (int i = left; i < right; i++) {
					if (a[i] == b)
						count_b++;
				}
				if (DEBUG) System.out.println("count_b="+count_b);
				if (2*count_b > right-left)
					rtn = b;
				else
					rtn = -1;
			}
		}
		if (DEBUG) System.out.println(
				">>> left=" + left + "\tmid=" + mid + "\tright=" + right + "\tb=" + b + "\tc=" + c + "\t return = " + rtn);
		return rtn;
	}


	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		if (getMajorityElement(a, 0, a.length) != -1) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
