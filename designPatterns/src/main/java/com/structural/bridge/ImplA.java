package com.structural.bridge;

import java.util.logging.Logger;

public class ImplA implements Implementation {

	private static Logger log = Logger.getLogger(ImplA.class.getName());
	
	@Override
	public void execute1() {
		log.info("A execute 1 ...");
	}

	@Override
	public void execute2() {
		log.info("A execute 2 ...");
	}

}
