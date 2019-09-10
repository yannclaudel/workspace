package com.creational.builder;

public class ConcreteBuilder2 extends Builder {

	@Override
	public void createAttributOne(String pAttributOne) {
		product.setAttributeOne("Builder 2 >>>" + pAttributOne);
	}

	@Override
	public void createAttributTwo(String pAttributTwo) {
		product.setAttributeTwo("Builder 2 >>>" + pAttributTwo);
	}

}
