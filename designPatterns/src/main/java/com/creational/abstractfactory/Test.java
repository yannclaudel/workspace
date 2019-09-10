package com.creational.abstractfactory;

import com.model.Guitar;
import com.model.MusicInstrument;
import com.model.Piano;

public class Test {

	public static void main(String[] args) {
		AcousticFactory acousticFactory = new AcousticFactory();
		ElectronicFactory electronicFactory = new ElectronicFactory();

		int choice = (int) Math.round(Math.random()) + 1;

		Guitar guitar = (Guitar) acousticFactory.createInstrument(AbstractFactory.GUITAR);
		Piano piano = (Piano) acousticFactory.createInstrument(AbstractFactory.PIANO);
		MusicInstrument instrument = electronicFactory.createInstrument(choice);
		guitar.playMusic();
		piano.playMusic();
		instrument.playMusic();

	}

}
