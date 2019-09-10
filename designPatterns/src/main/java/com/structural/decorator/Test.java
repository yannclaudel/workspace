package com.structural.decorator;

public class Test {

	public static void main(String[] args) {
		IDecoratorWithLog decolog = new IDecoratorWithLog(new Implementation());
		decolog.execute();
	}

}
