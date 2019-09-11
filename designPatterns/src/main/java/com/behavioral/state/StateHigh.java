package com.behavioral.state;

public class StateHigh extends State {

	public StateHigh(Agent agent) {
		super(agent);
	}

	@Override
	public int nextState() {
		if (Agent.UP.equals(agent.getCurrentAction()))
			return -1;
		else {
			agent.setState(new StateMedium(agent));
			return +1;
		}
	}
	@Override
	public String toString() {
		return "StateHigh";
	}


}
