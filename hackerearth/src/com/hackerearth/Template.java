package com.hackerearth;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class Template {
	  public static void main(String[] args) {
	        MyScanner sc = new MyScanner();
	        out = new PrintWriter(new BufferedOutputStream(System.out), true);
	        // Start writing your solution here. -------------------------------------
	        int n = sc.nextInt();
	        char[] l = sc.nextLine().replace(" ","").toCharArray();
	        int q = sc.nextInt();
	        for(int i=0; i<q; i++){
	            int a = sc.nextInt() - 1 ;
	            int b = sc.nextInt();
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
	 
	        int nextInt() { return Integer.parseInt(next()); }
	        long nextLong() { return Long.parseLong(next()); }
	        double nextDouble() { return Double.parseDouble(next()); }
	         
	        String nextLine(){
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
