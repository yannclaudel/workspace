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
		
		BigInteger rtn = x.multiply(new BigInteger(Integer.toString(a))).add(new BigInteger(Integer.toString(b)));
		rtn = rtn.mod(new BigInteger(Long.toString(p)));
		rtn = rtn.mod(new BigInteger(Long.toString(m)));
		return rtn;
	}
	
	public static void main(String[] args) {
		
		final int n = 100_000;
		System.out.println(sumOfPowerOfTwo0(n));
		System.out.println(sumOfPowerOfTwo2(n));
		
		for (int i = 1_482_567; i < 1_482_574; i++) {
			System.out.println("h("+i+")="+hash(10_000_019,34,2,new BigInteger(Integer.toString(i)),1000l));			
		}
		
	}
	
	
}
