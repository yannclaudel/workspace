package com.behavioral.state;

public class StateHigh extends State {

	public StateHigh(Agent agent) {
		super(agent);
	}

	@Override
	public int nextState() {
		int rtn = 0;
		if (Agent.UP.equals(agent.getCurrentAction())) {
			rtn = -1;
		} else {
			agent.setState(new StateMedium(agent));
			rtn =  +1;
		}
		return rtn;
	}
	@Override
	public String toString() {
		return "StateHigh";
	}


}
