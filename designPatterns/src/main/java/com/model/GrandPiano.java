package com.model;

import java.util.logging.Logger;

public class GrandPiano extends Piano {
	private static Logger log = Logger.getLogger(GrandPiano.class.getName());
	@Override
	public void playMusic() {
		log.info("play grand piano ...");
	}

}
