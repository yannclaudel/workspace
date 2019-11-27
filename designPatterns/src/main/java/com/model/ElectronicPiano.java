package com.model;

import java.util.logging.Logger;

public class ElectronicPiano extends Piano {
	private static Logger log = Logger.getLogger(ElectronicPiano.class.getName());
	@Override
	public void playMusic() {
		log.info("play electronic piano ...");
	}

}
