package com.creational.prototype;

import java.util.logging.Logger;

public class ConcretePrototype extends Prototype {
	private static Logger log = Logger.getLogger(ConcretePrototype.class.getName());
	public ConcretePrototype(String pTexte) {
		super(pTexte);
	}

	@Override
	public void display() {
		log.info(()->"Display concrete proto  " + this.texte);
	}

}
