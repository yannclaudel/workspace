package com.structural.decorator;

import java.util.logging.Logger;

public class DecoratorWithLog extends Decorator {

	private static Logger log = Logger.getLogger(DecoratorWithLog.class.getName());

	public DecoratorWithLog(final WhatToDo abs) {
		super(abs);
	}

	public void execute() {
		log.info("log before");
		abstraction.execute();
		log.info("log after");
	}
}
