package com.behavioral.mediator;

import java.util.logging.Logger;

public class ComponentB extends Component {
	private static Logger log = Logger.getLogger(ComponentB.class.getName());

	public ComponentB(Mediator mediator) {
		super(mediator);
	}

	public void doingMyOwnStuff() {
		log.info("B I'm doingMyOwnStuff ...");
		mediator.notifyMe(this);
	}

}
