package com.structural.facade;

public class Facade {
	
	private ClassA a = new ClassA();
	private ClassB b = new ClassB();
	
	public void performTask1() {		
		System.out.println("\n>>> Task 1 is taskA1 + taskB1");
		a.performTaskA1();
		b.performTaskB1();
	}

	public void performTask2() {		
		System.out.println("\n>>> Task 2 is TaskA2");
		a.performTaskA2();
	}

}
