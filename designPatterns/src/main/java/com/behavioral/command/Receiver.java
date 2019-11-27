package com.behavioral.command;

import java.util.logging.Logger;

public class Receiver {
	private static Logger log = Logger.getLogger(Receiver.class.getName());
	public void doTask1() {
		log.info("Receiver is doing task1 ...");
	}
	public void doTask2() {
		log.info("Receiver is doing task2 ...");
	}
	public void doTask3() {
		log.info("Receiver is doing task3 ...");
	}
}
