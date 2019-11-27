package com.behavioral.strategy;

import java.util.logging.Logger;

public class Strategy1 implements Strategy {
	private static Logger log = Logger.getLogger(Strategy1.class.getName());
	@Override
	public void execute() {
		log.info("execute strategy 1 ....");
	}

}
