package com.behavioral.strategy;

import java.util.logging.Logger;

public class Strategy2 implements Strategy {
	private static Logger log = Logger.getLogger(Strategy2.class.getName());
	@Override
	public void execute() {
		log.info("execute strategy 2 ....");
	}

}
