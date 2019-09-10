package com.structural.flyweight;

import java.util.WeakHashMap;

public class Product {
	private String name;
	private static final WeakHashMap<String, Product> list = new WeakHashMap<>();

	public Product(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
    public static Product build(String name) {
            return list.computeIfAbsent(name, Product::new);
    }

}
