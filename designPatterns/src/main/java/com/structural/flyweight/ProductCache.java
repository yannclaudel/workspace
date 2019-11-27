package com.structural.flyweight;

import java.util.WeakHashMap;

public class ProductCache {
	private static final WeakHashMap<String, Product> LIST = new WeakHashMap<>();

	
    public static Product build(String key) {
            return LIST.computeIfAbsent(key, Product::new);
    }

}
