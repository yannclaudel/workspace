package com.behavioral.state;

public class StateLow extends State {

	public StateLow(Agent agent) {
		super(agent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int nextState() {
		if (Agent.DOWN.equals(agent.getCurrentAction()))
			return -1;
		else {
			agent.setState(new StateMedium(agent));
			return +1;
		}
	}

	@Override
	public String toString() {
		return "StateLow";
	}
	

}
