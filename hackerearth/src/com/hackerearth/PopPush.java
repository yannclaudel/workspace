package com.hackerearth;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class PopPush {

	public static void main(String[] args) {
		//long start = System.currentTimeMillis();
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out), true);
		int q = sc.nextInt();
		StringBuffer result = new StringBuffer();
		/*
		Deque<Integer> d1 = new ArrayDeque<Integer>();
		for (int j = 1; j < 10001; j++) {
			d1.addLast(j);
		}
		Deque<Integer> d2 = new ArrayDeque<Integer>();
		for (int j = 1; j < 20001; j++) {
			d2.addLast(j);
		}
		*/
		for (int i = 0; i < q; i++) {
			int n = sc.nextInt();
			/*Deque<Integer> deque = null;
			if (n < 10000) { 
				deque = new ArrayDeque<Integer>();
				for (int j = 1; j < n + 1; j++) {
					deque.addLast(j);
				}
			}else if (n < 20000) {
				deque = new ArrayDeque<Integer>(d1);
				for (int j = 10001; j < n + 1; j++) {
					deque.addLast(j);
				}				
			}else  {
				deque = new ArrayDeque<Integer>(d2);
				for (int j = 20001; j < n + 1; j++) {
					deque.addLast(j);
				}				
			}
*/
			// out.println(System.currentTimeMillis()-start);
			Deque<Integer> deque = new ArrayDeque<Integer>();
				for (int j = 2; j < n + 1; j+=2) {
					deque.addLast(j);
				}
				if(n%2==1) {
					deque.addLast(deque.pollFirst());
				}
			while (deque.size() > 1) {
				deque.removeFirst();
				if (deque.size() == 1)
					break;
				deque.addLast(deque.pollFirst());
			}
			// out.println(System.currentTimeMillis()-start);
			result.append(deque.peekFirst()).append("\n");
		}
		out.print(result);

		//out.println(System.currentTimeMillis() - start);
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
