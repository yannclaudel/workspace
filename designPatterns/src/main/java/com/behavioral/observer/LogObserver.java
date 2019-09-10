package com.behavioral.observer;

public class LogObserver implements Observer {

	@Override
	public void update(String event) {
		this.log(event);
	}

	public void log(String msg) {
		System.out.println("print log " + msg);
	}

}
