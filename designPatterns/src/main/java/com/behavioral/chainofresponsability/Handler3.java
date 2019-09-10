package com.behavioral.chainofresponsability;

public class Handler3 extends Handler {

	@Override
	public boolean check(int number) {
		if (number % 5 != 0) {
			return false;
		}
		System.out.println("Check Handler3 OK");
		return checkNext(number);
	}

}
