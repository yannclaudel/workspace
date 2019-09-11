package com.behavioral.state;

public class StateMedium extends State {

	public StateMedium(Agent agent) {
		super(agent);
	}

	@Override
	public int nextState() {
		if (Agent.DOWN.equals(agent.getCurrentAction())) {
			agent.setState(new StateLow(agent));
			return +1;
		} else {
			agent.setState(new StateHigh(agent));
			return +1;
		}
	}
	@Override
	public String toString() {
		return "StateMedium";
	}


}
