package com.hackerearth;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TestClass {

	public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        // Start writing your solution here. -------------------------------------
        long q = sc.nextLong();
        for(long i=0; i<q; i++){
            long a = sc.nextLong()%(1000000007);
            long min=1,max=1;
            /*
            if (a>1) {
            	max=a*(a-1)*(2*a-1)/6;
            }
            if ((a-1)%2==0) {
            	min = a * (a-1) *(a-1)/4;
            }else {
            	long f = (a-1)/2;
            	min = (a/2)*(f*f + (f+1)*(f+1));
            }
            out.println(min+" "+max);*/
            
            if (a>1) {
            	max=(a*(a-1))%(1000000007);
            	max=((max*(2*a-1))/6)%(1000000007);
            }
            if ((a-1)%2==0) {
            	min = (a * (a-1))%(1000000007);
            	min = (min* (a-1)/4)%(1000000007);
            }else {
            	long f = (a-1)/2;
            	min = ((a/2)*((f*f)%(1000000007) + ((f+1)*(f+1))%(1000000007)))%(1000000007);
            }
            out.println(min+" "+max);            
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
