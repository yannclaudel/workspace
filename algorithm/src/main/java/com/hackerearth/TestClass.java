package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TestClass {

	public static void main(String[] args) {
		//Scanner
        Scanner s = new Scanner(System.in);
		
		
		// Start writing your solution here. -------------------------------------
		String read=null;
		int dix = 10;
		int _11 = 1;
		int current;
		while(true) {
			try {
				read = s.nextLine(); 
			} catch (Exception e) {
				break;
			}
			
			if (read != null && read.length()>0)
				current = Integer.valueOf(read).intValue();
			else 
				break;

			dix = 10;
			_11 = 1;
			for (int j = 1; j < 100000; j++) {
				if (current % dix == 0) {
					_11 *= 11;
				} else
					break;
				dix *= 10;
			}
			dix/=10;
			System.out.println(current / dix * _11);
			//out.println(current +"/"+ dix +"/"+ _11 + "\n");

		}

		// out.println(">>>" + (System.currentTimeMillis()-start));
		// start = System.currentTimeMillis();

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
