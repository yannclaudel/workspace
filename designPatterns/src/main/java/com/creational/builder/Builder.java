package com.creational.builder;

import com.model.Product;

public abstract class Builder {
	/**
	 * Specifies an abstract interface for creating parts of a Product object
	 */

	protected Product product;

	public void createProduct() {
		product = new Product();
	}

	public Product getProduct() {
		return product;
	}

	public abstract void createAttributOne(String pAttributOne);

	public abstract void createAttributTwo(String pAttributTwo);
}
