package com.model;

import java.util.logging.Logger;

public class Guitar implements MusicInstrument {
	private static Logger log = Logger.getLogger(Guitar.class.getName());
	@Override
	public void playMusic() {
		log.info("play guitar ...");
	}

}
