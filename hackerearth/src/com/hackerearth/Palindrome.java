package com.hackerearth;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Palindrome {

	public static boolean isAPalindrome(char[] str) {
		boolean rtn = true;
		for (int i = 0; i < str.length / 2; i++) {
			if (str[i] != str[str.length - 1 - i]) {
				rtn = false;
				break;
			}
		}
		// out.println(">>> "+new String(str)+" - "+rtn);
		return rtn;
	}

	public static boolean isAPalindrome(char[] str, int a, int b) {
		boolean rtn = true;
		for (int i = a; i < b / 2; i++) {
			if (str[i] != str[b - 1 - i]) {
				rtn = false;
				break;
			}
		}
		//out.println(">>> " + a + " " + b + " " + new String(str) + " - " + rtn);
		return rtn;
	}

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out), true);
		// Start writing your solution here. -------------------------------------
		char[] str = sc.next().toCharArray();
		boolean fullP = true;
		for (int i = 0; i < str.length; i++) {
			if (str[i] != str[0]) {
				fullP = false;
				break;
			}
		}
		if (fullP)
			out.print(0);
		else {
			int count = 0;
			for (int i = str.length; i > 0; i--) {
				for (int j = 0; j < str.length + 1 - i; j++) {
					if (!isAPalindrome(str, j, i)) {
						count = i;
						break;
					}

				}
				if (count > 0)
					break;
			}
			out.print(count);
		}
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
