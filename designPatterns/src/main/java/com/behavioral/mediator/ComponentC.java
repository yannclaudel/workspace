package com.behavioral.mediator;

public class ComponentC extends Component {

	public ComponentC(Mediator mediator) {
		super(mediator);
	}
	
	public void doingMyOwnStuff() {
		System.out.println("C I'm doingMyOwnStuff ...");
		mediator.notifyMe(this);
	}

}
