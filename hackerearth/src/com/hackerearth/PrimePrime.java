package com.hackerearth;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PrimePrime {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out), true);

		// Start writing your solution here. -------------------------------------
		int n = sc.nextInt() + 1;
		List<Integer> prime = new ArrayList<Integer>();
		prime.add(2);
		boolean[] b = new boolean[n];

		for (int i = 3; i < n; i += 2) {
			if (!b[i]) {
				prime.add(i);
				if (i <= Math.sqrt(n)) {
					for (int j = 2 * i; j < n; j += i) {
						b[j] = true;
					}
				}
			}
		}
		// Stop writing your solution here. -------------------------------------
		for (Integer p : prime) {
			out.print(p + " ");
		}
		out.close();
	}

	public static PrintWriter out;

	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
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

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
