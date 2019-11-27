package com.behavioral.observer;

import java.util.logging.Logger;

public class LogObserver implements Observer {
	private static Logger log = Logger.getLogger(LogObserver.class.getName());
	@Override
	public void update(String event) {
		this.log(event);
	}

	public void log(String msg) {
		log.info(()->"print log " + msg);
	}

}
