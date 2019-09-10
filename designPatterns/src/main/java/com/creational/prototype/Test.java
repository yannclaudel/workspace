package com.creational.prototype;

public class Test {

	public static void main(String[] args) throws CloneNotSupportedException {
		Prototype proto = new ConcretePrototype("Original");
		
		Prototype clone = proto.clone();
		
		proto.display();
		clone.display();
			
		clone.setTexte("Clone");

		proto.display();
		clone.display();

	}

}
