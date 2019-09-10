package com.structural.bridge;

public class ImplB implements Implementation {

	@Override
	public void execute1() {
		System.out.println("B execute 1 ...");
	}

	@Override
	public void execute2() {
		System.out.println("B execute 2 ...");
	}

}
