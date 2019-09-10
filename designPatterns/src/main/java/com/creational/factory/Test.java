package com.creational.factory;

import com.model.Guitar;
import com.model.MusicInstrument;
import com.model.Piano;

public class Test {

	public static void main(String[] args) {
		Factory factory = new Factory();
		int choice = (int) Math.round(Math.random()) + 1;

		Guitar guitar = (Guitar) factory.getObject(Factory.GUITAR);
		Piano piano = (Piano) factory.getObject(Factory.PIANO);
		MusicInstrument instrument = factory.getObject(choice);
		guitar.playMusic();
		piano.playMusic();
		instrument.playMusic();

	}

}
