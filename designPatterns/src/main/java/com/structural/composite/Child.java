package com.structural.composite;

import java.util.logging.Logger;

public class Child extends Person {
	private static Logger log = Logger.getLogger(Child.class.getName());

	public Child(String name) {
		super(name);
	}

	@Override
	public void sayHello() {
		log.info(()->"Hello I'm " + this.getName());
	}

}
