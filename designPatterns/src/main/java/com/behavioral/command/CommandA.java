package com.behavioral.command;

public class CommandA extends Command {

	public CommandA(Receiver receiver) {
		super(receiver);
	}

	@Override
	public void execute() {
		System.out.println("A execute ...");
		receiver.doTask1();
		receiver.doTask2();
	}

}
