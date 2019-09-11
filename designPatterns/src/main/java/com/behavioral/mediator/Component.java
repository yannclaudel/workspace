package com.behavioral.mediator;

public abstract class Component {

	protected Mediator mediator;

	public Component(Mediator mediator) {
		super();
		this.mediator = mediator;
	}
	
}
