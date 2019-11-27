package com.structural.facade;

import java.util.logging.Logger;

public class ClassA{
	
	private static Logger log = Logger.getLogger(ClassA.class.getName());
	
	public void performTaskA1() {		
		log.info("Task A1 is done");
	}

	public void performTaskA2() {		
		log.info("Task A2 is done");
	}
}
