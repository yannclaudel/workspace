package com.behavioral.chainofresponsability;

public class Test {

	
	public static void main(String [] args) {
	Handler handlerRoot = new Handler1();
	handlerRoot.setNext(new Handler2()).setNext(new Handler3());
	
	System.out.println("30 >>> "+handlerRoot.check(30));
	System.out.println("36 >>> "+handlerRoot.check(36));
	System.out.println("10 >>> "+handlerRoot.check(10));
	
	}
	
	
}
