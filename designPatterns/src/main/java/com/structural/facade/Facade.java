package com.structural.facade;

import java.util.logging.Logger;

public class Facade {
	private static Logger log = Logger.getLogger(Facade.class.getName());
	private ClassA classA = new ClassA();
	private ClassB classB = new ClassB();
	
	
	public void performTask1() {		
		log.info("\n>>> Task 1 is taskA1 + taskB1");
		classA.performTaskA1();
		classB.performTaskB1();
	}

	public void performTask2() {		
		log.info("\n>>> Task 2 is TaskA2");
		classA.performTaskA2();
	}

}
