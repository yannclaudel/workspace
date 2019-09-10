package com.behavioral.memento;

public class Test {

	public static void main(String[] args) {
		Gardien gardien = new Gardien();
		Creator creator = new Creator("orignal", "otherData");
		System.out.println(creator.getState());

		gardien.addMemento(creator.saveToMemento());
		System.out.println(creator.changeState());

		creator.restoreFromMemento(gardien.getMemento(gardien.getLastIndex()));
		System.out.println(creator.getState());

	}

}
