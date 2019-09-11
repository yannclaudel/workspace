package com.behavioral.state;

public class Test {
	public static void main(String[] args) {
		Agent agent = new Agent();
		
		for (int i = 0; i < 10; i++) {
			agent.changeState();
		}
	}
}
