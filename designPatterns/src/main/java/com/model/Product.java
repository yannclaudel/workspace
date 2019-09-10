package com.model;

public class Product {
	private String attributeOne;
	private String attributeTwo;

	public void execute() {
		System.out.println("execute ...");
		System.out.println(attributeOne);
		System.out.println(attributeTwo);
	}

	public String getAttributeOne() {
		return attributeOne;
	}

	public void setAttributeOne(String attributeOne) {
		this.attributeOne = attributeOne;
	}

	public String getAttributeTwo() {
		return attributeTwo;
	}

	public void setAttributeTwo(String attributeTwo) {
		this.attributeTwo = attributeTwo;
	}

}
