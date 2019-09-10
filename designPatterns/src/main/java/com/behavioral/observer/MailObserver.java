package com.behavioral.observer;

public class MailObserver implements Observer {

	@Override
	public void update(String event) {
		this.mail(event);
	}

	public void mail(String msg) {
		System.out.println("send mail with the msg : " + msg);
	}


}
