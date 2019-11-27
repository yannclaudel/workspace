package com.structural.bridge;

public class BridgeTest {

	public static void main(final String[] args) {
		final Implementation implA = new ImplA();
		final Implementation implB = new ImplB();

		final ClassZ ZA = new ClassZ(implA);
		final ClassZ ZB = new ClassZ(implB);
		final ClassY YA = new ClassY(implA);
		final ClassY YB = new ClassY(implB);
		
		ZA.execute();
		ZB.execute();
		YA.execute();
		YB.execute();
	}
}
