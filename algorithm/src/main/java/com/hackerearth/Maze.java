package com.hackerearth;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Maze {

	public static int[] getGroup(int[][] map, int i, int j) {
		int[] rtn = new int[2];
		rtn[0] = rtn[1] = 0;
		if (j > 0) {
			rtn[0] = map[i][j - 1];
		}
		return rtn;
	}

	public static void main(String[] args) throws Exception {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out), true);
		// Start writing your solution here. -------------------------------------
		int n = sc.nextInt();
		long start = System.currentTimeMillis();
		out.println(">>>"+(System.currentTimeMillis()-start));
		start = System.currentTimeMillis();
		int[][] map = new int[n][n];
		int newgroup = 1;
		Map<String, Integer> count = new HashMap<>();
		for (int i = 0; i < n; i++) {
			out.println(i+">>>"+(System.currentTimeMillis()-start));
			start = System.currentTimeMillis();
			char[] line = sc.next().toCharArray();
			out.println(i+">>>"+(System.currentTimeMillis()-start));
			start = System.currentTimeMillis();
			for (int j = 0; j < n; j++) {
				if (line[j] == 'W') {
					map[i][j] = 0;
				} else {
					int left = 0, up = 0;
					if (j > 0) {
						left = map[i][j - 1];
					}
					if (i > 0) {
						up = map[i - 1][j];
					}
					if (left == 0 && up == 0) {
						map[i][j] = newgroup;
						newgroup++;
					} else if (left > 0 && up == 0) {
						map[i][j] = left;
					} else if (left == 0 && up > 0) {
						map[i][j] = up;
					} else if (left > 0 && up > 0) {
						map[i][j] = up;
						for (int k = 0; k < i + 1; k++) {
							int end = n;
							if (k == i)
								end = j + 1;
							for (int k2 = 0; k2 < end; k2++) {
								if (map[k][k2] == left)
									map[k][k2] = up;
							}
						}
					}

				}
			}
		}
		out.println(">>>"+(System.currentTimeMillis()-start));
		start = System.currentTimeMillis();

		for (int k = 0; k < n; k++) {
			for (int k2 = 0; k2 < n; k2++) {
				if (map[k][k2] > 0) {
					Integer current = count.get(map[k][k2] + "");
					if (current == null)
						count.put(map[k][k2] + "", 1);

					else
						count.put(map[k][k2] + "", current.intValue() + 1);
				}
				//out.print(map[k][k2]);
			}
			//out.print("\n");
		}
		out.println(">>>"+(System.currentTimeMillis()-start));
		start = System.currentTimeMillis();
		int max = 0;
		for (String key : count.keySet()) {
			if (max < count.get(key))
				max = count.get(key);
			//out.println(key + " " + count.get(key));
		}
		out.print(">>>"+(System.currentTimeMillis()-start));
		start = System.currentTimeMillis();
		out.println(max);
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
