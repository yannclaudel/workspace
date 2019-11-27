package com.behavioral.memento;

import java.util.logging.Logger;

public class Test {
	private static Logger log = Logger.getLogger(Test.class.getName());
	public static void main(String[] args) {
		Gardien gardien = new Gardien();
		Creator creator = new Creator("orignal", "otherData");
		log.info(creator.getState());

		gardien.addMemento(creator.saveToMemento());
		log.info(creator.changeState());

		creator.restoreFromMemento(gardien.getMemento(gardien.getLastIndex()));
		log.info(creator.getState());

	}

}
