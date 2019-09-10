package com.behavioral.observer;

public class Test {
	public static void main(String[] args) {
        Listener listen = new Listener();
        
        listen.addObserver(new MailObserver());
        listen.addObserver(new LogObserver());

        System.out.println("Say something : ");
        listen.listenSystemIn();
    }
}
