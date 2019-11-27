package com.behavioral.state;

public class StateMedium extends State {

	public StateMedium(Agent agent) {
		super(agent);
	}

	@Override
	public int nextState() {
		int rtn = 0;
		if (Agent.DOWN.equals(agent.getCurrentAction())) {
			agent.setState(new StateLow(agent));
			rtn = +1;
		} else {
			agent.setState(new StateHigh(agent));
			rtn = +1;
		}
		return rtn;
	}
	@Override
	public String toString() {
		return "StateMedium";
	}


}
