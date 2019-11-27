package com.structural.facade;

import java.util.logging.Logger;

public class ClassB {
	private static Logger log = Logger.getLogger(ClassB.class.getName());
	public void performTaskB1() {		
		log.info("Task B1 is done");
	}

	public void performTaskB2() {		
		log.info("Task B2 is done");
	}
}
