package com.behavioral.visitor;

public class Test {

	public static void main(String[] args) {
		ElementA a = new ElementA("aaaaaaaaaa");
		ElementB b = new ElementB("bbbbbbbbbb");
		ElementC c = new ElementC("cccccccccc");
		
		Visitor1 visitor1 = new Visitor1();
		Visitor2 visitor2 = new Visitor2();
		
		a.accept(visitor1);
		b.accept(visitor2);
		c.accept(visitor1);
		a.accept(visitor2);
	}

}
