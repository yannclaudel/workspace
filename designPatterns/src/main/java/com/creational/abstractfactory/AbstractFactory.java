package com.creational.abstractfactory;

import com.model.MusicInstrument;

public interface AbstractFactory {
	int GUITAR = 1;
	int AGUITAR = 11;
	int EGUITAR = 12;

	int PIANO = 2;
	int APIANO = 21;
	int EPIANO = 22;

	MusicInstrument createInstrument(int type);
	}
