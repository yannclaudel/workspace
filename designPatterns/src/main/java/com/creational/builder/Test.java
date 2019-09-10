package com.creational.builder;

import com.model.Product;

public class Test {

	public static void main(String[] args) {
		ConcreteBuilder1 builder1 = new ConcreteBuilder1();
		ConcreteBuilder2 builder2 = new ConcreteBuilder2();
		
		Director directorA = new Director(builder1);
		Director directorB = new Director(builder2);
		
		Product A = directorA.CreateProduct();
		Product B = directorB.CreateProduct();
		
		A.execute();
		B.execute();
	}

}
