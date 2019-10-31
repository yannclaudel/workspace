package com.structural.proxy;

import com.model.Guitar;
import com.model.MusicInstrument;

public class Test {
	public static void main(String[] args) {
		
		Guitar guitar = new Guitar();
		MusicInstrument instrument = new ProxyGuitar(guitar);
		instrument.playMusic();
	}
}
