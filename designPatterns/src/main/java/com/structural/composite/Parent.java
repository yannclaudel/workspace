package com.structural.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Parent extends Person {

	private List<Person> children = new ArrayList<>();
	private static Logger log = Logger.getLogger(Parent.class.getName());
	public Parent(String name) {
		super(name);
	}

	@Override
	public void sayHello() {
		log.info(()->"Hello I'm " + this.getName()+ " parent of >>>");
		for (Person person : children) {
			person.sayHello();
		}
		
	}

	public List<Person> getChildren() {
		return children;
	}

	public void add(Person person) {
		children.add(person);
	}

	public void remove(Person person) {
		children.remove(person);
	}
}
