package com.behavioral.chainofresponsability;

public abstract class Handler {
	private Handler next;

	public Handler setNext(Handler next) {
		this.next = next;
		return next;
	}

	public abstract boolean check(int number);

	protected boolean checkNext(int number) {
		boolean rtn = true;
		if (next != null) {
			// throw new RuntimeException("unable to handle this request ...");
			rtn = next.check(number);
		}
		return rtn;
	}
}
