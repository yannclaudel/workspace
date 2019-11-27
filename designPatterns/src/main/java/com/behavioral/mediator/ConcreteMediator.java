package com.behavioral.mediator;

import java.util.logging.Logger;

public class ConcreteMediator implements Mediator {
	private static Logger log = Logger.getLogger(ConcreteMediator.class.getName());
	private ComponentA compA = null;
	private ComponentB compB = null;
	private ComponentC compC = null;

	public void setA(ComponentA a) {
		compA = a;
	}

	public void setB(ComponentB compB) {
		this.compB = compB;
	}

	public void setC(ComponentC comC) {
		this.compC = comC;
	}


	@Override
	public void notifyMe(Component e) {
		if ("com.behavioral.mediator.ComponentA".equals(e.getClass().getName())) {
			compC.doingMyOwnStuff();
		}
		if ("com.behavioral.mediator.ComponentB".equals(e.getClass().getName())) {
			compC.doingMyOwnStuff();
		}
	}

	public void doTaskX() {
		log.info("Mediator is doing X");
		compB.doingMyOwnStuff();
	}

}
