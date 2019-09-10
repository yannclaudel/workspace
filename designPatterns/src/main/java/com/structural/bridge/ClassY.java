package com.structural.bridge;

public class ClassY extends Abstract {

	protected ClassY(Implementation pimpl) {
		super(pimpl);
	}

	@Override
	public void execute() {
		System.out.println("Class Y execute ...");
		execute1();
		execute2();
		System.out.println();
	}

}
