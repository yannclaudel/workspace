package com.structural.flyweight;

public class Test {

	public static void main(String[] args) {
		FlyweightOrder order1 = new FlyweightOrder("productA", 5);
		FlyweightOrder order2 = new FlyweightOrder("productA", 2);
		FlyweightOrder order3 = new FlyweightOrder("productB", 3);
		order1.prepare();
		order2.prepare();
		order3.prepare();
	}

}
