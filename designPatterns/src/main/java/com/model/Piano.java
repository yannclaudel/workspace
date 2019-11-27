package com.model;

import java.util.logging.Logger;

public class Piano implements MusicInstrument {
	private static Logger log = Logger.getLogger(Piano.class.getName());

	@Override
	public void playMusic() {
		log.info("play piano ...");
	}

}
