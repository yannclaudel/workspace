package com.model;

import java.util.logging.Logger;

public class ElectricGuitar extends Guitar {
	private static Logger log = Logger.getLogger(ElectricGuitar.class.getName());
	@Override
	public void playMusic() {
		log.info("play electric guitar ...");
	}

}
