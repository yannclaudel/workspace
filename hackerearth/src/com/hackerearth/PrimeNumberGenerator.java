package com.hackerearth;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class PrimeNumberGenerator {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out), true);
		
		List<Integer> p = Arrays.asList(2,3,5,7,11,13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67);
		
		
		
		
		// Start writing your solution here. -------------------------------------
		int q = sc.nextInt();
		int max = 0;
		int read = 0;
		List<Integer> request = new ArrayList<Integer>();
		for (int i = 0; i < q; i++) {
			read = sc.nextInt();
			if (max < read)
				max = read;
			request.add(read);
		}
		long time = System.currentTimeMillis();
		out.println(">>>"+time);
		max++;
		List<Integer> prime = new ArrayList<Integer>();
		List<Integer> primeprime = new ArrayList<Integer>();

		prime.add(2);
		primeprime.add(2);
		boolean[] b = new boolean[max];
		
		for (int i = 3; i < max; i += 2) {
			if (!b[i]) {
				prime.add(i);
				String str = Integer.toString(i);
				int sum = 0;
				for (int j = 0; j < str.length(); j++) {
					sum += Integer.valueOf(str.substring(j, j + 1));
				}
				if (p.contains(sum))
					primeprime.add(i);

				if (i <= Math.sqrt(max)) {
					for (int j = 2 * i; j < max; j += i) {
						b[j] = true;
					}
				}
			}
		}
		
		out.println(">>>"+(time-System.currentTimeMillis()));
		time = System.currentTimeMillis();
		int idx = 0;
		for (Integer c : request) {
			if (c==2)
				idx = 1;
			else
				idx = Collections.binarySearch(primeprime, c);
			out.println((idx < 0 ? primeprime.get(-idx - 2) : primeprime.get(idx-1)));
		}
		out.println(">>>"+(time-System.currentTimeMillis()));
		time = System.currentTimeMillis();

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
