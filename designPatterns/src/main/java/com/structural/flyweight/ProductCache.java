package com.structural.flyweight;

import java.util.WeakHashMap;

public class ProductCache {
	private static final WeakHashMap<String, Product> list = new WeakHashMap<>();

	
    public static Product build(String key) {
            return list.computeIfAbsent(key, Product::new);
    }

}
