package com.behavioral.command;

public class Invoker {
	private CommandA A;
	private CommandB B;
	
	public void invokeA() {
		if (A!=null) A.execute();
	}

	public void invokeB() {
		if (B!=null) B.execute();
	}

	public void setA(CommandA a) {
		A = a;
	}
	public void setB(CommandB b) {
		B = b;
	}
	

}
