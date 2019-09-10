package com.behavioral.chainofresponsability;

public class Handler1 extends Handler {

	@Override
	public boolean check(int number) {
		
		if (number % 3 != 0) {
			return false;
		}
		System.out.println("Check Handler1 OK");
		return checkNext(number);
	}

}
