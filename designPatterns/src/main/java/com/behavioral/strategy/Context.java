package com.behavioral.strategy;

public class Context {
	private Strategy strategy;

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public Context(Strategy strategy) {
		super();
		this.strategy = strategy;
	}
	
	public void executeStrategy() {
		strategy.execute();
	}
}
