package com.behavioral.mediator;

public class ComponentB extends Component {

	public ComponentB(Mediator mediator) {
		super(mediator);
	}
	
	public void doingMyOwnStuff() {
		System.out.println("B I'm doingMyOwnStuff ...");
		mediator.notifyMe(this);
	}

}
