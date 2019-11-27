package com.behavioral.command;

import java.util.logging.Logger;

public class CommandB extends Command {
	private static Logger log = Logger.getLogger(CommandB.class.getName());
	public CommandB(Receiver receiver) {
		super(receiver);
	}

	@Override
	public void execute() {
		log.info("B execute ...");
		receiver.doTask1();
		receiver.doTask3();
	}

}
