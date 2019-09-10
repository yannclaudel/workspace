package com.creational.abstractfactory;

import com.model.ElectricGuitar;
import com.model.ElectronicPiano;
import com.model.MusicInstrument;

public class ElectronicFactory implements AbstractFactory {

	@Override
	public MusicInstrument createInstrument(int TYPE) {
		MusicInstrument instrument = null;
		switch (TYPE) {
		case 1:
		case 12:
			instrument = new ElectricGuitar();
			break;
		case 2:
		case 22:
			instrument = new ElectronicPiano();
			break;
		default:
			break;
		}
		return instrument;
	}

}
