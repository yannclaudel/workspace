package com.structural.decorator;

public class DecoratorTest {

	public static void main(final String[] args) {
		final DecoratorWithLog decolog = new DecoratorWithLog(new Implementation());
		decolog.execute();
	}

}
