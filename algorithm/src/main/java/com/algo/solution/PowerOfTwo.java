package com.algo.solution;

import java.math.BigInteger;

public class PowerOfTwo {

	
	public static BigInteger sumOfPowerOfTwo0(int n) {
		long start = System.currentTimeMillis();
		BigInteger s = new BigInteger("0");
		BigInteger two = new BigInteger("2");
		for (int i = 0; i <= n; i++) {
			s=s.add(two.pow(i));
		}
		long time = System.currentTimeMillis()-start;
		System.out.println(">>> time="+time);
		return s;
	}
	
	public static BigInteger sumOfPowerOfTwo2(int n) {
		long start = System.currentTimeMillis();
		BigInteger s = new BigInteger("0");
		BigInteger two = new BigInteger("2");
		for (int i = 0; i <= n; i++) {
			s = s.multiply(two);
			s = s.add(BigInteger.ONE);
		}
		long time = System.currentTimeMillis()-start;
		System.out.println(">>> time="+time);
		return s;
	}
	
	public static BigInteger hash(long p, int a,int b,BigInteger x,long m) {
		
		x = x.multiply(new BigInteger(Integer.toString(a))).add(new BigInteger(Integer.toString(b)));
		x = x.mod(new BigInteger(Long.toString(p)));
		x = x.mod(new BigInteger(Long.toString(m)));
		return x;
	}
	
	public static void main(String[] args) {
		
		int n = 100000;
		System.out.println(sumOfPowerOfTwo0(n));
		System.out.println(sumOfPowerOfTwo2(n));
		
		for (int i = 1482567; i < 1482574; i++) {
			System.out.println("h("+i+")="+hash(10000019,34,2,new BigInteger(Integer.toString(i)),1000l));			
		}
		
	}
	
	
}
