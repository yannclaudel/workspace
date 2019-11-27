package com.creational.factory;

import com.model.Guitar;
import com.model.MusicInstrument;
import com.model.Piano;

public class Factory {
	public static final int GUITAR = 1;
	public static final int PIANO = 2;

	public MusicInstrument getObject(int type) {

		
		MusicInstrument instrument = null;
		switch (type) {
		case 1:
			instrument = new Guitar();
			break;
		case 2:
			instrument = new Piano();
			break;
		default:
			break;
		}
		return instrument;
	}
}
