package com.hackerearth;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class DivisorNumber {

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out), true);
		// Start writing your solution here. -------------------------------------
		int q = sc.nextInt();
		List<Integer> N = new ArrayList<Integer>();
		//int[] N = new int[q];
		Set<Integer> Nset = new HashSet<Integer>();
		
		Set<Integer> primeset = new HashSet<Integer>();
		
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < q; i++) {
			int current = sc.nextInt();
			//N[i] = current;
			N.add(i, current);
			Nset.add(current);
			if (max < current)
				max = current;
			if (min > current)
				min = current;
		}
		//long start = System.currentTimeMillis();
		//out.println(">>>" + (System.currentTimeMillis()-start));
		//start = System.currentTimeMillis();
		List<Integer> prime = new ArrayList<Integer>();
		//Set<Integer> nprime = new HashSet<Integer>();
		Map<Integer,Integer> ncache = new HashMap<Integer,Integer>();
		prime.add(2);
		if (max%10000==0)
			max = max / 10000;
		max++;
		boolean[] b = new boolean[max];
		if (Nset.contains(2))
			ncache.put(2,2);
		for (int i = 3; i < max; i += 2) {
			if (!b[i]) {
				prime.add(i);
				primeset.add(i);
				if (i >= min) {
					if (Nset.contains(i))
						ncache.put(i,2);
				}
				if (i <= Math.sqrt(max)) {
					for (int j = 2 * i; j < max; j += i) {
						b[j] = true;
					}
				}
			}
		}
		//out.println(">>>" + (System.currentTimeMillis()-start));
		//start = System.currentTimeMillis();
		//out.println(">>>" + (System.currentTimeMillis()-start));
		//start = System.currentTimeMillis();
		//int[] prime_int = prime.stream().mapToInt(i -> i).toArray();
		//out.println(">>>" + (System.currentTimeMillis()-start));
		//start = System.currentTimeMillis();
		Integer currentObj = null;
		Integer cache = null;
		int current ;
		int current2 ;
		int cprime_int;
		int temp_sum;
		int pp ;
		int sum = 1;
		int test = 1;
		int prime_size =  prime.size();
		for (int i = 0; i < q; i++) {
			sum = 1;
			test = 1;
			currentObj = N.get(i);
			current = currentObj.intValue();//N[i];
			current2 = current/2;
			cache = ncache.get(currentObj);
			if (cache!=null) {
				out.println(cache.intValue());
				//out.println("1>>>" + (System.currentTimeMillis()-start));
				//start = System.currentTimeMillis();
			} else {
				//out.println("2>>>" + (System.currentTimeMillis()-start));
				//start = System.currentTimeMillis();
				for (int k = 0; k < prime_size; k++) {
					cprime_int = prime.get(k).intValue();
					if (cprime_int > current2 || test >= current)
						break;
					temp_sum = 0;
					pp = cprime_int;
					for (int j = 1; j < 100000; j++) {
						if (current % pp == 0) {
							temp_sum++;
							test *= cprime_int;
						} else
							break;
						pp *= cprime_int;
					}
					if (temp_sum > 0)
						sum = sum * (temp_sum + 1);
					
					if (primeset.contains(current/test)) {
						//out.println(current+" "+test+" "+cache.intValue());
						sum = sum * 2;
						break;
					}
				}
				//nprime.put(currentObj,new Integer(sum));
				out.println(sum);
			}
			//out.println("3>>>" + (System.currentTimeMillis()-start));
			//start = System.currentTimeMillis();
		}
		//out.println(">>>" + (System.currentTimeMillis()-start));
		//start = System.currentTimeMillis();

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
