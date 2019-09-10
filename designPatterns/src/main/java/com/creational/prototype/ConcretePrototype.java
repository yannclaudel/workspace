package com.creational.prototype;

public class ConcretePrototype extends Prototype {

	public ConcretePrototype(String pTexte) {
		super(pTexte);
	}

	@Override
	public void display() {
		System.out.println("Display concrete proto  " + this.texte);
	}

}
