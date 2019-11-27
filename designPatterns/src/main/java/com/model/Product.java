package com.model;

import java.util.logging.Logger;

public class Product {
	private String attributeOne;
	private String attributeTwo;
	private static Logger log = Logger.getLogger(Product.class.getName());
	public void execute() {
		log.info("execute ...");
		log.info(attributeOne);
		log.info(attributeTwo);
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
