package com.datastructure.solution;

public class BitMaskingDemo {

	public static final int FLAG_1 = 1; // Binary 00001 {1}
	public static final int FLAG_2 = 2; // Binary 00010 {2}
	public static final int FLAG_3 = 4; // Binary 00100 {3}
	public static final int FLAG_4 = 8; // Binary 01000 {4}
	public static final int FLAG_5 = 16; // Binary 01000 {5}
	public static final int FLAG_12 = 3; // Binary 00011 {1,2}
	public static final int FLAG_23 = 6; // Binary 00110 {2,3}

	public static void main(String[] args) {
		// add {4} to {2,3}
		int E1 = FLAG_23 | FLAG_4;
		print("add {4} to {2,3}",E1);

		// create {6} and {7}
		final int FLAG_6 = 1 << 5;
		final int FLAG_7 = 1 << 6;
		print("FLAG_6 ",FLAG_6);
		print("FLAG_7 ",FLAG_7);

		// check if x is element of E1
		System.out.println("6 element of E1 ? " + ((FLAG_6 & E1) == FLAG_6));
		System.out.println("2 element of E1 ? " + ((FLAG_2 & E1) == FLAG_2));

		// remove 2 from E
		E1 = E1 & ~FLAG_2;
		print("remove 2 from E1",E1);
		
		// A = {1,2,3} A = {3,4,5}  
		int A = FLAG_1+FLAG_2+FLAG_3;
		int B = FLAG_3+FLAG_4+FLAG_5;
		print("A union B",A|B);
		print("A inter B",A&B);
		System.out.println("A is included in B ?" + ((A&B) == A));
		System.out.println("{3} is included in B ? " + (((1<<2) & A) == (1<<2)));
		print("min B",-B&B);
		
		
		int S = FLAG_1+FLAG_2+FLAG_3+FLAG_4+FLAG_5+FLAG_6;
		int N = 6;
		int K = 10;
		System.out.println("S =  " + S + " ={" +Integer.toBinaryString(S)+"}");
		int count = 0;
		for (int subset = 0; subset < S; subset++) {
			int sum = 0;
			for (int k = 0; k < N; k++) {
				int element = 1<<k;
				if ((subset&element)==element) sum+=(k+1);
			}
			//System.out.println("subset =  " + Integer.toBinaryString(subset) + " sum = " + sum);
			if (sum==K) {
				count++;
			}
		}
		System.out.println("count =  " + count);
	}
	
	private static void print(String msg, int n) {
		System.out.println(msg + "\t" + Integer.toBinaryString(n));
	}

}
