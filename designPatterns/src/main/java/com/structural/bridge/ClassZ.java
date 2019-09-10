package com.structural.bridge;

public class ClassZ extends Abstract {

	protected ClassZ(Implementation pimpl) {
		super(pimpl);
	}

	@Override
	public void execute() {
		System.out.println("Class Z execute ...");
		execute1();
		System.out.println();
	}

}
