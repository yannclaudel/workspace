package com.behavioral.command;

import java.util.logging.Logger;

public class CommandA extends Command {

	private static Logger log = Logger.getLogger(CommandA.class.getName());

	public CommandA(Receiver receiver) {
		super(receiver);
	}

	@Override
	public void execute() {
		log.info("A execute ...");
		receiver.doTask1();
		receiver.doTask2();
	}

}
