package com.behavioral.state;

public class StateLow extends State {

	public StateLow(Agent agent) {
		super(agent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int nextState() {
		int rtn = 0;
		if (Agent.DOWN.equals(agent.getCurrentAction())) {
			rtn = -1;
		} else {
			agent.setState(new StateMedium(agent));
			rtn = +1;
		}
		return rtn;
	}

	@Override
	public String toString() {
		return "StateLow";
	}
	

}
