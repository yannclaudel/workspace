package com.behavioral.mediator;

public class MediatorTest {
	public static void main(String[] args) {
		ConcreteMediator mediator = new ConcreteMediator();
		ComponentA compoA = new ComponentA(mediator);
		mediator.setA(compoA);
		ComponentC compoC = new ComponentC(mediator);
		mediator.setC(compoC);
		ComponentB compoB = new ComponentB(mediator);
		mediator.setB(compoB);

		compoA.doingMyOwnStuff();
		compoA.needOther();
		compoB.doingMyOwnStuff();
		compoC.doingMyOwnStuff();

	}

}
