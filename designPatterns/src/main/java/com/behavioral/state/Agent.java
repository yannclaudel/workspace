package com.behavioral.state;

import java.util.logging.Logger;

public class Agent {

	public static final String UP = "UP";
	public static final String DOWN = "DOWN";
	private State state;
	private String currentAction;
	private int reward;
	private static Logger log = Logger.getLogger(Agent.class.getName());
	
	public Agent() {
		super();
		this.state = new StateMedium(this);
	}

	public void changeState() {
		
		log.info(()->"last >>> {}"+this.state.toString());
		if (Math.random() < 0.5) {
			currentAction = UP;
		} else {
			currentAction = DOWN;
		}
		reward += state.nextState();
		log.info(()->"\t>>> action >>> " + this.getCurrentAction() +"\t>>> new >>> " + this.state.toString() + "\t>>> reward >>> "+this.reward);
	}

	public State getState() {
		return state;
	}

	public int getReward() {
		return reward;
	}

	public String getCurrentAction() {
		return currentAction;
	}

	public void setState(State state) {
		this.state = state;
	}

}
