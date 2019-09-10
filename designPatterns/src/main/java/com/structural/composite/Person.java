package com.structural.composite;

public abstract class Person {

	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract void sayHello();
}
