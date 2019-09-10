package com.structural.composite;

public class Test {

	public static void main(String[] args) {
		Child axel = new Child("Axel");
		Child eve = new Child("Eve");
		Child john = new Child("John");
		Child kim = new Child("Kim");
		
		Parent jack = new Parent("jack");
		Parent sam = new Parent("sam");
		
		sam.add(jack);
		sam.add(axel);
		sam.add(eve);
		jack.add(john);
		jack.add(kim);
		
		sam.sayHello();
	}

}
