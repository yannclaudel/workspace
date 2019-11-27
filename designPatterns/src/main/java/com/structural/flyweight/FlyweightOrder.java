package com.structural.flyweight;

import java.util.logging.Logger;

public class FlyweightOrder {
	private Product product;
	private int quantity;
	private static Logger log = Logger.getLogger(FlyweightOrder.class.getName());
	public FlyweightOrder(String productName, int quantity) {
		super();
		this.product = ProductCache.build(productName);
		this.quantity = quantity;
	}

	public void prepare() {
		log.info(()->"Prepare order : quantity = " + this.quantity + "\t product = " + product.getName() + " - "
				+ product.hashCode());
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

}
