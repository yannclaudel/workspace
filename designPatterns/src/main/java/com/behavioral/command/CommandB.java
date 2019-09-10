package com.behavioral.command;

public class CommandB extends Command {

	public CommandB(Receiver receiver) {
		super(receiver);
	}

	@Override
	public void execute() {
		System.out.println("B execute ...");
		receiver.doTask1();
		receiver.doTask3();
	}

}
