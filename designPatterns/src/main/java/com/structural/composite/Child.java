package com.structural.composite;

public class Child extends Person {

	public Child(String name) {
		super(name);
	}

	@Override
	public void sayHello() {
		System.out.println("Hello I'm "+this.getName());
	}

}
