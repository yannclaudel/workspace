package com.structural.bridge;

import java.util.logging.Logger;

public class ImplB implements Implementation {

	private static Logger log = Logger.getLogger(ImplB.class.getName());
	@Override
	public void execute1() {
		log.info("B execute 1 ...");
	}

	@Override
	public void execute2() {
		log.info("B execute 2 ...");
	}

}
