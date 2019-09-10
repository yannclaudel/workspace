package com.behavioral.chainofresponsability;

public class Handler2 extends Handler {

	@Override
	public boolean check(int number) {
		if (number % 2 != 0) {
			return false;
		}
		System.out.println("Check Handler2 OK");
		return checkNext(number);
	}

}
