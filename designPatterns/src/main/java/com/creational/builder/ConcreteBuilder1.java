package com.creational.builder;

public class ConcreteBuilder1 extends Builder {

	@Override
	public void createAttributOne(String pAttributOne) {
		product.setAttributeOne("Builder 1 >>>" + pAttributOne);
	}

	@Override
	public void createAttributTwo(String pAttributTwo) {
		product.setAttributeTwo("Builder 1 >>>" + pAttributTwo);
	}

}
