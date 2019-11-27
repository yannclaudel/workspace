package com.structural.bridge;

import java.util.logging.Logger;

public class ClassZ extends Abstract {
	private static Logger log = Logger.getLogger(ClassZ.class.getName());
	
	protected ClassZ(Implementation pimpl) {
		super(pimpl);
	}

	@Override
	public void execute() {
		log.info("Class Z execute ...");
		execute1();
	}

}
