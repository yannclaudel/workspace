package com.behavioral.state;

public abstract class State {
	public Agent agent;

	public State(Agent agent) {
		super();
		this.agent = agent;
	}

	public abstract int nextState();
}
