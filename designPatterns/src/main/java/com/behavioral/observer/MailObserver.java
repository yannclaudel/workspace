package com.behavioral.observer;

import java.util.logging.Logger;

public class MailObserver implements Observer {
	private static Logger log = Logger.getLogger(MailObserver.class.getName());
	@Override
	public void update(String event) {
		this.mail(event);
	}

	public void mail(String msg) {
		log.info(()->"send mail with the msg : " + msg);
	}


}
