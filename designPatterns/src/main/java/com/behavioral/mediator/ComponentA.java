package com.behavioral.mediator;

import java.util.logging.Logger;

public class ComponentA extends Component {
	private static Logger log = Logger.getLogger(ComponentA.class.getName());

	public ComponentA(Mediator mediator) {
		super(mediator);
	}

	public void needOther() {
		mediator.doTaskX();
	}

	public void doingMyOwnStuff() {
		log.info("A I'm doingMyOwnStuff ...");
		mediator.notifyMe(this);
	}

}
