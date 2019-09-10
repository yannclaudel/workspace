package com.behavioral.chainofresponsability;

public abstract class Handler {
	private Handler next;

	public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(int number);

    protected boolean checkNext(int number) {
        if (next == null) {
        	//throw new RuntimeException("unable to handle this request ...");
            return true;
        }
        return next.check(number);
    }
}
