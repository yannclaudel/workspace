package com.behavioral.mediator;

import java.util.logging.Logger;

public class ComponentC extends Component {
	private static Logger log = Logger.getLogger(ComponentC.class.getName());

	public ComponentC(Mediator mediator) {
		super(mediator);
	}

	public void doingMyOwnStuff() {
		log.info("C I'm doingMyOwnStuff ...");
		mediator.notifyMe(this);
	}

}
