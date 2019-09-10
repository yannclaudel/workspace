package com.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Parent extends Person {

	private List<Person> children = new ArrayList<Person>();

	public Parent(String name) {
		super(name);
	}

	@Override
	public void sayHello() {
		System.out.println("Hello I'm " + this.getName()+ " parent of >>>");
		for (Person person : children) {
			person.sayHello();
		}
		System.out.println("<<<");
	}

	public List<Person> getChildren() {
		return children;
	}

	public void add(Person p) {
		children.add(p);
	}

	public void remove(Person p) {
		children.remove(p);
	}
}
