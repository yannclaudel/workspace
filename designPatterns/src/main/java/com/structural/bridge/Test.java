package com.structural.bridge;

public class Test {

	public static void main(String[] args) {
		Implementation implA = new ImplA();
		Implementation implB = new ImplB();

		ClassZ ZA = new ClassZ(implA);
		ClassZ ZB = new ClassZ(implB);
		ClassY YA = new ClassY(implA);
		ClassY YB = new ClassY(implB);
		
		ZA.execute();
		ZB.execute();
		YA.execute();
		YB.execute();
	}
}
