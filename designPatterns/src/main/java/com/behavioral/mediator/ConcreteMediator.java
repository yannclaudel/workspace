package com.behavioral.mediator;

public class ConcreteMediator implements Mediator {

	ComponentA A = null;
	ComponentB B = null;
	ComponentC C = null;
	
	public void setA(ComponentA a) {
		A = a;
	}

	public void setB(ComponentB b) {
		B = b;
	}

	public void setC(ComponentC c) {
		C = c;
	}

	public ConcreteMediator() {
		super();
	}

	@Override
	public void notifyMe(Component e) {
		if ("com.behavioral.mediator.ComponentA".equals(e.getClass().getName()))
			C.doingMyOwnStuff();
		if ("com.behavioral.mediator.ComponentB".equals(e.getClass().getName()))
			C.doingMyOwnStuff();
	}
	
	public void doTaskX(){
		System.out.println("Mediator is doing X");
		B.doingMyOwnStuff();
	}

	
}
