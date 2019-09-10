package com.structural.bridge;

public class ImplA implements Implementation {

	@Override
	public void execute1() {
		System.out.println("A execute 1 ...");
	}

	@Override
	public void execute2() {
		System.out.println("A execute 2 ...");
	}

}
