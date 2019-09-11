package com.behavioral.strategy;

public class Test {
	public static void main(String[] args) {
		Strategy strategy1 = new Strategy1();
		Strategy strategy2 = new Strategy2();
		
		Context context = new Context(strategy1);
		
		context.executeStrategy();
		context.setStrategy(strategy2);
		context.executeStrategy();
		
	}
}
