package com.hackerearth;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Modulo {

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out), true);
		// Start writing your solution here. -------------------------------------
		int n = sc.nextInt();
		long[] store = new long[n];
		long[] store2 = new long[n];
		long max = 0;
		for (int i = 0; i < store.length; i++) {
			store[i] = sc.nextLong();
			store2[i] = store[i];
			if (max < store[i])
				max = store[i];
		}
long start = System.currentTimeMillis();
		for (int i = 2; i < max + 1; i++) {
			long result = store2[0] % i;
			boolean find = true;
			for (int j = 1; j < store2.length; j++) {
				if (store2[j] % i != result) {
					find = false;
					break;
				}
			}
			if (find) {
				out.print(i + " ");
			}
		}
		out.println("");
		out.println(System.currentTimeMillis()-start);
		start = System.currentTimeMillis();
out.println("\n--------------------------\n");

		for (int i = 2; i < max + 1; i++) {
			long result = store[0] % i;
			boolean find = true;
			for (int j = 1; j < store.length; j++) {
				if (store[j] % i != result) {
					find = false;
					break;
				}
			}
			if (find) {
				for (int j = 0; j < store.length; j++) {
					store[j] = store[j]-store[j] % i;
				}
				max = max - max % i;
				out.print(i + " ");
			}
		}
		out.println("");
		out.println(System.currentTimeMillis()-start);
		start = System.currentTimeMillis();

		// Stop writing your solution here. -------------------------------------
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
