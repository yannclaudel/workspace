package com.structural.decorator;

import java.util.logging.Logger;

public class Implementation implements WhatToDo {

	private static Logger log = Logger.getLogger(Implementation.class.getName());

	@Override
	public void execute() {
		log.info("execute ...");
	}

}
