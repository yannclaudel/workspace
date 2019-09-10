package com.behavioral.command;

public class Test {

	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		CommandA A = new CommandA(receiver);
		CommandB B = new CommandB(receiver);
		
		Invoker invoker = new Invoker();
		invoker.setA(A);
		invoker.setB(B);
		
		
		invoker.invokeA();
		invoker.invokeB();
		
	}

}
