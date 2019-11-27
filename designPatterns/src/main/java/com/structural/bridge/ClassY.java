package com.structural.bridge;

import java.util.logging.Logger;

public class ClassY extends Abstract {

	private static Logger log = Logger.getLogger(ClassY.class.getName());

	protected ClassY(Implementation pimpl) {
		super(pimpl);
	}

	@Override
	public void execute() {
		log.info("Class Y execute ...");
		execute1();
		execute2();

	}

}
