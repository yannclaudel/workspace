package com.behavioral.observer;

import java.util.logging.Logger;

public class Test {
	private static Logger log = Logger.getLogger(Test.class.getName());
	public static void main(String[] args) {
        Listener listen = new Listener();
        
        listen.addObserver(new MailObserver());
        listen.addObserver(new LogObserver());

        log.info("Say something : ");
        listen.listenSystemIn();
    }
}
