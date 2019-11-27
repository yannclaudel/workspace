package com.model;

import java.util.logging.Logger;

public class AcousticGuitar extends Guitar {
	private static Logger log = Logger.getLogger(AcousticGuitar.class.getName());
	@Override
	public void playMusic() {
		log.info("play acoustic guitar ...");
	}

}
