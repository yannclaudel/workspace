package com.behavioral.mediator;

public class ComponentA extends Component {

	public ComponentA(Mediator mediator) {
		super(mediator);
	}

	
	public void needOther() {
		mediator.doTaskX();
	}
	
	public void doingMyOwnStuff() {
		System.out.println("A I'm doingMyOwnStuff ...");
		mediator.notifyMe(this);
	}

}
