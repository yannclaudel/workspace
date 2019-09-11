package com.behavioral.mediator;

public class Test {

	public static void main(String[] args) {
		ConcreteMediator mediator = new ConcreteMediator();
		ComponentA A = new ComponentA(mediator);
		mediator.setA(A);
		ComponentC C = new ComponentC(mediator);
		mediator.setC(C);
		ComponentB B = new ComponentB(mediator);
		mediator.setB(B);
		
		A.doingMyOwnStuff();
		System.out.println();
		A.needOther();
		System.out.println();
		B.doingMyOwnStuff();
		System.out.println();
		C.doingMyOwnStuff();
		
		

	}

}
