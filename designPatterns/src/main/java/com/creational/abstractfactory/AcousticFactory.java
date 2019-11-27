package com.creational.abstractfactory;

import com.model.AcousticGuitar;
import com.model.GrandPiano;
import com.model.MusicInstrument;

public class AcousticFactory implements AbstractFactory {
	@Override
	public MusicInstrument createInstrument(int type) {
		MusicInstrument instrument = null;
		switch (type) {
		case 1:
		case 11:
			instrument = new AcousticGuitar();
			break;
		case 2:
		case 21:
			instrument = new GrandPiano();
			break;
		default:
			break;
		}
		return instrument;
	}

}
