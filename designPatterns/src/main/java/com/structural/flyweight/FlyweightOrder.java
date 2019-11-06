package com.structural.flyweight;

public class FlyweightOrder {
	private Product product;
	private int quantity;

	public FlyweightOrder(String productName, int quantity) {
		super();
		this.product = ProductCache.build(productName);
		this.quantity = quantity;
	}

	public void prepare() {
		System.out.println("Prepare order : quantity = " + this.quantity + "\t product = " + product.getName() + " - "
				+ product.hashCode());
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

}
