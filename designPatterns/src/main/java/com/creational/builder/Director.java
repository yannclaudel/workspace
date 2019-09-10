package com.creational.builder;

import com.model.Product;

public class Director {
	/**
	 * Constructs an object using the Builder interface.
	 */

	private Builder builder;

	public Director(Builder builder) {
		super();
		this.builder = builder;
	}

	public Product CreateProduct() {
		builder.createProduct();

		builder.createAttributOne("Director create attribute one");

		builder.createAttributTwo("Director create attribute two");

		return builder.getProduct();
	}
}
